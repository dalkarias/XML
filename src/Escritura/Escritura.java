package Escritura;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

//*************************
// ESCRITURA ARCHIVOS XML
//*************************

public class Escritura {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Esto creara un fichero nuevo de xml
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document documento = db.newDocument();

        //montamos el documento
        Element raiz = documento.createElement("Estudiantes");
        documento.appendChild(raiz);//se conecta al padre ne este caso EL DOCUMENTO

        //creamos ahora a los hijos de ESTUDIANTES

        //estudiante
        Element est1 = documento.createElement("estudiante");//creamos nodo estudiante
        raiz.appendChild(est1);// se lo insertamos al nodo padre
        //atributo
        Attr dni1 = documento.createAttribute("dni");//creamos el atributo
        dni1.setValue("123456789");// le damos el valor
        est1.setAttributeNode(dni1);// y le insertamos el atributo al nodo que pertenece en este caso estudiante

        Element nom = documento.createElement("nombre");
        est1.appendChild(nom);
        nom.setTextContent("Grey");

        Element nota1 = documento.createElement("nota"); // creamos el nodo nota
        est1.appendChild(nota1);//este va ligado al padre estudiante NO A ESTUDIANTES QUE ES EL ABUELO
        nota1.setTextContent("4.5");// damos valor al nodo nota

        // otro estudiante
        Element est2 = documento.createElement("estudiante");
        raiz.appendChild(est2);

        Attr dni2 = documento.createAttribute("dni");
        dni2.setValue("26759041J");
        est2.setAttributeNode(dni2);

        Element nom1 = documento.createElement("nombre");
        est2.appendChild(nom1);
        nom1.setTextContent("Dani");

        Element nota2 = documento.createElement("nota");
        est2.appendChild(nota2);
        nota2.setTextContent("9.85");

        // Transforma los ELEMETS a DOM Y los escribe en un fichero
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer optimus = tf.newTransformer();
        //compone el documento
        DOMSource ds = new DOMSource(documento);

        optimus.setOutputProperty(OutputKeys.INDENT,"yes");//re-estructura el archivo

        //creamos el archivo que va alvegar la información
        File ficheroEstudiantes = new File("./src/estudantes.xml");
        // este objeto permitira que se escriban en el archivo
        StreamResult result = new StreamResult(ficheroEstudiantes);
        // finalmente crea el archivo xml
        optimus.transform(ds,result);

    }
}
