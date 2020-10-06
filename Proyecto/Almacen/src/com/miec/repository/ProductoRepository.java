package com.miec.repository;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miec.entity.Producto;
import com.miec.utils.Abs;
import com.miec.utils.Dao;
//Se crea repositorios de la clase Producto que se implementara en el dominio
@Repository
@Transactional
public class ProductoRepository extends Abs<Producto> implements Dao<Producto>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductoRepository() {
		super(Producto.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
	
//  Obtener una entidad Producto por su Id
	public Producto getProducto(String id) {
		String query = "SELECT p FROM Producto p WHERE p.productoCode = ?1";
		TypedQuery<Producto> sql = sessionFactory.getCurrentSession().createQuery(query,Producto.class); 
		return sql.setParameter(1, id).getSingleResult();
	}
}
