/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Hp
 */
@Entity
@Table(name = "PRODUCTLINES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productlines.findAll", query = "SELECT p FROM Productlines p")
    , @NamedQuery(name = "Productlines.findByProductline", query = "SELECT p FROM Productlines p WHERE p.productline = :productline")
    , @NamedQuery(name = "Productlines.findByTextdescription", query = "SELECT p FROM Productlines p WHERE p.textdescription = :textdescription")
    , @NamedQuery(name = "Productlines.findByHtmldescription", query = "SELECT p FROM Productlines p WHERE p.htmldescription = :htmldescription")
    , @NamedQuery(name = "Productlines.findByImage", query = "SELECT p FROM Productlines p WHERE p.image = :image")})
public class Productlines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRODUCTLINE")
    private String productline;
    @Size(max = 4000)
    @Column(name = "TEXTDESCRIPTION")
    private String textdescription;
    @Size(max = 5000)
    @Column(name = "HTMLDESCRIPTION")
    private String htmldescription;
    @Size(max = 100)
    @Column(name = "IMAGE")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productline")
    private List<Products> productsList;

    public Productlines() {
    }

    public Productlines(String productline) {
        this.productline = productline;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productline != null ? productline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productlines)) {
            return false;
        }
        Productlines other = (Productlines) object;
        if ((this.productline == null && other.productline != null) || (this.productline != null && !this.productline.equals(other.productline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productlines[ productline=" + productline + " ]";
    }
    
}
