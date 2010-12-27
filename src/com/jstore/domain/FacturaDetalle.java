/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

/**
 *
 * @author phasnox
 */
@Entity
@Table(name = "factura_detalle")
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f")})
public class FacturaDetalle extends Generic implements Serializable {
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected FacturaDetallePK facturaDetallePK = new FacturaDetallePK();
    @Id
    @Column(name = "id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "impuestos")
    private Double impuestos;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "total")
    private Double total;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaDetalle")
//    private List<Comision> comisionList;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne
    private Factura factura;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto producto;

    public FacturaDetalle() {
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

//    public FacturaDetalle(FacturaDetallePK facturaDetallePK) {
//        this.facturaDetallePK = facturaDetallePK;
//    }
//
//    public FacturaDetalle(int idDetalle, int idFactura) {
//        this.facturaDetallePK = new FacturaDetallePK(idDetalle, idFactura);
//    }
//
//    public FacturaDetallePK getFacturaDetallePK() {
//        return facturaDetallePK;
//    }
//
//    public void setFacturaDetallePK(FacturaDetallePK facturaDetallePK) {
//        this.facturaDetallePK = facturaDetallePK;
//    }
    


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

//    public List<Comision> getComisionList() {
//        return comisionList;
//    }
//
//    public void setComisionList(List<Comision> comisionList) {
//        this.comisionList = comisionList;
//    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jstore.domain.FacturaDetalle[facturaDetallePK=" + idDetalle + "]";
    }

}
