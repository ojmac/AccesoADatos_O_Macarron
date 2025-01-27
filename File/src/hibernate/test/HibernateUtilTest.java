package hibernate.test;


import java.sql.Date;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import ORM.HibernateUtil;
import hibernate.entity.Coche;
import hibernate.entity.Conductor;
import hibernate.entity.PermisoCirc;
import hibernate.entity.Reparacion;

class HibernateUtilTest {
	@Test
	void test1() {
		try (Session sesion = HibernateUtil.openSession()){
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/*Ejercicio 3.10 Sobre los ejemplos diseñados en el ejercicio 
	 * 3.8 implementa lo necesario para realizar operaciones en la base de datos 
	 * que permitan crear registros, buscar por id y eliminar registros de la base de datos 
	 * para los tres tipos de relaciones abordadas en dicho ejercicio.
	 * Emplea los métodos de test que permitan ejecutar todas estas operaciones.
	 */

	
	@Test
	void test() {
		
		try(Session sesion = HibernateUtil.openSession()){
			
			
						
			PermisoCirc permisoC1 = new PermisoCirc(0001, "2024-12-01", "2025-12-01", null);
			
			
			
			Reparacion rep1 = new Reparacion("100AA" ,"rotura tubo de escape", 454.56, null);
			Reparacion rep2 = new Reparacion("100BB" ,"rotura junta de la trocola", 533.23, null);
			
			Conductor cond1= new Conductor(12121,"Manolo", 26);
			Conductor cond2= new Conductor(34343,"Pepe", 14);
			
			Coche c1 = new Coche("AAA111", "Maserati","SuperSport", 2021, "Gris", 220, permisoC1);
			
			cond1.setCoche(c1);
			cond2.setCoche(c1);
			
			permisoC1.setCoche(c1);
			rep1.setCoche(c1);
			rep2.setCoche(c1);
			
			c1.setReparaciones1(rep1);
			c1.setReparaciones1(rep2);
			
			c1.setConductor(cond1);
			c1.setConductor(cond2);
			
			sesion.beginTransaction();
			
			sesion.save(c1);
			sesion.save(permisoC1);
			
			for (Reparacion r: c1.getReparaciones()) {
				sesion.save(r);	
			}
			for (Conductor c: c1.getConductores()) {
				sesion.save(c);
			}
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
