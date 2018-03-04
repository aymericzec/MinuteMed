package fr.devsquad.minutemed.dmp.rest;

import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.repository.ArborescenceRepository;
import fr.devsquad.minutemed.dmp.domain.dto.DiagnosticDTO;
import fr.devsquad.minutemed.dmp.domain.dto.DosageDTO;
import fr.devsquad.minutemed.dmp.domain.dto.ExamDTO;
import fr.devsquad.minutemed.dmp.domain.dto.MedicalRecordDTO;
import fr.devsquad.minutemed.dmp.domain.dto.PrescriptionDTO;
import fr.devsquad.minutemed.dmp.repository.DiagnosticRepository;
import fr.devsquad.minutemed.dmp.repository.DosageRepository;
import fr.devsquad.minutemed.dmp.repository.ExamRepository;
import fr.devsquad.minutemed.dmp.repository.MedicalRecordRepository;
import fr.devsquad.minutemed.dmp.repository.PrescriptionRepository;
import fr.devsquad.minutemed.dmp.repository.ReportDosageRepository;
import fr.devsquad.minutemed.dmp.repository.ResultExamRepository;
import fr.devsquad.minutemed.jwt.filter.JWTNeeded;
import fr.devsquad.minutemed.jwt.utils.TokenUtils;
import fr.devsquad.minutemed.staff.domain.MedicalStaff;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import io.swagger.annotations.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/records")
@Api("MedicalRecords REST Endpoint")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordService {
    
    @EJB
    private MedicalRecordRepository medicalRecordRepository;
    
    @EJB
    private ArborescenceRepository arborescenceRepository;
    
    @EJB
    private ExamRepository examRepository;
    
    @EJB
    private DiagnosticRepository diagnosticRepository;
    
    @EJB
    private PrescriptionRepository prescriptionRepository;
    
    @EJB
    private DosageRepository dosageRepository;
    
    @EJB
    private ResultExamRepository resultExamRepository;
    
    @EJB
    private ReportDosageRepository reportDosageRepository;
    
    @EJB
    private StaffRepository staffRepository;
    
    @Inject
    private TokenUtils tokenUtils;
    
    //Example URL with params : 
    //http://localhost:8080/ProjetMinuteMed/api/records/4/dosages/5
    
    /////////////////////////
    //// POST
    /////////////////////////
    
    
    @POST
    @ApiOperation(value = "Create a medical record")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response createMedicalRecord(@NotNull MedicalRecordDTO medicalRecord) {
        if(medicalRecordRepository.findBySS(medicalRecord.getSs()) != null){
            return Response.status(Response.Status.CONFLICT).entity("This MedicalRecord already exist !").build();
        }
        Long id = medicalRecordRepository.save(medicalRecord.toMedicalRecord(arborescenceRepository));
        return Response.status(Response.Status.CREATED).entity("{\"idMedicalRecord\":"+ id +"}").build();
    }
    
    
    @POST
    @Path("{idRecord}/exams")
    @ApiOperation(value = "Create an Exam in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response createExam(@PathParam("idRecord") Long idRecord, @NotNull ExamDTO exam) {
        Long id = examRepository.save(exam.toExam(staffRepository, medicalRecordRepository));
        return Response.status(Response.Status.CREATED).entity("{\"idExam\":"+ id +"}").build();
    }
    
    @POST
    @Path("{idRecord}/diagnostics")
    @ApiOperation(value = "Create a Diagnostic in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response createDiagnostic(@PathParam("idRecord") Long idRecord, @NotNull DiagnosticDTO diagnostic) {
        Long id = diagnosticRepository.save(diagnostic.toDiagnostic(staffRepository, medicalRecordRepository));
        return Response.status(Response.Status.CREATED).entity("{\"idDiagnostic\":"+ id +"}").build();
    }
    
    @POST
    @Path("{idRecord}/prescriptions")
    @ApiOperation(value = "Create a Prescription in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response createPrescription(@PathParam("idRecord") Long idRecord, @NotNull PrescriptionDTO prescription) {
        Long id = prescriptionRepository.save(prescription.toPrescription(staffRepository, medicalRecordRepository, diagnosticRepository));
        return Response.status(Response.Status.CREATED).entity("{\"idPrescription\":"+ id +"}").build();
    }
    
    @POST
    @Path("{idRecord}/dosages")
    @ApiOperation(value = "Create a Dosage in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response createDosage(@PathParam("idRecord") Long idRecord, @NotNull DosageDTO dosage) {
        Long id = dosageRepository.save(dosage.toDosage(staffRepository, medicalRecordRepository, diagnosticRepository));
        return Response.status(Response.Status.CREATED).entity("{\"idDosage\":"+ id +"}").build();
    }
    
    
    /////////////////////////
    //// DELETE
    /////////////////////////
    
    //TODO: surement à supprimer
    
    @DELETE
    @Path("{idRecord}")
    @ApiOperation(value = "Delete a Medical Record.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response deleteMedicalRecord(@PathParam("idRecord") Long idRecord) {
        medicalRecordRepository.delete(idRecord);
        return Response.ok("{\"idRecord\":"+idRecord+"}").build();
    }
    
    @DELETE
    @Path("{idRecord}/exams/{idExam}")
    @ApiOperation(value = "Delete an Exam.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Exam not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response deleteExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        examRepository.delete(idExam);
        return Response.ok("{\"idRecord\":"+idRecord+", \"idExam\":"+idExam+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @ApiOperation(value = "Delete a Diagnostic.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Diagnostic not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response deleteDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        diagnosticRepository.delete(idDiagnostic);
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDiagnostic\":"+idDiagnostic+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @ApiOperation(value = "Delete a Prescription.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Prescription not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response deletePrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        prescriptionRepository.delete(idPrescription);
        return Response.ok("{\"idRecord\":"+idRecord+", \"idPrescription\":"+idPrescription+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/dosages/{idDosage}")
    @ApiOperation(value = "Delete a Dosage.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Dosage not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response deleteDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        dosageRepository.delete(idDosage);
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDosage\":"+idDosage+" }").build();
    }
    
    
    
    
    /////////////////////////
    //// GET
    /////////////////////////
    
    
    @GET
    @ApiOperation(value = "Get all Medical Records.", response = MedicalRecordDTO.class, responseContainer = "Set")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Medical Records are returned.")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getAllMedicalRecord(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer".length()).trim();
        Long id = tokenUtils.decryptIdFromToken(token);
        MedicalStaff doctor = staffRepository.findMedicalStaff(id);
        Node node = doctor.getNode();
        Set<MedicalRecordDTO> medicalRecords = node.getMedicalRecords().stream().map(MedicalRecordDTO::create).collect(Collectors.toSet());
        return Response.ok(medicalRecords).build();
    }
    
    @GET
    @Path("{idRecord}")
    @ApiOperation(value = "Get a specific Medical Record.", response = MedicalRecordDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getMedicalRecord(@PathParam("idRecord") Long idRecord) {
        MedicalRecordDTO m = MedicalRecordDTO.create(medicalRecordRepository.find(idRecord));
        return Response.ok(m).build();
    }
    
    @GET
    @Path("{idRecord}/exams")
    @ApiOperation(value = "Get all Exams associated with a Medical Record.", response = ExamDTO.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Exams are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getExams(@PathParam("idRecord") Long idRecord) {
        System.out.println("TOTOTOTOTO " + idRecord);
        List<ExamDTO> exams = examRepository.list(idRecord).stream().map(ExamDTO::create).collect(Collectors.toList());
        System.out.println("Taille: " + exams.size());
        return Response.ok(exams).build();
    }
    
    @GET
    @Path("{idRecord}/exams/{idExam}")
    @ApiOperation(value = "Get a specific Exam associated with a Medical Record.", response = ExamDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Exam not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        ExamDTO exam = ExamDTO.create(examRepository.find(idExam));
        return Response.ok(exam).build();
    }
    
    @GET
    @Path("{idRecord}/diagnostics")
    @ApiOperation(value = "Get all Diagnostics associated with a Medical Record.", response = DiagnosticDTO.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Diagnostics are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getDiagnostics(@PathParam("idRecord") Long idRecord) {
        List<DiagnosticDTO> diagnostics = diagnosticRepository.list(idRecord).stream().map(DiagnosticDTO::create).collect(Collectors.toList());
        return Response.ok(diagnostics).build();
    }
    
    
    @GET
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @ApiOperation(value = "Get a specific Diagnostic associated with a Medical Record.", response = DiagnosticDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Diagnostic not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        DiagnosticDTO diagnostic = DiagnosticDTO.create(diagnosticRepository.find(idDiagnostic));
        return Response.ok(diagnostic).build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions")
    @ApiOperation(value = "Get all Prescriptions associated with a Medical Record.", response = PrescriptionDTO.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Prescriptions are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getPrescriptions(@PathParam("idRecord") Long idRecord) {
        List<PrescriptionDTO> prescriptions = prescriptionRepository.list(idRecord).stream().map(PrescriptionDTO::create).collect(Collectors.toList());
        return Response.ok(prescriptions).build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @ApiOperation(value = "Get a specific Prescription associated with a Medical Record.", response = PrescriptionDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Prescription not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getPrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        PrescriptionDTO prescription = PrescriptionDTO.create(prescriptionRepository.find(idPrescription));
        return Response.ok(prescription).build();
    }
    
    @GET
    @Path("{idRecord}/dosages")
    @ApiOperation(value = "Get all Dosages associated with a Medical Record.", response = DosageDTO.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Dosages are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getAllDosages(@PathParam("idRecord") Long idRecord) {
        List<DosageDTO> dosages = dosageRepository.list(idRecord).stream().map(DosageDTO::create).collect(Collectors.toList());
        return Response.ok(dosages).build();
    }
    
    @GET
    @Path("{idRecord}/dosages/{idDosage}")
    @ApiOperation(value = "Get a specific Dosage associated with a Medical Record.", response = DosageDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Dosage not found")}
    ) 
    @JWTNeeded(groups = {StaffEnum.DOCTOR, StaffEnum.NURSE})
    public Response getDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        DosageDTO dosage = DosageDTO.create(dosageRepository.find(idDosage));
        return Response.ok(dosage).build();
    }  

}
