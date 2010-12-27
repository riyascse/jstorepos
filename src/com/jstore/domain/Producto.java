/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

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

/**
 *
 * @author phasnox
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto extends Generic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "minutos_maquina")
    private Integer minutosMaquina;
    @OneToMany(mappedBy = "producto")
    private List<FacturaDetalle> facturaDetalleList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getMinutosMaquina() {
        return minutosMaquina;
    }

    public void setMinutosMaquina(Integer minutosMaquina) {
        this.minutosMaquina = minutosMaquina;
    }

    public List<FacturaDetalle> getFacturaDetalleList() {
        return facturaDetalleList;
    }

    public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
        this.facturaDetalleList = facturaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jstore.domain.Producto[idProducto=" + idProducto + "]";
    }

}
