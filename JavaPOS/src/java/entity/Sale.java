/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Solditems;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Romelia Milascon
 */
@Entity
@Table(name = "SALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
    , @NamedQuery(name = "Sale.findBySaleId", query = "SELECT s FROM Sale s WHERE s.saleId = :saleId")
    , @NamedQuery(name = "Sale.findByDate", query = "SELECT s FROM Sale s WHERE s.date = :date")
    , @NamedQuery(name = "Sale.findByCash", query = "SELECT s FROM Sale s WHERE s.cash = :cash")})
public class Sale implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleId")
    private Collection<Solditems> solditemsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALE_ID")
    private Integer saleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CASH")
    private Double cash;
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID")
    @ManyToOne(optional = false)
    private Store storeId;
    @JoinColumn(name = "CASHIER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User1 cashierId;

    public Sale() {
    }

    public Sale(Integer saleId) {
        this.saleId = saleId;
    }

    public Sale(Integer saleId, Date date) {
        this.saleId = saleId;
        this.date = date;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public User1 getCashierId() {
        return cashierId;
    }

    public void setCashierId(User1 cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sale[ saleId=" + saleId + " ]";
    }

    @XmlTransient
    public Collection<Solditems> getSolditemsCollection() {
        return solditemsCollection;
    }

    public void setSolditemsCollection(Collection<Solditems> solditemsCollection) {
        this.solditemsCollection = solditemsCollection;
    }
    
}
