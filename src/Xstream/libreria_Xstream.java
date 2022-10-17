package Xstream;

import Modelo_Datos.Empleado;
import com.thoughtworks.xstream.XStream;

public class libreria_Xstream {
    public static void main(String[] args) {
        /*Gracias a la libreria
        sustituimos la creacion del objeto
        que se escribira en el documento DOM
        Programa Escritura de la linea 50 a la 64
        te ahorras esas lineas en tan solo 3*/

        //creamos el objeto empleado
        Empleado empleado = new Empleado(1,"García",20,2500.30f);
        //usamos el objeto de la libreria
        XStream xs = new XStream();
        // nos muestra una lectura del objeto como si fuera un archivo xml o dom
        //System.out.println(xs.toXML(empleado));

        xs.allowTypesByWildcard(new String[] {"Modelo_Datos.Empleado"});//  *!* DAMOS PERMISOS PARA QUE PUEDA ACCEDER A EMPLEADO

        String guardar_Empleado = xs.toXML(empleado); //guardamos el xs con el contenido del objeto EMPLEADO en el string

        System.out.println(guardar_Empleado);//comprobamos que se ha guardado

        Empleado empleado2 = new Empleado();//creamos otro objeto vacio

        xs.fromXML(guardar_Empleado,empleado2);//guardamos ese STRING en formato xml en el objeto empleado2
        //CUIDADO FALLARA
        // YA QUE TIENES QUE DARLE PERMISOS PARA QUE PUEDA ACCEDER AL MODELO DE DATOS *!*

        System.out.println("\n"+empleado2);//comprobamos que lo ha transferido al objeto empleado2
    }
}
