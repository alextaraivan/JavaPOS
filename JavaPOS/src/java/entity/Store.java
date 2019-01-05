/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Romelia Milascon
 */
@Entity
@Table(name = "STORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId")
    , @NamedQuery(name = "Store.findByName", query = "SELECT s FROM Store s WHERE s.name = :name")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STORE_ID")
    private Long storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private Collection<Sale> saleCollection;

    public Store() {
    }

    public Store(Long storeId) {
        this.storeId = storeId;
    }

    public Store(Long storeId, String name, String address) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Sale> getSaleCollection() {
        return saleCollection;
    }

    public void setSaleCollection(Collection<Sale> saleCollection) {
        this.saleCollection = saleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Store[ storeId=" + storeId + " ]";
    }
    
}
