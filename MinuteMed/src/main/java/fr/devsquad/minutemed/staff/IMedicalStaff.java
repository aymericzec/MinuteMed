/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff;

import java.util.List;

/**
 *
 * @author jsalmon
 */
public interface IMedicalStaff {
    public INode getService();
    public INode getAttachedNode();
    public List<IMedicalRecord> getAllMedicalRecords();
    public IMedicalRecord getMedicalRecord(long idMedicalRecord);
    public INode getHospital();
    public void setAttachedNode(INode node);
    public void setService(INode service);
    public List<String> getAllFeatures();
}
