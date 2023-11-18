package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaces.Iusuarioable;
import model.TblUsuario;
public class ClassCrudUsuario implements Iusuarioable{

	public void RegistrarUsuario(TblUsuario usu) {
		// TODO Auto-generated method stub
		
	}

	public void ActualizarUsuario(TblUsuario usu) {
		// TODO Auto-generated method stub
		
	}

	public void EliminarUsuario(TblUsuario usu) {
		// TODO Auto-generated method stub
		
	}

	public List<TblUsuario> ListadoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	public TblUsuario BuscarUsuario(TblUsuario usu) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ValidarUsuario(TblUsuario usu) {
		
		//establecemos la conexion con la unidad de persistencia
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("proyectoMabeLpIITUNO");
		//para gestionar entidades
		EntityManager em =factory.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//aplicamos jpql relacionado con entidades
		Query consulta = em.createQuery("select u from TblUsuario u where   u.usuario=:x and u.password=:y",TblUsuario.class);
		//pasamos los parametros
		consulta.setParameter("x",usu.getUsuario());
		consulta.setParameter("y",usu.getPassword());
		//variable para mensaje
		String mensaje="";
		TblUsuario u;
		try{
			u=(TblUsuario) consulta.getSingleResult();
			mensaje="existe";
		}catch(Exception ex){
			u=null;
			mensaje="noexiste";
		}
		//fin del catch
		
		
		return mensaje;
	}


}
