/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosClasses;

/**
 *
 * @author Romelia Milascon
 */
public class Store {
    
    private ProductCatalog catalog=new ProductCatalog();
	private Register register=new Register(catalog);
	public Register getRegister(){
		return register;
	}
}
