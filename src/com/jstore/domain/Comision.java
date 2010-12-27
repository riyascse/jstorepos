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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author phasnox
 */
@Entity
@Table(name = "comision")
@NamedQueries({
    @NamedQuery(name = "Comision.findAll", query = "SELECT c FROM Comision c")})
public class Comision implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComisionPK comisionPK;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "pagado")
    private Boolean pagado;
//    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private FacturaDetalle facturaDetalle;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendedor vendedor;

    public Comision() {
    }

    public Comision(ComisionPK comisionPK) {
        this.comisionPK = comisionPK;
    }

    public Comision(int idVendedor, int idDetalle, int idFactura) {
        this.comisionPK = new ComisionPK(idVendedor, idDetalle, idFactura);
    }

    public ComisionPK getComisionPK() {
        return comisionPK;
    }

    public void setComisionPK(ComisionPK comisionPK) {
        this.comisionPK = comisionPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

//    public FacturaDetalle getFacturaDetalle() {
//        return facturaDetalle;
//    }
//
//    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
//        this.facturaDetalle = facturaDetalle;
//    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comisionPK != null ? comisionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.comisionPK == null && other.comisionPK != null) || (this.comisionPK != null && !this.comisionPK.equals(other.comisionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jstore.domain.Comision[comisionPK=" + comisionPK + "]";
    }

}
