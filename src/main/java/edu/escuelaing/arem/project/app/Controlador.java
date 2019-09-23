package edu.escuelaing.arem.project.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SocketHandler;

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

    private static ExecutorService es = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        
        AppServer.inicializar();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port");
            System.exit(1);
        }

        while (true) {
            Socket clientSocket = null;

            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
                AppServer server = new AppServer(getPort());
                System.out.println(es.toString());
                es.submit(server);

            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

        }
    }

    /**
     * funcion para obtener un puerto por el cual el servidor va a trabajar
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        // returns default port if heroku-port isn't set (i.e. on localhost)

    }
}