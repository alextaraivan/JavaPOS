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
public class Money {
    	public int money;
	public Money(){};
	public Money(int money){
		this.money=money;
	}
	public Money times(int quantity){
		return new Money(quantity*this.money);
	}
	public void add(Money subtotal){
		this.money=this.money+subtotal.money;
	}
	public Money minus(Money total){
		return  new Money(this.money-total.money);
	}
}
