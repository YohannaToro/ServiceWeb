package edu.escuelaing.arem.project.app;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Controlador {
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        AppServer.inicializar();
        AppServer.escuchar();
    }
}