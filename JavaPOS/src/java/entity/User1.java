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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "USER1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User1.findAll", query = "SELECT u FROM User1 u")
    , @NamedQuery(name = "User1.findById", query = "SELECT u FROM User1 u WHERE u.id = :id")
    , @NamedQuery(name = "User1.findByUsername", query = "SELECT u FROM User1 u WHERE u.username = :username")
    , @NamedQuery(name = "User1.findByEmail", query = "SELECT u FROM User1 u WHERE u.email = :email")
    , @NamedQuery(name = "User1.findByPhone", query = "SELECT u FROM User1 u WHERE u.phone = :phone")
    , @NamedQuery(name = "User1.findByPassword", query = "SELECT u FROM User1 u WHERE u.password = :password")
    , @NamedQuery(name = "User1.findByPosition", query = "SELECT u FROM User1 u WHERE u.position = :position")
    , @NamedQuery(name="User1.findByNameAndPass", query="SELECT u FROM User1 u WHERE u.username = :username and u.password=:password")})
public class User1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USERNAME")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONE")
    private int phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "POSITION")
    private String position;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashier")
    private Collection<Sale> sales;

    public User1() {
    }

    public User1(Integer id) {
        this.id = id;
    }

    public User1(Integer id, String username, String email, int phone, String password, String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public Collection<Sale> getSales() {
        return sales;
    }

    public void setSales(Collection<Sale> sales) {
        this.sales = sales;
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
        if (!(object instanceof User1)) {
            return false;
        }
        User1 other = (User1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User1[ id=" + id + " ]";
    }
    
}
