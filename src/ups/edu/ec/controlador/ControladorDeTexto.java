/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel Lopez
 */
public class ControladorDeTexto {

    /**
     * Se declaraatributos de tipo File
     */
    private File fichero;

    /**
     * En el constructor controladorDeTexto sera vacio como las buenas practicas
     * de programacion
     */
    public ControladorDeTexto() {

    }

    /**
     * El metodo recibe como parametro un String ruta el que comprueba si la
     * ruta es correcta
     *
     * @param ruta de tipo String, comprueba la existencia de la ruta
     *
     */
    public boolean comprobarRuta(String ruta) {
        fichero = new File(ruta);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param ruta
     * @param nombre
     * @return Boolean si la ruta existe nos retorna un true y si no false
     */
    public boolean comprobar(String ruta, String nombre) {
        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * El metodo crear fichero, como el nombre lo dice estamos creando ficheros
     * controlando por exepciones.
     *
     * @param ruta En este parametro nos da de tipo String una direccion y asi
     * crear el fichero
     * @param nombre el nombre que se va a tener al nuevo fichero
     * @return Retorna un String que es la ruta absoluta de un arhivo o
     * directorio
     */
    public String crearFichero(String ruta, String nombre) {

        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fichero.getAbsolutePath();
    }

    /**
     * El metodo encripar tiene un arreglo char en cual le se manda el texto que
     * obtuvimos. El cual le añadimos un 5 de formato char, tener en cuenta que
     * lo encapsulamos para que no tenga formato numerico, luego lo devolvemos a
     * String y este ya estara cambiado toalmente
     *
     * @param rutaAbsoluta Dato de tipo String
     * @param texto Dato de tipo String
     */
    public void encriptar(String rutaAbsoluta, String texto) {

        String var = "";
        var = texto;
        char array[] = var.toCharArray();
        System.out.println(String.valueOf(array));
        int ln = array.length;
        for (int i = 0; i < ln; i++) {
            array[i] = (char) (array[i] + (char) 5);
        }
        String encriptado = String.valueOf(array);
        System.out.println(encriptado);
        try {

//               con el FileWritter que nos permite escribir archivos
            FileWriter archivoEscritura = new FileWriter(rutaAbsoluta, false);
            BufferedWriter escritura = new BufferedWriter(archivoEscritura);
            escritura.append(encriptado);
            escritura.close();
            archivoEscritura.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ruta no encontrada");
        } catch (IOException ex1) {
            System.out.println("Error de escritura");
        } catch (Exception ex2) {
            System.out.println("Error ");
        }
    }

}
