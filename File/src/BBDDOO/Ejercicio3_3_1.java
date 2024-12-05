package BBDDOO;

import java.util.List;

import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Ejercicio3_3_1 {
	
/*Ejercicio 3.3.1 Partiendo de la clase implementada en el Ejercicio 2.2.1, añade los siguientes métodos:
Método que muestre las tareas de un tipo determinado
Método que muestre las tareas cuya descripción contenga una cadena determinada
Método que muestre las tareas comprendidas entre dos fechas (ambas incluidas)
Método que muestre las tareas comprendidas entre dos fechas (ambas no incluidas)

Emplea los métodos de Test necesarios para la ejecución de los métodos anteriores.
*/
	

	public void mostrarTareasXTT(TipoTarea tt) {

		NeoDatis nd = new NeoDatis("BBDDTareas2.db");
		List<Tarea> tareasSelecc = nd.objsSelecc(tt);
		nd.cerrarOBD();
		
		for (Tarea t : tareasSelecc) {

			System.out.println(t);
		}	
	}

	public void mostrarTareasXCadEnDescrip(String cad) {
		
		NeoDatis nd = new NeoDatis("BBDDTareas2.db");
		List<Tarea> tareasSelecc = nd.objsSelecc(cad);
		nd.cerrarOBD();
		
		for (Tarea t : tareasSelecc) {

			System.out.println(t);
		}	
	}
	public void mostrarTareasEntreDosFechasInc(String fechaInicio, String fechaFinal) {
		
		NeoDatis nd = new NeoDatis("BBDDTareas2.db");
		List<Tarea> tareasSelecc = nd.objsSelecc2(fechaInicio, fechaFinal);
		nd.cerrarOBD();
		
		for (Tarea t : tareasSelecc) {

			System.out.println(t);
		}	
	}
	public void mostrarTareasEntreDosFechasExc(String fechaInicio, String fechaFinal) {
		
		NeoDatis nd = new NeoDatis("BBDDTareas2.db");
		List<Tarea> tareasSelecc = nd.objsSelecc3(fechaInicio, fechaFinal);
		nd.cerrarOBD();
		
		for (Tarea t : tareasSelecc) {

			System.out.println(t);
		}	
	}
		
	
	
}
