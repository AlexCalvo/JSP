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
@Table(name = "POBLACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poblaciones.findAll", query = "SELECT p FROM Poblaciones p")
    , @NamedQuery(name = "Poblaciones.findByCodigopoblacion", query = "SELECT p FROM Poblaciones p WHERE p.codigopoblacion = :codigopoblacion")
    , @NamedQuery(name = "Poblaciones.findByPoblacion", query = "SELECT p FROM Poblaciones p WHERE p.poblacion = :poblacion")
    , @NamedQuery(name = "Poblaciones.findByHabitantes", query = "SELECT p FROM Poblaciones p WHERE p.habitantes = :habitantes")})
public class Poblaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODIGOPOBLACION")
    private String codigopoblacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POBLACION")
    private String poblacion;
    @Column(name = "HABITANTES")
    private Integer habitantes;
    @OneToMany(mappedBy = "codigopoblacion")
    private List<Clientes> clientesList;
    @JoinColumn(name = "CODIGOPROVINCIA", referencedColumnName = "CODIGOPROVINCIA")
    @ManyToOne(optional = false)
    private Provincias codigoprovincia;
    @OneToMany(mappedBy = "codpoblacion")
    private List<Callespoblaciones> callespoblacionesList;

    public Poblaciones() {
    }

    public Poblaciones(String codigopoblacion) {
        this.codigopoblacion = codigopoblacion;
    }

    public Poblaciones(String codigopoblacion, String poblacion) {
        this.codigopoblacion = codigopoblacion;
        this.poblacion = poblacion;
    }

    public String getCodigopoblacion() {
        return codigopoblacion;
    }

    public void setCodigopoblacion(String codigopoblacion) {
        this.codigopoblacion = codigopoblacion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Integer getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Integer habitantes) {
        this.habitantes = habitantes;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public Provincias getCodigoprovincia() {
        return codigoprovincia;
    }

    public void setCodigoprovincia(Provincias codigoprovincia) {
        this.codigoprovincia = codigoprovincia;
    }

    @XmlTransient
    public List<Callespoblaciones> getCallespoblacionesList() {
        return callespoblacionesList;
    }

    public void setCallespoblacionesList(List<Callespoblaciones> callespoblacionesList) {
        this.callespoblacionesList = callespoblacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopoblacion != null ? codigopoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poblaciones)) {
            return false;
        }
        Poblaciones other = (Poblaciones) object;
        if ((this.codigopoblacion == null && other.codigopoblacion != null) || (this.codigopoblacion != null && !this.codigopoblacion.equals(other.codigopoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Poblaciones[ codigopoblacion=" + codigopoblacion + " ]";
    }
    
}
