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
public class ProductoSesionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "id_sesion")
    private int idSesion;

    public ProductoSesionPK() {
    }

    public ProductoSesionPK(int idProducto, int idSesion) {
        this.idProducto = idProducto;
        this.idSesion = idSesion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idSesion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoSesionPK)) {
            return false;
        }
        ProductoSesionPK other = (ProductoSesionPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idSesion != other.idSesion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jstore.domain.ProductoSesionPK[idProducto=" + idProducto + ", idSesion=" + idSesion + "]";
    }

}
