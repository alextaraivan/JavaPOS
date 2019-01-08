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
public class TempDetails implements java.io.Serializable{
    
     private Integer id;
    
    private String prodName;
    private String description;
    private Double price;
    private Integer quantity;

    public TempDetails(Integer id, String prodName, String description, Double price, Integer quantity) {
        this.id = id;
        this.prodName = prodName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
