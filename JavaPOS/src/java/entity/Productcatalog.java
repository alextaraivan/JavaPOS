/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PRODUCTCATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productcatalog.findAll", query = "SELECT p FROM Productcatalog p")
    , @NamedQuery(name = "Productcatalog.findByProdid", query = "SELECT p FROM Productcatalog p WHERE p.prodid = :prodid")
    , @NamedQuery(name = "Productcatalog.findByProdname", query = "SELECT p FROM Productcatalog p WHERE p.prodname = :prodname")})
public class Productcatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODID")
    private Long prodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "PRODNAME")
    private String prodname;

    public Productcatalog() {
    }

    public Productcatalog(Long prodid) {
        this.prodid = prodid;
    }

    public Productcatalog(Long prodid, String prodname) {
        this.prodid = prodid;
        this.prodname = prodname;
    }

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodid != null ? prodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcatalog)) {
            return false;
        }
        Productcatalog other = (Productcatalog) object;
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productcatalog[ prodid=" + prodid + " ]";
    }
    
}
