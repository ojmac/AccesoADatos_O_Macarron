package ORM;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import hibernate.entity.Coche;
import hibernate.entity.Reparacion;

/*Ejercicio 3.12 Sobre los ejemplos diseñados en el ejercicio 3.8 
 * implementa lo necesario para realizar consultas sobre la base de datos que 
 * permitan para la relación OneToMany:
 * obtener todos los objetos de la clase principal y secundaria
 * obtener objetos de una clase añadiendo algún criterio de búsqueda 
 * en la clase principal (cada cuál decide el criterio, pero lo indica en un comentario
 *  sobre la implementación correspondiente)
 *  obtener objetos de una clase utilizando las relaciones entre clases 
 *  (haciendo referencia a algún atributo de la clase secundaria)
 *  lanzar consultas directamente en lenguaje SQL
 *  Emplea los métodos de test que permitan ejecutar todas estas operaciones.
*/


public class ConsultasOMR {
	
	 
	private ArrayList<Coche> coches;
	private ArrayList<Reparacion>reparaciones;
	private ArrayList<Coche> cochesMarcaX;
	private ArrayList<Reparacion>reparacionesCocheX;
	
	private ArrayList<Coche> cochesVolvo;
	private ArrayList<Reparacion> reparacionesCaras;

	
	
	public void obtenerObjetosDeLasClases() {
		
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Coche");
		this.coches = (ArrayList<Coche>) query.list();

		Query query2 = HibernateUtil.getCurrentSession().createQuery("FROM Reparacion");
		this.reparaciones = (ArrayList<Reparacion>) query2.list();
		
	}

	
	public void obtenerObjetosConCriterio(String marca, String matricula) {
		
		
		Query query = HibernateUtil.getCurrentSession().createQuery("FROM Coche c WHERE c.marca = :marca");
		query.setParameter("marca", marca);
		this.cochesMarcaX = (ArrayList<Coche>) query.list();

		Query query2= HibernateUtil.getCurrentSession().createQuery("FROM Reparacion r WHERE r.Coche.matricula = :matricula");
		query.setParameter("matricula", matricula);
		this.reparacionesCocheX = (ArrayList<Reparacion>) query2.list();
	}
	
	
	public void pruebasSQLPuro() {
		
		String marca = "volvo";
		
		Query sqlQuery = HibernateUtil.getCurrentSession().createSQLQuery(
				"SELECT matricula, modelo FROM coches WHERE marca = :marca");
		sqlQuery.setParameter("marca", marca);
		
		this.cochesVolvo = (ArrayList<Coche>) sqlQuery.list();
		
		int precioMax = 10000;
		
		Query sqlQuery2 = HibernateUtil.getCurrentSession().createSQLQuery(
				"SELECT id, detalle FROM reparacion WHERE precio > :precioMax");
		sqlQuery.setParameter("precioMAx", precioMax);
		
		this.reparacionesCaras = (ArrayList<Reparacion>) sqlQuery2.list();
	}
	
}
