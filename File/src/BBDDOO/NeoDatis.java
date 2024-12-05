package BBDDOO;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

public class NeoDatis {
	
	private ODB odb;

	public NeoDatis(String BBDD) {
		
		this.odb = ODBFactory.open(BBDD);	
	}
	
	public void insertarObj(Tarea tarea) {
		odb.store(tarea);
	}
	
	public Tarea mostrarObjXId(int id) {
		
		OID oid = OIDFactory.buildObjectOID(id);
		Tarea tarea = (Tarea) this.odb.getObjectFromId(oid);
		
		return tarea;
	}
	
	
	
	public <T> ArrayList<T> recuperarObjs(Class<T> clase) {
		
		Objects<T> objects = this.odb.getObjects(clase);
		
		ArrayList <T> tareas = new ArrayList<>();
		
		while (objects.hasNext()) {
			
			T obj = objects.next();
			tareas.add(obj);	
		}
		return tareas;
	}
	

//	public ArrayList<TipoTarea> recuperarObjsTipoTarea() {
//		
//		Objects<TipoTarea> objects = this.odb.getObjects(TipoTarea.class);
//		
//		ArrayList <TipoTarea> tipoTareas = new ArrayList<>();
//		
//		while (objects.hasNext()) {
//			
//			TipoTarea tipoTarea = objects.next();
//			tipoTareas.add(tipoTarea);	
//		}
//		return tipoTareas;
//	}
	
	public void cerrarOBD() {
		
		this.odb.close();
	}
	
	
	
}
