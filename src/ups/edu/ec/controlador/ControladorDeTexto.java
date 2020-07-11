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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class ControladorDeTexto {

    private String ruta;
    private File fichero;

    public ControladorDeTexto() {

    }

    public boolean comprobarRuta(String ruta) {
        fichero = new File(ruta);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobar(String ruta, String nombre) {
        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

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
