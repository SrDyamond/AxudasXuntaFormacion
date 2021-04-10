package com.fp.dao;

import java.util.List;

import com.fp.exceptions.DAOException;

public interface DAO<T, K> {

	void insertar(T a) throws DAOException;

	void modificar(T a)throws DAOException;

	void eliminar(T a)throws DAOException;

	List<T> obtener_todos()throws DAOException;

	T obtener(K pk)throws DAOException;

}
