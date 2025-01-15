package hibernate.test;


import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import ORM.HibernateUtil;
import hibernate.entity.Coche;

class HibernateUtilTest {
	@Test
	void test1() {
		try (Session sesion = HibernateUtil.openSession()){
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	void test() {
		try(Session sesion = HibernateUtil.openSession()){
			Coche coche1 = new Coche("1111abc", "Ferrari", "Testarosa", 2020, "Rojo", 211.12 );
			Coche coche2 = new Coche("2222bcd", "Lamborghini", "Aventador", 2021, "Amarillo", 315.50);
			Coche coche3 = new Coche("3333cde", "Porsche", "911 Turbo", 2019, "Negro", 280.75);
			Coche coche4 = new Coche("4444def", "Bugatti", "Chiron", 2022, "Azul", 490.20);
			Coche coche5 = new Coche("5555efg", "Tesla", "Model S Plaid", 2023, "Blanco", 200.00);
			Coche coche6 = new Coche("6666fgh", "McLaren", "720S", 2021, "Naranja", 341.70);
			Coche coche7 = new Coche("7777ghi", "Aston Martin", "DB11", 2020, "Verde", 250.30);
			Coche coche8 = new Coche("8888hij", "Rolls-Royce", "Phantom", 2022, "Plata", 160.45);
			Coche coche9 = new Coche("9999ijk", "Ford", "Mustang Shelby GT500", 2018, "Rojo", 290.15);
			Coche coche10 = new Coche("1010jkl", "Chevrolet", "Corvette Stingray", 2021, "Azul", 312.80);
			
			sesion.beginTransaction();
			sesion.save(coche1);
			sesion.save(coche2);
			sesion.save(coche3);
			sesion.save(coche4);
			sesion.save(coche5);
			sesion.save(coche6);
			sesion.save(coche7);
			sesion.save(coche8);
			sesion.save(coche9);
			sesion.save(coche10);
			sesion.getTransaction().commit();	
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
