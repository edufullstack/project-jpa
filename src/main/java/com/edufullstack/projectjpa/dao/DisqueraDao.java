/**
 * 
 */
package com.edufullstack.projectjpa.dao;

import java.util.List;

import com.edufullstack.projectjpa.entity.Disquera;

/**
 * @author Edufullstack
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDao {

	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Disquera disquera);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
}
