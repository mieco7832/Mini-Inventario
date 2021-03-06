package com.miec.entity;
// Generated 10-02-2020 10:09:44 PM by Hibernate Tools 5.2.12.Final

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "inventario")
public class Producto implements java.io.Serializable {

	private String productoCode;
	private String productoNombre;
	private String productoUnidad;
	private double productoPrecio;
	private List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>(0);

	public Producto() {
	}

	public Producto(String productoCode, String productoNombre, String productoUnidad, double productoPrecio) {
		this.productoCode = productoCode;
		this.productoNombre = productoNombre;
		this.productoUnidad = productoUnidad;
		this.productoPrecio = productoPrecio;
	}

	public Producto(String productoCode, String productoNombre, String productoUnidad, double productoPrecio,
			List<Caracteristica> caracteristicas) {
		this.productoCode = productoCode;
		this.productoNombre = productoNombre;
		this.productoUnidad = productoUnidad;
		this.productoPrecio = productoPrecio;
		this.caracteristicas = caracteristicas;
	}

	@Id

	@Column(name = "producto_code", unique = true, nullable = false, length = 150)
	public String getProductoCode() {
		return this.productoCode;
	}

	public void setProductoCode(String productoCode) {
		this.productoCode = productoCode;
	}

	@Column(name = "producto_nombre", nullable = false, length = 150)
	public String getProductoNombre() {
		return this.productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	@Column(name = "producto_unidad", nullable = false, length = 20)
	public String getProductoUnidad() {
		return this.productoUnidad;
	}

	public void setProductoUnidad(String productoUnidad) {
		this.productoUnidad = productoUnidad;
	}

	@Column(name = "producto_precio", nullable = false, precision = 20)
	public double getProductoPrecio() {
		return this.productoPrecio;
	}

	public void setProductoPrecio(double productoPrecio) {
		this.productoPrecio = productoPrecio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	public List<Caracteristica> getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
