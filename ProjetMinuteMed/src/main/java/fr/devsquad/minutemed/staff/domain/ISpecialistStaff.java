/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.specialization.domain.Specialization;

/**
 *
 * @author JSalmon
 */
public interface ISpecialistStaff {
    public String getSpecialization();
    public void setSpecialization(Specialization specialization);
}
