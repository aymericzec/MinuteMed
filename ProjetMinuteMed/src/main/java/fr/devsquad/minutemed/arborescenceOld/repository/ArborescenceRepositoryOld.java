package fr.devsquad.minutemed.arborescenceOld.repository;

import fr.devsquad.minutemed.arborescenceOld.domain.NodeOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeAPHPOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeServiceOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeCUOld;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ArborescenceRepositoryOld {

    @PersistenceContext(unitName = "APHPPU")
    private EntityManager em;

    /**
     * Get all hospitals of the APHP
     *
     * @return A List of NodeHospital
     */
    public List<NodeHospitalOld> listNodeHospital() {
        return em.createNamedQuery(NodeHospitalOld.FIND_ALL_NODEHOSPITAL, NodeHospitalOld.class).getResultList();
    }

    /**
     * Get all poles of an hospital
     *
     * @param idHospital The id of the hospital
     * @return A List of NodePole
     */
    public List<NodePoleOld> listNodePole(Long idHospital) {
        TypedQuery<NodePoleOld> poles = em.createQuery("SELECT pole FROM NodePole pole WHERE pole.hospital = :idHospital", NodePoleOld.class);
        return poles.setParameter("idHospital", idHospital).getResultList();
    }

    /**
     * Get all services of a pole
     *
     * @param idPole The id of the pole
     * @return A List of NodeService
     */
    public List<NodeServiceOld> listNodeService(Long idPole) {
        TypedQuery<NodeServiceOld> services = em.createQuery("SELECT service FROM NodeService service WHERE service.pole = :idPole", NodeServiceOld.class);
        return services.setParameter("idPole", idPole).getResultList();
    }

    /**
     * Get all hospital units of a service
     *
     * @param idService The id of the service
     * @return A List of NodeHU
     */
    public List<NodeHUOld> listNodeHU(Long idService) {
        TypedQuery<NodeHUOld> hu = em.createQuery("SELECT hu FROM NodeHU hu WHERE hu.service = :idService", NodeHUOld.class);
        return hu.setParameter("idService", idService).getResultList();
    }

    /**
     * Get all care units of a hospital unit
     *
     * @param idHU The id of the hospital unit
     * @return A List of NodeCU
     */
    public List<NodeCUOld> listNodeCU(Long idHU) {
        TypedQuery<NodeCUOld> cu = em.createQuery("SELECT cu FROM NodeCU cu WHERE cu.hu = :idHU", NodeCUOld.class);
        return cu.setParameter("idHU", idHU).getResultList();
    }

    /**
     * Get the node in the Entity Node
     *
     * @param type Type of the Node
     * @param id Id of the Node
     * @return A Node
     */
    public NodeOld findNode(String type, Long id) {
        TypedQuery<NodeOld> node = em.createQuery("SELECT n FROM Node n WHERE n.type = :type AND n.id = :id", NodeOld.class);
        return node.setParameter("type", type).setParameter("id", id).getSingleResult();
    }
   
    /**
     * Get an hospital with its id passed in argument
     * 
     * @param id The id of the hospital
     * @return A NodeHospital
     */
    public NodeHospitalOld findNodeHospital(Long id) {
        return em.find(NodeHospitalOld.class, id);
    }

    /**
     * Get a pole with its id passed in argument
     * 
     * @param id The id of the pole
     * @return A NodePole
     */
    public NodePoleOld findNodePole(Long id) {
        return em.find(NodePoleOld.class, id);
    }

    /**
     * Get a service with its id passed in argument
     * 
     * @param id The id of the service
     * @return A NodeService
     */
    public NodeServiceOld findNodeService(Long id) {
        return em.find(NodeServiceOld.class, id);
    }

    /**
     * Get a hospital unit with its id passed in argument
     * 
     * @param id The id of the hospital unit
     * @return A NodeHU
     */
    public NodeHUOld findNodeHospitalUnit(Long id) {
        return em.find(NodeHUOld.class, id);
    }

    /**
     * Get a care unit with its id passed in argument
     * 
     * @param id The id of the care unit
     * @return A NodeCU
     */
    public NodeCUOld findNodeCareUnit(Long id) {
        return em.find(NodeCUOld.class, id);
    }

    /**
     * Insert a NodeAPHP in the database
     * 
     * @param aphp NodeAPHP to add
     * @return The id of the NodeAPHP
     */
    public Long saveNodeAPHP(NodeAPHPOld aphp) {
        NodeOld node = new NodeOld(aphp.getType(), aphp.getId());
        em.persist(aphp);
        em.persist(node);
        return aphp.getId();
    }

    /**
     * Insert a NodeHospital in the database
     * 
     * @param hospital NodeHospital to add
     * @return The id of the NodeHospital
     */
    public Long saveNodeHospital(NodeHospitalOld hospital) {
        NodeOld node = new NodeOld(hospital.getType(), hospital.getId());
        em.persist(hospital);
        em.persist(node);
        return hospital.getId();
    }

    /**
     * Insert a NodePole in the database
     * 
     * @param pole NodePole to add
     * @return The id of the NodePole
     */
    public Long saveNodePole(NodePoleOld pole) {
        NodeOld node = new NodeOld(pole.getType(), pole.getId());
        em.persist(pole);
        em.persist(node);
        return pole.getId();
    }

    /**
     * Insert a NodeService in the database
     * 
     * @param service NodeService to add
     * @return The id of the NodeService
     */
    public Long saveNodeService(NodeServiceOld service) {
        NodeOld node = new NodeOld(service.getType(), service.getId());
        em.persist(service);
        em.persist(node);
        return service.getId();
    }

    /**
     * Insert a NodeHU in the database
     * 
     * @param hu NodeHU to add
     * @return The id of the NodeHU
     */
    public Long saveNodeHospitalUnit(NodeHUOld hu) {
        NodeOld node = new NodeOld(hu.getType(), hu.getId());
        em.persist(hu);
        em.persist(node);
        return hu.getId();
    }

    /**
     * Insert a NodeCU in the database
     * 
     * @param cu NodeCU to add
     * @return The id of the NodeCU
     */
    public Long saveNodeCareUnit(NodeCUOld cu) {
        NodeOld node = new NodeOld(cu.getType(), cu.getId());
        em.persist(cu);
        em.persist(node);
        return cu.getId();
    }
}
