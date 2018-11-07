/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedago
 */
public class DiscountCode {
    
    private float taux;
    private String code;
    
    DiscountCode(float t, String c) {
        this.taux=t;
        this.code=c;
    }
    
    String getCode() {
        return this.code;
    }
    
    void setCode(String c) {
        this.code=c;
    }
    
    float getTaux() {
        return this.taux;
    }
    
    void setTaux(float t) {
        this.taux=t;
    }
}
