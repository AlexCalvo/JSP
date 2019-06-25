/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hp
 */
@Embeddable
public class PaymentsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERNUMBER")
    private int customernumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CHECKNUMBER")
    private String checknumber;

    public PaymentsPK() {
    }

    public PaymentsPK(int customernumber, String checknumber) {
        this.customernumber = customernumber;
        this.checknumber = checknumber;
    }

    public int getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(int customernumber) {
        this.customernumber = customernumber;
    }

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customernumber;
        hash += (checknumber != null ? checknumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentsPK)) {
            return false;
        }
        PaymentsPK other = (PaymentsPK) object;
        if (this.customernumber != other.customernumber) {
            return false;
        }
        if ((this.checknumber == null && other.checknumber != null) || (this.checknumber != null && !this.checknumber.equals(other.checknumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaymentsPK[ customernumber=" + customernumber + ", checknumber=" + checknumber + " ]";
    }
    
}
