package com.miec.utils;

import java.util.List;

// Implementación de la clase Abstracta
public interface Dao<T> {
	
	public List<T> get();
	
	public void create(T e);

	public void update(T u);

	public void delete(T d);
	
}
