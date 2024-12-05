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

		IQuery query = new CriteriaQuery(Tarea.class, Where.equal("tipoTarea", tt));

		Objects<Tarea> tareas = this.odb.getObjects(query);

		List<Tarea> tareasL = new ArrayList();

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

		List<Tarea> tareasL = new ArrayList();

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

		List<Tarea> tareasL = new ArrayList();

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

		List<Tarea> tareasL = new ArrayList();

		while (tareas.hasNext()) {

			Tarea t = tareas.next();
			tareasL.add(t);
		}
		return tareasL;
	}
	
	

	public void cerrarOBD() {

		this.odb.close();
	}
}
