package manejoDeFicheros;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class Ej_5_3_1 {

	/*
	 * Ejercicio 5.3.1 A partir del fichero de salida obtenido como resultado del
	 * Ejercicio 3.2.2, implementa una clase con un método que recupere la
	 * información y la escriba en un fichero con formato XML.Implementa en la clase
	 * un segundo método que a partir del resultado XML anterior lo vuelva a leer
	 * para incrementar en uno el año de matriculación de todos los coches
	 * registrados. Emplea un método de Test para la ejecución de todos los métodos
	 * de la clase.
	 */

	public void datosCoches2(String nomArch) {
		DataInputStream dis = null;

		String[] marcas = new String[3];
		String[] matriculas = new String[3];
		int[] anyosMatriculacion = new int[3];

		try {
			FileInputStream fis = new FileInputStream(nomArch);
			dis = new DataInputStream(fis);
			for (int i = 0; i < 3; i++) {

				marcas[i] = dis.readUTF();
				matriculas[i] = dis.readUTF();
				anyosMatriculacion[i] = dis.readInt();

			}
		} catch (IOException e) {
			System.out.println("Fin");
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		creaXML(marcas, matriculas, anyosMatriculacion);
	}

	public void creaXML(String[] marcas, String[] matriculas, int[] anyosMatriculacion) {

		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation dImp = builder.getDOMImplementation();
			Document doc = dImp.createDocument(null, "coches", null);
			doc.setXmlVersion("1.0");
			for (int i = 0; i < matriculas.length; i++) {
				Element coche = doc.createElement("coche");
				coche.setAttribute("matricula", matriculas[i]);
				CreaNodo(doc, coche, "marca", marcas[i]);
				CreaNodo(doc, coche, "año_Matriculacion", String.valueOf(anyosMatriculacion[i]));
				doc.getDocumentElement().appendChild(coche);
			}
			TransformerFactory factoriaT = TransformerFactory.newDefaultInstance();
			try {
				Transformer transformador = factoriaT.newTransformer();
				Source s = new DOMSource(doc);
				Result r = new StreamResult("coches.xml");
				transformador.transform(s, r);
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		}

	}

	private void CreaNodo(Document doc, Element coche, String string, String string2) {

		Element nodo = doc.createElement(string);
		Text valor = doc.createTextNode(string2);
		nodo.appendChild(valor);
		coche.appendChild(nodo);
	}

	public void modificarXML() {

		try {

			File archivoXML = new File("coches.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivoXML);
			doc.normalize();

			NodeList listaCoches = doc.getElementsByTagName("coche");
			for (int i = 0; i < listaCoches.getLength(); i++) {
				Element coche = (Element) listaCoches.item(i);
				NodeList anyoMatriculacion = coche.getElementsByTagName("año_Matriculacion");
				if (anyoMatriculacion.getLength() > 0) {
					Element anyo = (Element) anyoMatriculacion.item(0);
					int añoActual = Integer.parseInt(anyo.getTextContent());
					anyo.setTextContent(String.valueOf(añoActual + 1));
				}
			}

			TransformerFactory factoryT = TransformerFactory.newInstance();
			Transformer transformador = factoryT.newTransformer();
			Source s = new DOMSource(doc);
			Result r = new StreamResult("coches.xml");
			transformador.transform(s, r);
			transformador.transform(s, r);

			System.out.println("Archivo XML actualizado correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
