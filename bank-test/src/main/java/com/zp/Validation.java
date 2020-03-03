/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zp;

/**
 *
 * @author Mustafeez
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "validation")
public class Validation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String merchant_email;
	private String secret_key;
	
	 public Validation() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name="merchant_email")
	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}
	@XmlElement(name="secret_key")
	public String getSecret_key() {
		return secret_key;
	}
    
	
	public void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}
	
	
	

}
