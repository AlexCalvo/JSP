/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeenumber", query = "SELECT e FROM Employees e WHERE e.employeenumber = :employeenumber")
    , @NamedQuery(name = "Employees.findByLastname", query = "SELECT e FROM Employees e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "Employees.findByFirstname", query = "SELECT e FROM Employees e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employees.findByExtension", query = "SELECT e FROM Employees e WHERE e.extension = :extension")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findByJobtitle", query = "SELECT e FROM Employees e WHERE e.jobtitle = :jobtitle")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEENUMBER")
    private Integer employeenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @OneToMany(mappedBy = "salesrepemployeenumber")
    private List<Customers> customersList;
    @OneToMany(mappedBy = "reportsto")
    private List<Employees> employeesList;
    @JoinColumn(name = "REPORTSTO", referencedColumnName = "EMPLOYEENUMBER")
    @ManyToOne
    private Employees reportsto;
    @JoinColumn(name = "OFFICECODE", referencedColumnName = "OFFICECODE")
    @ManyToOne(optional = false)
    private Offices officecode;

    public Employees() {
    }

    public Employees(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public Employees(Integer employeenumber, String lastname, String firstname, String extension, String email, String jobtitle) {
        this.employeenumber = employeenumber;
        this.lastname = lastname;
        this.firstname = firstname;
        this.extension = extension;
        this.email = email;
        this.jobtitle = jobtitle;
    }

    public Integer getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @XmlTransient
    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getReportsto() {
        return reportsto;
    }

    public void setReportsto(Employees reportsto) {
        this.reportsto = reportsto;
    }

    public Offices getOfficecode() {
        return officecode;
    }

    public void setOfficecode(Offices officecode) {
        this.officecode = officecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeenumber != null ? employeenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeenumber == null && other.employeenumber != null) || (this.employeenumber != null && !this.employeenumber.equals(other.employeenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employees[ employeenumber=" + employeenumber + " ]";
    }
    
}
