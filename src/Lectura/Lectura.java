package Lectura;

import Modelo_Datos.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

//*************************
// LECTURA ARCHIVOS XML
//*************************

public class Lectura {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //ubicación del archivo para leer
        File ficheroEmpleadosXML = new File("./src/empleados.xml");

        // necesitamos parsear el fichero XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // luego lo instanciamos
        DocumentBuilder db = dbf.newDocumentBuilder();
        // y finalmente parseamos el fichero
        Document documento = db.parse(ficheroEmpleadosXML);

        documento.getDocumentElement().normalize();//quitar cosas raras antes de leerlo
        // muestra NODO principal del documento en este caso -> Empleados
        System.out.println("Raiz del documento -> " + documento.getDocumentElement().getNodeName());

        // obtener la lista de NODOS HIJOS

        NodeList nodos = documento.getElementsByTagName("empleado");// nodos hijos de Empleados

        // debemos recorrer todo el contenido que tiene el nodohijo

        for (int i = 0; i < nodos.getLength(); i++) {
            Node n = nodos.item(i); // extraemos el primer nodo en este caso es el ID
            System.out.println(n.getNodeName()); // lo mostramos por pantalla
            //comprobamos si tiene contenido dentro (otros nodos)
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element empleado = (Element) n; // esto es necesario para poder extraer su atributo en este caso el DNI
                // ATRIBUTOS
                String dni = empleado.getAttribute("dni"); //guardamos el atributo dni
                // CONTENIDO DE LOS NODOS
                // cogemos el contenido del ID y lo guardamos
                int id = Integer.parseInt(empleado.getElementsByTagName("id").item(0).getTextContent());
                // cogemos el contenido del APELLIDO y lo guardamos
                String apellido = empleado.getElementsByTagName("apellido").item(0).getTextContent();
                int dep = Integer.parseInt(empleado.getElementsByTagName("dep").item(0).getTextContent());
                float salario = Float.parseFloat(empleado.getElementsByTagName("salario").item(0).getTextContent());

                //CREAMOS objeto

                Empleado emp = new Empleado(id,apellido,dep,salario);
                //mostramos todo su contenido
                System.out.println(emp.toString());
            }
        }
    }
}
