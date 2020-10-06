package com.miec.repository;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miec.entity.Caracteristica;
import com.miec.utils.Abs;
import com.miec.utils.Dao;
// Se crea repositorios de la clase Caracteristica que se implementara en el dominio
@Repository
@Transactional
public class CaracteristicaRepository extends Abs<Caracteristica> implements Dao<Caracteristica> {

	@Autowired
	private SessionFactory sessionFactory;

	public CaracteristicaRepository() {
		super(Caracteristica.class);
	}

	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
	
	//  Obtener una entidad Caracteristica por su Id
	public Caracteristica getCaracteristica(int id) {
		String query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaId = ?1";
		TypedQuery<Caracteristica> sql = sessionFactory.getCurrentSession().createQuery(query, Caracteristica.class);
		return sql.setParameter(1, id).getSingleResult();
	}
}
