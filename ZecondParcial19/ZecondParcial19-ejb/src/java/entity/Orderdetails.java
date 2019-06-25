/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "ORDERDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o")
    , @NamedQuery(name = "Orderdetails.findByOrdernumber", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.ordernumber = :ordernumber")
    , @NamedQuery(name = "Orderdetails.findByProductcode", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.productcode = :productcode")
    , @NamedQuery(name = "Orderdetails.findByQuantityordered", query = "SELECT o FROM Orderdetails o WHERE o.quantityordered = :quantityordered")
    , @NamedQuery(name = "Orderdetails.findByPriceeach", query = "SELECT o FROM Orderdetails o WHERE o.priceeach = :priceeach")
    , @NamedQuery(name = "Orderdetails.findByOrderlinenumber", query = "SELECT o FROM Orderdetails o WHERE o.orderlinenumber = :orderlinenumber")})
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailsPK orderdetailsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITYORDERED")
    private int quantityordered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICEEACH")
    private BigDecimal priceeach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERLINENUMBER")
    private int orderlinenumber;
    @JoinColumn(name = "ORDERNUMBER", referencedColumnName = "ORDERNUMBER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "PRODUCTCODE", referencedColumnName = "PRODUCTCODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public Orderdetails() {
    }

    public Orderdetails(OrderdetailsPK orderdetailsPK) {
        this.orderdetailsPK = orderdetailsPK;
    }

    public Orderdetails(OrderdetailsPK orderdetailsPK, int quantityordered, BigDecimal priceeach, int orderlinenumber) {
        this.orderdetailsPK = orderdetailsPK;
        this.quantityordered = quantityordered;
        this.priceeach = priceeach;
        this.orderlinenumber = orderlinenumber;
    }

    public Orderdetails(int ordernumber, String productcode) {
        this.orderdetailsPK = new OrderdetailsPK(ordernumber, productcode);
    }

    public OrderdetailsPK getOrderdetailsPK() {
        return orderdetailsPK;
    }

    public void setOrderdetailsPK(OrderdetailsPK orderdetailsPK) {
        this.orderdetailsPK = orderdetailsPK;
    }

    public int getQuantityordered() {
        return quantityordered;
    }

    public void setQuantityordered(int quantityordered) {
        this.quantityordered = quantityordered;
    }

    public BigDecimal getPriceeach() {
        return priceeach;
    }

    public void setPriceeach(BigDecimal priceeach) {
        this.priceeach = priceeach;
    }

    public int getOrderlinenumber() {
        return orderlinenumber;
    }

    public void setOrderlinenumber(int orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailsPK != null ? orderdetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.orderdetailsPK == null && other.orderdetailsPK != null) || (this.orderdetailsPK != null && !this.orderdetailsPK.equals(other.orderdetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderdetails[ orderdetailsPK=" + orderdetailsPK + " ]";
    }
    
}
