/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author François
 */
public class DiscountEntity {
    
	private String code;
	private float taux;

	public DiscountEntity(String Code,float Taux) {
		this.code = Code;
		this.taux = Taux;
	}

	/**
	 * Get the value of customerId
	 *
	 * @return the value of customerId
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public Float getTaux() {
		return taux;
	}
}
