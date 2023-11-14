/**
 * 
 */
package com.edufullstack.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.edufullstack.projectjpa.dao.DisqueraDao;
import com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl;
import com.edufullstack.projectjpa.entity.Disquera;

/**
 * 
 */
class DisquerDAOImplTest {
	
	private DisqueraDao disqueraDAO = new DisquerDAOImpl()
;	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#guardar(com.edufullstack.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#actualizar(com.edufullstack.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#eliminar(com.edufullstack.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
