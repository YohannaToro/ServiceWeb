
package edu.escuelaing.arem.project.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 
 */
public class test {

    /**
     * retorna un string de una funcion que tiene posee una etiqutea
     * @return
     */
    @Web("test")
    public static String prueba() {
        return "hola este framework es hecho por Yohanna Toro";

    }

    /**
     * funcion que posee una etiqueta y retorna hola + el parametro que se pasa
     * @param name
     * @return
     */
    @Web("hola")
    public static String holaName(String name) {
        System.out.println("hola");
        return "hola:  "+ name;
    }
}