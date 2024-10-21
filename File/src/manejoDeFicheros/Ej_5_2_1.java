package manejoDeFicheros;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej_5_2_1 {
	
	
	public void leerXML() {
		
		try {
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = fact.newDocumentBuilder();
			Document doc = builder.parse("./xmlCoches.xml");
			doc.normalize();
			
			NodeList coches = doc.getElementsByTagName("coche");
			for (int i = 0; i < coches.getLength(); i++) {
				
				    Element coche = (Element) coches.item(i);
	                String matricula = coche.getAttribute("matricula"); 
	                Element eMarca = (Element) coche.getElementsByTagName("marca").item(0);
	                String marca = eMarca.getTextContent(); 
	                Element eAnio = (Element) coche.getElementsByTagName("anio").item(0);
	                String anio = eAnio.getTextContent();
	             	System.out.printf("matricula: %s, marca:  %s año: %s " 
	                + System.lineSeparator(), matricula, marca, anio);
			}
		} catch (SAXException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	  	} catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();      	 
	       	 
		} catch (ParserConfigurationException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
		}	
	}
}
