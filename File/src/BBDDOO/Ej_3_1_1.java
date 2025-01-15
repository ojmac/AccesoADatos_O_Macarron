package BBDDOO;

import java.util.ArrayList;
import java.util.List;

public class Ej_3_1_1 {

	/*
	 * Ejercicio 3.1.1 Al tipo de datos de tareas del Ejercicio 7.1 de la unidad
	 * Manejo de conectores le vamos a hacer un pequeño pero significativo cambio.
	 * Vamos a añadirle un nuevo campo tipoTarea que se corresponderá a su vez con
	 * una nueva clase (TipoTarea) compuesta por los campos id, abreviatura y
	 * descripción.
	 * 
	 * Teniendo en cuenta estas nuevas clases de datos, implementa una clase con un
	 * método que inserte un objeto de tipo Tarea en una base de datos de NeoDatis.
	 * 
	 * En la misma clase: Implementa un método que inserte un listado de objetos de
	 * tipo tarea (List<Tarea>) en dicha base de datos. Implementa un método que
	 * muestre una tarea dado su id. Implementa un método que muestre todos los
	 * datos de tipo de tareas guardados en la base de datos. Implementa un método
	 * que muestre todos los datos de tareas guardados en la base de datos.
	 * 
	 * Emplea los métodos de Test necesarios para la ejecución de los métodos
	 * anteriores.
	 */
	
	private TipoTarea tt1 = new TipoTarea(1, "deb", "hacer deberes");
	private TipoTarea tt2 = new TipoTarea(2, "comp", "hacer compras");
	private TipoTarea tt3 = new TipoTarea(3, "est", "estudios");
	private TipoTarea tt4 = new TipoTarea(4, "viaj", "viajes");
	private TipoTarea tt5 = new TipoTarea(5, "var", "varios personal");

	public void insertarObj() {

		NeoDatis nd = new NeoDatis("BBDDTareas.db");

		Tarea t = new Tarea(9, "hacer Interfaces", "2024-12-4", "2024-12-6", false, tt1);

		nd.insertarObj(t);
		nd.cerrarOBD();
		System.out.println("Dato insertado correctamente");
	}

	public void insertarListado() {

		NeoDatis nd = new NeoDatis("BBDDTareas.db");

		Tarea t1 = new Tarea(1, "Comprar manzanas", "2024-02-15", "2024-02-16", true, tt2);
		Tarea t2 = new Tarea(2, "Estudiar examen", "2024-05-02", "2024-05-18", true, tt3);
		Tarea t3 = new Tarea(3, "Comprar billete para Sidney", "2024-02-15", "2024-05-20", true, tt2);
		Tarea t4 = new Tarea(4, "Ir a Australia", "2024-06-01", "2024-08-25", true, tt4);
		Tarea t5 = new Tarea(5, "Revisión del coche", "2024-10-08", "2024-10-16", true, tt5);
		Tarea t6 = new Tarea(6, "Otra cosa", "2024-10-01", "2024-12-01", false, tt5);
		Tarea t7 = new Tarea(7, "Práctica JDBC", "2024-10-30", "2024-11-07", false, tt3);
		Tarea t8 = new Tarea(8, "FCT", "2025-03-01", "2025-05-24", false, tt3);

		List<Tarea> tareas = new ArrayList();

		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
		tareas.add(t4);
		tareas.add(t5);
		tareas.add(t6);
		tareas.add(t7);
		tareas.add(t8);

		for (Tarea t : tareas) {

			nd.insertarObj(t);
		}
		nd.cerrarOBD();
		System.out.println("Datos insertados correctamente");
	}

	public void obtenerObjXId(int id) {

		NeoDatis nd = new NeoDatis("BBDDTareas.db");

		Tarea buscada = nd.mostrarObjXId(id);

		nd.cerrarOBD();

		System.out.println(buscada);

	}

	public void mostrarTipoTareas() {

		NeoDatis nd = new NeoDatis("BBDDTareas.db");

		List<TipoTarea> tts = nd.recuperarObjs(TipoTarea.class);

		nd.cerrarOBD();

		for (TipoTarea tt : tts) {

			System.out.println(tt);

		}
	}

	public void mostrarTareas() {

		NeoDatis nd = new NeoDatis("BBDDTareas.db");

		List<Tarea> ts = nd.recuperarObjs(Tarea.class);

		nd.cerrarOBD();

		for (Tarea t : ts) {

			System.out.println(t);

		}

	}

	public void mostrarTareas2() {

		NeoDatis nd = new NeoDatis("BBDDTareas2.db");

		List<Tarea> ts = nd.recuperarObjs(Tarea.class);

		nd.cerrarOBD();

		for (Tarea t : ts) {

			System.out.println(t);

		}

	}

}
