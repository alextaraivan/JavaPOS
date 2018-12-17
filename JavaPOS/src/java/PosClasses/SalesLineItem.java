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
public class SalesLineItem {
    
    private int quantity;
	private ProductDescription description;
	
	public SalesLineItem(ProductDescription desc,int quantity){
		this.description=desc;
		this.quantity=quantity;
	}
	public Money getSubtotal(){
		return description.getPrice().times(quantity);
	}
}
