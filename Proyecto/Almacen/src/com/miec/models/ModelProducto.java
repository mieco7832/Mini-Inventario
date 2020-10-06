package com.miec.models;
// Entidad no mapeada, clase asociada al dominio y vista
public class ModelProducto {
	
	// Atributos de la entidad Producto
	private String cod;
	private String nam;
	private String uni;
	private double pri;
	
	// Constructor
	public ModelProducto(String cod, String nam, String uni, double pri) {
		super();
		this.cod = cod;
		this.nam = nam;
		this.uni = uni;
		this.pri = pri;
	}
	
	// Atributos de la enntidad Caracteristica
	private int id;
	private String nac;
	private String com;
	
	//Constructor
	public ModelProducto(String cod, int id, String nac, String com) {
		super();
		this.cod = cod;
		this.id = id;
		this.nac = nac;
		this.com = com;
	}

	// Getter and Setter

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public double getPri() {
		return pri;
	}

	public void setPri(double pri) {
		this.pri = pri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNac() {
		return nac;
	}

	public void setNac(String nac) {
		this.nac = nac;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

}
