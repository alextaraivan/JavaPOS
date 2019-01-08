/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Romelia Milascon
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;

     private String prodName;
    
    private ProductSpec productSpec;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToOne(mappedBy = "product")
    public ProductSpec getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(ProductSpec productSpec) {
        this.productSpec = productSpec;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ id=" + id + " ]";
    }
    
}
