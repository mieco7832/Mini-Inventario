package com.miec.entity;
// Generated 10-02-2020 10:09:44 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Caracteristica generated by hbm2java
 */
@Entity
@Table(name = "caracteristica", catalog = "inventario")
public class Caracteristica implements java.io.Serializable {

	private int caracteristicaId;
	private Producto producto;
	private String caracteristicaNombre;
	private String caracteristicaComentario;

	public Caracteristica() {
	}

	public Caracteristica(int caracteristicaId, Producto producto, String caracteristicaNombre) {
		this.caracteristicaId = caracteristicaId;
		this.producto = producto;
		this.caracteristicaNombre = caracteristicaNombre;
	}

	public Caracteristica(int caracteristicaId, Producto producto, String caracteristicaNombre,
			String caracteristicaComentario) {
		this.caracteristicaId = caracteristicaId;
		this.producto = producto;
		this.caracteristicaNombre = caracteristicaNombre;
		this.caracteristicaComentario = caracteristicaComentario;
	}

	@Id

	@Column(name = "caracteristica_id", unique = true, nullable = false)
	public int getCaracteristicaId() {
		return this.caracteristicaId;
	}

	public void setCaracteristicaId(int caracteristicaId) {
		this.caracteristicaId = caracteristicaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "caracteristica_producto", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "caracteristica_nombre", nullable = false, length = 50)
	public String getCaracteristicaNombre() {
		return this.caracteristicaNombre;
	}

	public void setCaracteristicaNombre(String caracteristicaNombre) {
		this.caracteristicaNombre = caracteristicaNombre;
	}

	@Column(name = "caracteristica_comentario", length = 150)
	public String getCaracteristicaComentario() {
		return this.caracteristicaComentario;
	}

	public void setCaracteristicaComentario(String caracteristicaComentario) {
		this.caracteristicaComentario = caracteristicaComentario;
	}

}