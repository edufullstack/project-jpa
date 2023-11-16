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
import jakarta.persistence.TypedQuery;

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
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada = em.find(Disquera.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disqueraConsultada);
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
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera= (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
		
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
