/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustomernumber", query = "SELECT c FROM Customers c WHERE c.customernumber = :customernumber")
    , @NamedQuery(name = "Customers.findByCustomername", query = "SELECT c FROM Customers c WHERE c.customername = :customername")
    , @NamedQuery(name = "Customers.findByContactlastname", query = "SELECT c FROM Customers c WHERE c.contactlastname = :contactlastname")
    , @NamedQuery(name = "Customers.findByContactfirstname", query = "SELECT c FROM Customers c WHERE c.contactfirstname = :contactfirstname")
    , @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customers.findByAddressline1", query = "SELECT c FROM Customers c WHERE c.addressline1 = :addressline1")
    , @NamedQuery(name = "Customers.findByAddressline2", query = "SELECT c FROM Customers c WHERE c.addressline2 = :addressline2")
    , @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city")
    , @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state")
    , @NamedQuery(name = "Customers.findByPostalcode", query = "SELECT c FROM Customers c WHERE c.postalcode = :postalcode")
    , @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country")
    , @NamedQuery(name = "Customers.findByCreditlimit", query = "SELECT c FROM Customers c WHERE c.creditlimit = :creditlimit")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERNUMBER")
    private Integer customernumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTACTLASTNAME")
    private String contactlastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTACTFIRSTNAME")
    private String contactfirstname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Size(max = 50)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 15)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COUNTRY")
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDITLIMIT")
    private BigDecimal creditlimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private List<Payments> paymentsList;
    @JoinColumn(name = "SALESREPEMPLOYEENUMBER", referencedColumnName = "EMPLOYEENUMBER")
    @ManyToOne
    private Employees salesrepemployeenumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customernumber")
    private List<Orders> ordersList;

    public Customers() {
    }

    public Customers(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public Customers(Integer customernumber, String customername, String contactlastname, String contactfirstname, String phone, String addressline1, String city, String country) {
        this.customernumber = customernumber;
        this.customername = customername;
        this.contactlastname = contactlastname;
        this.contactfirstname = contactfirstname;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.city = city;
        this.country = country;
    }

    public Integer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getContactlastname() {
        return contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

    public String getContactfirstname() {
        return contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(BigDecimal creditlimit) {
        this.creditlimit = creditlimit;
    }

    @XmlTransient
    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public Employees getSalesrepemployeenumber() {
        return salesrepemployeenumber;
    }

    public void setSalesrepemployeenumber(Employees salesrepemployeenumber) {
        this.salesrepemployeenumber = salesrepemployeenumber;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customernumber != null ? customernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customernumber == null && other.customernumber != null) || (this.customernumber != null && !this.customernumber.equals(other.customernumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customers[ customernumber=" + customernumber + " ]";
    }
    
}
