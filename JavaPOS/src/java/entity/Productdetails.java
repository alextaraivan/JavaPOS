/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Productcatalog;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Romelia Milascon
 */
@Entity
@Table(name = "PRODUCTDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productdetails.findAll", query = "SELECT p FROM Productdetails p")
    , @NamedQuery(name = "Productdetails.findById", query = "SELECT p FROM Productdetails p WHERE p.id = :id")
    , @NamedQuery(name = "Productdetails.findByPrice", query = "SELECT p FROM Productdetails p WHERE p.price = :price")
    , @NamedQuery(name = "Productdetails.findByUnitsinstock", query = "SELECT p FROM Productdetails p WHERE p.unitsinstock = :unitsinstock")
    , @NamedQuery(name = "Productdetails.findByDescription", query = "SELECT p FROM Productdetails p WHERE p.description = :description")})
public class Productdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @Column(name = "UNITSINSTOCK")
    private Integer unitsinstock;
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PRODID")
    @ManyToOne(optional = false)
    private Productcatalog prodId;

    public Productdetails() {
    }

    public Productdetails(Long id) {
        this.id = id;
    }

    public Productdetails(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Productcatalog getProdId() {
        return prodId;
    }

    public void setProdId(Productcatalog prodId) {
        this.prodId = prodId;
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
        if (!(object instanceof Productdetails)) {
            return false;
        }
        Productdetails other = (Productdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productdetails[ id=" + id + " ]";
    }
    
}
