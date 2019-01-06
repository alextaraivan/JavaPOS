/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Productcatalog;
import entity.Sale;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Romelia Milascon
 */
@Entity
@Table(name = "SOLDITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solditems.findAll", query = "SELECT s FROM Solditems s")
    , @NamedQuery(name = "Solditems.findById", query = "SELECT s FROM Solditems s WHERE s.id = :id")
    , @NamedQuery(name = "Solditems.findByQuantity", query = "SELECT s FROM Solditems s WHERE s.quantity = :quantity")})
public class Solditems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PRODID")
    @ManyToOne(optional = false)
    private Productcatalog prodId;
    @JoinColumn(name = "SALE_ID", referencedColumnName = "SALE_ID")
    @ManyToOne(optional = false)
    private Sale saleId;

    public Solditems() {
    }

    public Solditems(Integer id) {
        this.id = id;
    }

    public Solditems(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Productcatalog getProdId() {
        return prodId;
    }

    public void setProdId(Productcatalog prodId) {
        this.prodId = prodId;
    }

    public Sale getSaleId() {
        return saleId;
    }

    public void setSaleId(Sale saleId) {
        this.saleId = saleId;
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
        if (!(object instanceof Solditems)) {
            return false;
        }
        Solditems other = (Solditems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Solditems[ id=" + id + " ]";
    }
    
}

