/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author phasnox
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Generic implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "bbpin")
    private String bbpin;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_ultima_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaCompra;

    @Column(name = "id_ultima_factura")
    private Integer idUltimaFactura;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturaList;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_cliente")
    @ManyToOne
    private TipoCliente idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Cita> citaCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        Integer oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getBbpin() {
        return bbpin;
    }

    public void setBbpin(String bbpin) {
        String oldBbpin = this.bbpin;
        this.bbpin = bbpin;
        changeSupport.firePropertyChange("bbpin", oldBbpin, bbpin);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Date getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(Date fechaUltimaCompra) {
        Date oldFechaUltimaCompra = this.fechaUltimaCompra;
        this.fechaUltimaCompra = fechaUltimaCompra;
        changeSupport.firePropertyChange("fechaUltimaCompra", oldFechaUltimaCompra, fechaUltimaCompra);
    }

    public Integer getIdUltimaFactura() {
        return idUltimaFactura;
    }

    public void setIdUltimaFactura(Integer idUltimaFactura) {
        Integer oldIdUltimaFactura = this.idUltimaFactura;
        this.idUltimaFactura = idUltimaFactura;
        changeSupport.firePropertyChange("idUltimaFactura", oldIdUltimaFactura, idUltimaFactura);
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public TipoCliente getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoCliente idTipo) {
        TipoCliente oldIdTipo = this.idTipo;
        this.idTipo = idTipo;
        changeSupport.firePropertyChange("idTipo", oldIdTipo, idTipo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
