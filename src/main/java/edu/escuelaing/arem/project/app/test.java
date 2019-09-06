
package edu.escuelaing.arem.project.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 2132219
 */
public class test {

    @Web("test")
    public static String prueba() {
        return "hola amiwis coronamos";

    }
    @Web("test2")
    public static String greeting(String name) {
        System.out.println("hola");
        return "hola"+name;
    }
}