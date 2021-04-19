package com.fp.dao;

import java.util.List;

import com.fp.exceptions.DAOException;

public interface DAO<T, K> {

	void insertar(T a) throws DAOException, ClassNotFoundException;

	void modificar(T a)throws DAOException, ClassNotFoundException;

	void eliminar(T a)throws DAOException, ClassNotFoundException;

	List<T> obtener_todos()throws DAOException, ClassNotFoundException;

	T obtener(K pk)throws DAOException, ClassNotFoundException;

}
