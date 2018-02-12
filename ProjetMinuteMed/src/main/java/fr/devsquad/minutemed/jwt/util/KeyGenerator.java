/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.jwt.util;

import java.security.Key;

public interface KeyGenerator {

    Key generateKey();
}
