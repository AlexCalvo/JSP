/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "MEDICIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediciones.findAll", query = "SELECT m FROM Mediciones m")
    , @NamedQuery(name = "Mediciones.findByIdmedicion", query = "SELECT m FROM Mediciones m WHERE m.idmedicion = :idmedicion")
    , @NamedQuery(name = "Mediciones.findByFechahora", query = "SELECT m FROM Mediciones m WHERE m.fechahora = :fechahora")
    , @NamedQuery(name = "Mediciones.findByKw", query = "SELECT m FROM Mediciones m WHERE m.kw = :kw")})
public class Mediciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICION")
    private Integer idmedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAHORA")
    @Temporal(TemporalType.DATE)
    private Date fechahora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KW")
    private double kw;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Clientes cliente;

    public Mediciones() {
    }

    public Mediciones(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Mediciones(Integer idmedicion, Date fechahora, double kw) {
        this.idmedicion = idmedicion;
        this.fechahora = fechahora;
        this.kw = kw;
    }

    public Integer getIdmedicion() {
        return idmedicion;
    }

    public void setIdmedicion(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public double getKw() {
        return kw;
    }

    public void setKw(double kw) {
        this.kw = kw;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicion != null ? idmedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediciones)) {
            return false;
        }
        Mediciones other = (Mediciones) object;
        if ((this.idmedicion == null && other.idmedicion != null) || (this.idmedicion != null && !this.idmedicion.equals(other.idmedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mediciones[ idmedicion=" + idmedicion + " ]";
    }
    
}
