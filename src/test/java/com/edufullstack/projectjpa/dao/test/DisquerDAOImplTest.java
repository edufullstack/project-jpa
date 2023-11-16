/**
 * 
 */
package com.edufullstack.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

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
		disquera.setDescripcion("Elektriks");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#actualizar(com.edufullstack.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
		
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		
		this.disqueraDAO.actualizar(disqueraConsultada);
		
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#eliminar(com.edufullstack.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		
		List<Disquera> disquerasConsultadas =  this.disqueraDAO.consultar();
		
		assertTrue(disquerasConsultadas.size() > 0);
		
		disquerasConsultadas.forEach(disquera -> {
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.edufullstack.projectjpa.dao.impl.DisquerDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);
		
		System.out.println("Disquera: " + disquera.getDescripcion());
	}

}
