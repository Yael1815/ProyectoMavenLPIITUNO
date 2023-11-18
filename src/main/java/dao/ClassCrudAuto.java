package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.Iautoable;
import model.TblAuto;

public class ClassCrudAuto implements Iautoable {

	
	public void RegistrarAuto(TblAuto tblauto) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		EntityManager emanager= em.createEntityManager();
		
		emanager.getTransaction().begin();
		emanager.persist(tblauto);
		System.out.print("auto registrado en BD");
		emanager.getTransaction().commit();
		emanager.close();
		
	}

	
	public void ActualizarAuto(TblAuto tblauto) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		EntityManager emanager= em.createEntityManager();
		
		emanager.getTransaction().begin();
		emanager.merge(tblauto);
		System.out.print("auto actualizado en BD");
		emanager.getTransaction().commit();
		emanager.close();
		
		
	}

	
	public void EliminarAuto(TblAuto tblauto) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		EntityManager emanager= em.createEntityManager();
		
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblAuto elim=emanager.merge(tblauto);
		emanager.remove(elim);
		System.out.print("auto eliminado en BD");
		emanager.getTransaction().commit();
		emanager.close();
		
		
	}

	
	public TblAuto BuscarAuto(TblAuto tblauto) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		EntityManager emanager= em.createEntityManager();
		
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblAuto buscar=emanager.find(TblAuto.class,tblauto.getIdauto());
		emanager.remove(buscar);
		
		System.out.println("auto eliminado en BD");
		emanager.getTransaction().commit();
		emanager.close();
		
		return buscar;
	}

	
	public List<TblAuto> Listado() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		EntityManager emanager= em.createEntityManager();
		
		emanager.getTransaction().begin();
		List<TblAuto> listado=emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();		
		
		emanager.getTransaction().commit();
		emanager.close();
		
		return listado;
		
	}

}
