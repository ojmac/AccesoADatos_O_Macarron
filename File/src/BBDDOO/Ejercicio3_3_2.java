package BBDDOO;

public class Ejercicio3_3_2 {
	
	/*Ejercicio 3.3.2 Partiendo de las clases implementadas en el Ejercicio 3.1.1 
	 * (los dos métodos que añaden tareas y el método que muestra todas las tareas)
	 * y Ejercicio 3.3.1 (todos los métodos), crea una clase que gestione los datos 
	 * de la aplicación (listado de tareas y listado de países) de modo que cuando 
	 * se inserte una tarea o un país no existan ids duplicados. Crea varios métodos 
	 * de Test que inserten en la base de datos distintos listados de tareas 
	 * (algunas duplicadas) para comprobar que se cumple esta última premisa.*/
	
	
	public void insertarVerificandoClases(Tarea tarea) {
		
		NeoDatis nd = new NeoDatis("BBDDTareas2.db");
		
		nd.insertarObjUnicos(tarea);
		
		nd.cerrarOBD();
	
	}
}
