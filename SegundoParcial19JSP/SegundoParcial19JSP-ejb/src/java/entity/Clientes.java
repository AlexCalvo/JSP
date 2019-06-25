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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CLIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCodigo", query = "SELECT c FROM Clientes c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientes.findByApellido", query = "SELECT c FROM Clientes c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Clientes.findByApellido2", query = "SELECT c FROM Clientes c WHERE c.apellido2 = :apellido2")
    , @NamedQuery(name = "Clientes.findByNumero", query = "SELECT c FROM Clientes c WHERE c.numero = :numero")
    , @NamedQuery(name = "Clientes.findByPiso", query = "SELECT c FROM Clientes c WHERE c.piso = :piso")
    , @NamedQuery(name = "Clientes.findByMetros", query = "SELECT c FROM Clientes c WHERE c.metros = :metros")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 50)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PISO")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "METROS")
    private int metros;
    @JoinColumn(name = "CALLE", referencedColumnName = "IDCALLE")
    @ManyToOne(optional = false)
    private Callespoblaciones calle;
    @JoinColumn(name = "CODIGOPOBLACION", referencedColumnName = "CODIGOPOBLACION")
    @ManyToOne
    private Poblaciones codigopoblacion;
    @JoinColumn(name = "CODIGOPROVINCIA", referencedColumnName = "CODIGOPROVINCIA")
    @ManyToOne(optional = false)
    private Provincias codigoprovincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Mediciones> medicionesList;

    public Clientes() {
    }

    public Clientes(Integer codigo) {
        this.codigo = codigo;
    }

    public Clientes(Integer codigo, int numero, int piso, int metros) {
        this.codigo = codigo;
        this.numero = numero;
        this.piso = piso;
        this.metros = metros;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public Callespoblaciones getCalle() {
        return calle;
    }

    public void setCalle(Callespoblaciones calle) {
        this.calle = calle;
    }

    public Poblaciones getCodigopoblacion() {
        return codigopoblacion;
    }

    public void setCodigopoblacion(Poblaciones codigopoblacion) {
        this.codigopoblacion = codigopoblacion;
    }

    public Provincias getCodigoprovincia() {
        return codigoprovincia;
    }

    public void setCodigoprovincia(Provincias codigoprovincia) {
        this.codigoprovincia = codigoprovincia;
    }

    @XmlTransient
    public List<Mediciones> getMedicionesList() {
        return medicionesList;
    }

    public void setMedicionesList(List<Mediciones> medicionesList) {
        this.medicionesList = medicionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clientes[ codigo=" + codigo + " ]";
    }
    
}
