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
public class ProductDescription {
    
    private int id;
	private Money price;
	private String description;
	public ProductDescription(int id,Money price,String description){
		this.id=id;
		this.price=price;
		this.description=description;
	}
	public int getItemID(){return id;};
	public Money getPrice(){return price;}
	public String getDescription(){return description;}
}
