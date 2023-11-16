/**
 * 
 */
package com.edufullstack.projectjpa.dao.impl;

import java.util.List;

import com.edufullstack.projectjpa.dao.DisqueraDao;
import com.edufullstack.projectjpa.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author edufullstack Clase que implementa las transacciones para la tabla de
 *         Disquera.
 */
public class DisquerDAOImpl implements DisqueraDao {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceEdufullstack");

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}


	}

	@Override
	public void eliminar(Disquera disquera) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Disquera> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disquera consultarById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultado = em.find(Disquera.class,id);
		
		if(disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id " + id + " no se encontró");
		}
		return disqueraConsultado;
	}

}
