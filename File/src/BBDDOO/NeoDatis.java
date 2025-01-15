package BBDDOO;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class NeoDatis {

	private ODB odb;

	public NeoDatis(String BBDD) {

		this.odb = ODBFactory.open(BBDD);
	}

	public void insertarObj(Tarea tarea) {
		odb.store(tarea);
	}
	
	public void insertarObjUnicos(Tarea tarea) {  //Método válido sólo cuando creas un nuevo TipoTarea en la instancia de Tarea, si insertas TipoTareas ya creadas, no podrias y seria correcto, es decir las TipoTareas deben de repetirse
		
		boolean tareaOK = false;
		boolean tipoTareaOK = false;
				
		if(this.verificarClases(tarea)) {
			tareaOK = true;
		}else {
			System.out.println("Tarea ya insertada");
			
		}
		
		TipoTarea tipoTarea = tarea.getTipoTarea();
			
		if(this.verificarClases(tipoTarea)) {
			tipoTareaOK = true;
		}else {
			System.out.println("TipoTarea ya existe");	
		}
		if(tareaOK && tipoTareaOK) {
			odb.store(tarea);
		}
	}

	public Tarea mostrarObjXId(int id) {

		OID oid = OIDFactory.buildObjectOID(id);
		Tarea tarea = (Tarea) this.odb.getObjectFromId(oid);

		return tarea;
	}

	public <T> ArrayList<T> recuperarObjs(Class<T> clase) {

		Objects<T> objects = this.odb.getObjects(clase);

		ArrayList<T> tareas = new ArrayList<>();

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

	public List<Tarea> objsSelecc(TipoTarea tt) {
		
//		ICriterion criterio = Where.equal("tipoTarea", tt);
//		IQuery query = new CriteriaQuery(Tarea.class, criterio);

//	    IQuery query = new CriteriaQuery(Tarea.class, Where.equal("tipoTarea", tt));
		IQuery query = new CriteriaQuery(Tarea.class, Where.equal("tipoTarea.id", 1));

		Objects<Tarea> tareas = this.odb.getObjects(query);

		List<Tarea> tareasL = new ArrayList<>();

		while (tareas.hasNext()) {

			Tarea t = tareas.next();
			tareasL.add(t);
		}
		return tareasL;
	}
	
	public List<Tarea> objsSelecc(String cad) {
		
		ICriterion criterio = Where.like("descripcion", ".*" + cad + ".*" );
		IQuery query = new CriteriaQuery(Tarea.class, criterio);

		Objects<Tarea> tareas = this.odb.getObjects(query);

		
		List<Tarea> tareasL = new ArrayList<Tarea>();

		while (tareas.hasNext()) {

			Tarea t = tareas.next();
			tareasL.add(t);
		}
		return tareasL;
	}
	
	public List<Tarea> objsSelecc2(String fechaInicio, String fechaFin) {
		
		ICriterion criterio = Where.ge("fechaInicio", fechaInicio);
		ICriterion criterio2 = Where.le("fechaFin", fechaFin );
		
		ICriterion criterioCombinado = new And().add(criterio).add(criterio2);
		
		IQuery query = new CriteriaQuery(Tarea.class, criterioCombinado);

		Objects<Tarea> tareas = this.odb.getObjects(query);

		List<Tarea> tareasL = new ArrayList<Tarea>();

		while (tareas.hasNext()) {

			Tarea t = tareas.next();
			tareasL.add(t);
		}
		return tareasL;
	}
	
	public List<Tarea> objsSelecc3(String fechaInicio, String fechaFin) {
		
		ICriterion criterio = Where.gt("fechaInicio", fechaInicio);
		ICriterion criterio2 = Where.lt("fechaFin", fechaFin );
		
		ICriterion criterioCombinado = new And().add(criterio).add(criterio2);
		
		IQuery query = new CriteriaQuery(Tarea.class, criterioCombinado);

		Objects<Tarea> tareas = this.odb.getObjects(query);

		List<Tarea> tareasL = new ArrayList<Tarea>();

		while (tareas.hasNext()) {

			Tarea t = (Tarea)tareas.next();
			tareasL.add(t);
		}
		return tareasL;
	}
	
	public void modificarFinalizada(int id) {
		
		ICriterion criterio = Where.equal("id",id);
		
		IQuery query = new CriteriaQuery(Tarea.class, criterio);
		
		Objects<Tarea> tareas = this.odb.getObjects(query);
		
		Tarea t = (Tarea)tareas.next();
		
		boolean finalizada = t.isFinalizada();
		if (finalizada)finalizada=false;
		else finalizada=true;
		
		t.setFinalizada(finalizada);
		odb.store(t);
		
		System.out.println("Cambio realizado para el id: " + id);
	}
	
	public boolean verificarClases(Tarea tarea ) {
		
		int id = tarea.getId();
		
		ArrayList<Tarea> tareas =  this.recuperarObjs(Tarea.class);
		
		boolean existe = false;
		
		for (Tarea t: tareas) {
			
			if(t.getId()== id) {
				existe=true;
				break;
			}
		}
		
		return existe;	
	}
	
	public  boolean verificarClases(TipoTarea tipoTarea ) {
		
		int id = tipoTarea.getId();
		
		ArrayList<TipoTarea> tipoTareas =  this.recuperarObjs(TipoTarea.class);
		
		boolean existe = false;
		
		for (TipoTarea tt: tipoTareas) {
			
			if(tt.getId()== id) {
				existe=true;
				break;
			}
		}
		
		return existe;	
	}
	
	public void cerrarOBD() {

		this.odb.close();
	}
}
