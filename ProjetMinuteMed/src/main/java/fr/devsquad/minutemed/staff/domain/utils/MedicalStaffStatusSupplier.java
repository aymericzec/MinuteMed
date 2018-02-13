/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.domain.utils;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.staff.domain.*;
import java.util.*;

/**
 *
 * @author enzo
 */
public class MedicalStaffStatusSupplier {
    
    private static final Map<Class<? extends MedicalStaff>, String> STATUS_SUPPLIER = new HashMap<Class<? extends MedicalStaff>, String>();
    static
    {
        STATUS_SUPPLIER.put(DataManager.class, "DATA_MANAGER");
        STATUS_SUPPLIER.put(Doctor.class, "DOCTOR");
        STATUS_SUPPLIER.put(Nurse.class, "NURSE");
    }
    
    public static <T extends MedicalStaff> String getStatus(Class<T> clazz){
        return STATUS_SUPPLIER.getOrDefault(Objects.requireNonNull(clazz), "NULL");
    }
    
}
