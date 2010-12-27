/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author phasnox
 */
@Embeddable
public class ComisionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_vendedor")
    private int idVendedor;
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private int idDetalle;
    @Basic(optional = false)
    @Column(name = "id_factura")
    private int idFactura;

    public ComisionPK() {
    }

    public ComisionPK(int idVendedor, int idDetalle, int idFactura) {
        this.idVendedor = idVendedor;
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVendedor;
        hash += (int) idDetalle;
        hash += (int) idFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionPK)) {
            return false;
        }
        ComisionPK other = (ComisionPK) object;
        if (this.idVendedor != other.idVendedor) {
            return false;
        }
        if (this.idDetalle != other.idDetalle) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jstore.domain.ComisionPK[idVendedor=" + idVendedor + ", idDetalle=" + idDetalle + ", idFactura=" + idFactura + "]";
    }

}
