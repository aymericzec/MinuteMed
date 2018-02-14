/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.main;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.jwt.util.KeyGenerator;
import fr.devsquad.minutemed.jwt.util.SimpleKeyGenerator;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author home
 */
public class Main {
    
    public static void main(String [] args) {
        /*
        Specialization pediatrie = new Specialization(SpecializationEnum.Endocrinologie);
        DataManager dataManager = new DataManager(StaffEnum.DATAMANAGER, "Gerard", "Luy", "5 Rue de la butte verte", "gerard.luy@gmail.com", "0784514796");
        
        dataManager.createSpecialization(pediatrie);
        */
        //NodeHospital hospital = new NodeHospital(NodeEnum.HOSPITAL, "CHU de Reims");
        UserAccount user = new UserAccount(5L, "younessky", "1234", StaffEnum.DATA_MANAGER);
        
        
        KeyGenerator keyGenerator = new SimpleKeyGenerator();
        
        Key key = keyGenerator.generateKey();
        
        String jwtToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer("/api/test")
                .claim("user", user)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        System.out.println(jwtToken);
    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
