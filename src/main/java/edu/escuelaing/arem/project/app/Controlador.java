package edu.escuelaing.arem.project.app;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
       // AppServer.escuchar();
      ExecutorService es= Executors.newCachedThreadPool();
      es.execute(new AppServer());
    }
}