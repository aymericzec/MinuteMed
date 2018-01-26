package fr.devsquad.minutemed.staff;


public interface IHospitalStaff {
    
    public long getId();
    
    public String getFirstName();
    
    public String getLastName();
    
    public String getAdress();
    
    public String getEmail();
    
    public String getPhoneNumber();
    
    public void setFirstName(String firstName);
    
    public void setLastName(String lastName);
    
    public void setAdress(String adress);
    
    public void setEmail(String email);
    
    public void setPhoneNumber(String phoneNumber);
    
}
