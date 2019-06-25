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
@Table(name = "CALLESPOBLACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Callespoblaciones.findAll", query = "SELECT c FROM Callespoblaciones c")
    , @NamedQuery(name = "Callespoblaciones.findByIdcalle", query = "SELECT c FROM Callespoblaciones c WHERE c.idcalle = :idcalle")
    , @NamedQuery(name = "Callespoblaciones.findByNombre", query = "SELECT c FROM Callespoblaciones c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Callespoblaciones.findByCodpostal", query = "SELECT c FROM Callespoblaciones c WHERE c.codpostal = :codpostal")})
public class Callespoblaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCALLE")
    private Integer idcalle;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPOSTAL")
    private int codpostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calle")
    private List<Clientes> clientesList;
    @JoinColumn(name = "CODPOBLACION", referencedColumnName = "CODIGOPOBLACION")
    @ManyToOne
    private Poblaciones codpoblacion;

    public Callespoblaciones() {
    }

    public Callespoblaciones(Integer idcalle) {
        this.idcalle = idcalle;
    }

    public Callespoblaciones(Integer idcalle, int codpostal) {
        this.idcalle = idcalle;
        this.codpostal = codpostal;
    }

    public Integer getIdcalle() {
        return idcalle;
    }

    public void setIdcalle(Integer idcalle) {
        this.idcalle = idcalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public Poblaciones getCodpoblacion() {
        return codpoblacion;
    }

    public void setCodpoblacion(Poblaciones codpoblacion) {
        this.codpoblacion = codpoblacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalle != null ? idcalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Callespoblaciones)) {
            return false;
        }
        Callespoblaciones other = (Callespoblaciones) object;
        if ((this.idcalle == null && other.idcalle != null) || (this.idcalle != null && !this.idcalle.equals(other.idcalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Callespoblaciones[ idcalle=" + idcalle + " ]";
    }
    
}
