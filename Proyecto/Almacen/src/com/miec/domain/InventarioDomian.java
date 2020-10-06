package com.miec.domain;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miec.repository.*;
import com.miec.entity.*;
import com.miec.models.*;

@Service
public class InventarioDomian {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
	
	// Lista de Productos
	public List<ModelProducto> getProducto() {
		List<ModelProducto> productos = new ArrayList<>();
		for (Producto p : productoRepository.get()) {
			ModelProducto mp = new ModelProducto(p.getProductoCode(), p.getProductoNombre(), p.getProductoUnidad(),
					p.getProductoPrecio());
			productos.add(mp);
		}
		return productos;
	}
	
	// Lista de Caracteriscas según el producto
	public List<ModelProducto> getCaracteristicaByCode(String code) {
		List<ModelProducto> caracteristicas = new ArrayList<>();
		for (Caracteristica c : caracteristicaRepository.get()) {
			if (c.getProducto().getProductoCode().equals(code)) {
				ModelProducto mp = new ModelProducto(code, c.getCaracteristicaId(), c.getCaracteristicaNombre(),
						c.getCaracteristicaComentario());
				caracteristicas.add(mp);
			}
		}
		return caracteristicas;
	}
	
	// Crea un nuevo registro de producto
	public void setProducto(String codigo, String nombre, String unidad, String precio) {
		Producto p = new Producto();
		try {
			p.setProductoCode(codigo);
			p.setProductoNombre(nombre);
			p.setProductoUnidad(unidad);
			p.setProductoPrecio(Double.parseDouble(precio));
			productoRepository.create(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Crea un nuevo registro de caracteristica
	public void setCaracteristica(String codigo, String nombre, String comentario) {
		Caracteristica c = new Caracteristica();
		Producto p = new Producto();
		try {
			p = productoRepository.getProducto(codigo);
			c.setProducto(p);
			c.setCaracteristicaNombre(nombre);
			c.setCaracteristicaComentario(comentario);
			caracteristicaRepository.create(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Actualiza un registro Producto
	public void updateProducto(String codigo, String nombre, String unidad, String precio) {
		Producto p = new Producto();
		try {
			p = productoRepository.getProducto(codigo);
		} catch (Exception e) {
		}
		try {
			p.setProductoCode(codigo);
			p.setProductoNombre(nombre);
			p.setProductoUnidad(unidad);
			p.setProductoPrecio(Double.parseDouble(precio));
			productoRepository.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Actualiza un registri de Caracteristica
	public void updateCaracteristica(String codigo,String id, String nombre, String comentario) {
		try {
			Caracteristica c = caracteristicaRepository.getCaracteristica(Integer.parseInt(id));
			Producto p = productoRepository.getProducto(codigo);
			c.setProducto(p);
			c.setCaracteristicaNombre(nombre);
			c.setCaracteristicaComentario(comentario);
			caracteristicaRepository.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Elimina un registro de Producto
	public void deteletProducto(String id) {
		try {
			productoRepository.delete(productoRepository.getProducto(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Elimina un registro de Caracteristica
	public void deleteCaracteristica(String id) {
		try {
			caracteristicaRepository.delete(caracteristicaRepository.getCaracteristica(Integer.parseInt(id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Obtiene un producto según su id
	public ModelProducto getProducto(String code) {
		Producto p = productoRepository.getProducto(code);
		ModelProducto mp = new ModelProducto(p.getProductoCode(), p.getProductoNombre(), p.getProductoUnidad(),
				p.getProductoPrecio());
		return mp;
	}
	
	// Obtiene un producto según su id
	public ModelProducto getOption(String id) {
		Caracteristica c = caracteristicaRepository.getCaracteristica(Integer.parseInt(id));
		ModelProducto mp = new ModelProducto(null, c.getCaracteristicaId(), c.getCaracteristicaNombre(),
				c.getCaracteristicaComentario());
		return mp;
	}
}
