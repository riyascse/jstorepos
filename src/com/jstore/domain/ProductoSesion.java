/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author phasnox
 */
@Entity
@Table(name = "producto_sesion")
public class ProductoSesion extends Generic implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoSesionPK productoSesionPK;
    @Column(name = "numero_sesiones")
    private Integer numeroSesiones;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sesion sesion;

    public ProductoSesion() {
    }

    public ProductoSesion(ProductoSesionPK productoSesionPK) {
        this.productoSesionPK = productoSesionPK;
    }

    public ProductoSesion(int idProducto, int idSesion) {
        this.productoSesionPK = new ProductoSesionPK(idProducto, idSesion);
    }

    public ProductoSesion(Sesion selectedEntity, int numSesiones) {
        sesion=selectedEntity;
        numeroSesiones=numSesiones;
        this.productoSesionPK = new ProductoSesionPK(-1, sesion.getIdSesion());
    }

    public ProductoSesionPK getProductoSesionPK() {
        return productoSesionPK;
    }

    public void setProductoSesionPK(ProductoSesionPK productoSesionPK) {
        this.productoSesionPK = productoSesionPK;
    }

    public Integer getNumeroSesiones() {
        return numeroSesiones;
    }

    public void setNumeroSesiones(Integer numeroSesiones) {
        this.numeroSesiones = numeroSesiones;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.productoSesionPK.setIdProducto(producto.getIdProducto());
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoSesionPK != null ? productoSesionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoSesion)) {
            return false;
        }
        ProductoSesion other = (ProductoSesion) object;
        if ((this.productoSesionPK == null && other.productoSesionPK != null) || (this.productoSesionPK != null && !this.productoSesionPK.equals(other.productoSesionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jstore.domain.ProductoSesion[productoSesionPK=" + productoSesionPK + "]";
    }

}
