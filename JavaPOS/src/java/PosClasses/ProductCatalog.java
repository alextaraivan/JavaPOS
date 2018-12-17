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
import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
	private Map<Integer,ProductDescription>
		descriptions=new HashMap<Integer,ProductDescription>();
	public ProductCatalog(){
		//sample data
		//ItemID id1=new ItemID(100);
		//ItemID id2=new ItemID(200);
		Money price=new Money(3);
		ProductDescription desc;
		desc=new ProductDescription(100, price, "product 1");
		descriptions.put(100, desc);
		desc=new ProductDescription(200, price, "product 2");
		descriptions.put(200, desc);
		
	}
	public ProductDescription getProductDescription(int id){
		return descriptions.get(id);
	}
}
