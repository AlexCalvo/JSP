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
@Table(name = "PROVINCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")
    , @NamedQuery(name = "Provincias.findByCodigoprovincia", query = "SELECT p FROM Provincias p WHERE p.codigoprovincia = :codigoprovincia")
    , @NamedQuery(name = "Provincias.findByProvincia", query = "SELECT p FROM Provincias p WHERE p.provincia = :provincia")})
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOPROVINCIA")
    private Integer codigoprovincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROVINCIA")
    private String provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoprovincia")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoprovincia")
    private List<Poblaciones> poblacionesList;

    public Provincias() {
    }

    public Provincias(Integer codigoprovincia) {
        this.codigoprovincia = codigoprovincia;
    }

    public Provincias(Integer codigoprovincia, String provincia) {
        this.codigoprovincia = codigoprovincia;
        this.provincia = provincia;
    }

    public Integer getCodigoprovincia() {
        return codigoprovincia;
    }

    public void setCodigoprovincia(Integer codigoprovincia) {
        this.codigoprovincia = codigoprovincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @XmlTransient
    public List<Poblaciones> getPoblacionesList() {
        return poblacionesList;
    }

    public void setPoblacionesList(List<Poblaciones> poblacionesList) {
        this.poblacionesList = poblacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoprovincia != null ? codigoprovincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.codigoprovincia == null && other.codigoprovincia != null) || (this.codigoprovincia != null && !this.codigoprovincia.equals(other.codigoprovincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Provincias[ codigoprovincia=" + codigoprovincia + " ]";
    }
    
}
