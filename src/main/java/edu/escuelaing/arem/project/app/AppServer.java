package edu.escuelaing.arem.project.app;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.HashMap;
import java.util.logging.Handler;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;


import javax.print.DocFlavor.STRING;

import edu.escuelaing.arem.project.app.model.Handlers;
import edu.escuelaing.arem.project.app.model.UrlHandler;

/**
 *
 * @author YohannaToro
 */
public class AppServer {

    private static HashMap<String, Handlers> hm = new HashMap<String, Handlers>();
    

    /**Escucha el puerto por donde se esta realizando la peticion
     *
     * @throws IOException
     */
    public static void escuchar() throws IOException {
        ServerSocket serverSocket = null;
        Browser br;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        while (true) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            br=new Browser(in,out,hm);
            String headr = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n"+"\r\n";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                getRequest(inputLine,headr,clientSocket,br);
                if (!in.ready()) {
                    break;
                }
            }
            out.close();
            in.close();
            clientSocket.close();
        }

    }

    /**
     * Inicializa la clase que tiene las anotaciones 
     */
    public static void inicializar() {
        try {
            String p = "edu.escuelaing.arem.project.app.";
            bind(p + "test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *retorna el puerto que se esta pidiendo
     * @return int 
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

    /**
     * carga los metodos que poseen anotaciones y los agraga al hashmap
     * @param classpath camino de la clase donde se instancio
     */
    private static void bind(String classpath) {
        try {

            Class c = Class.forName(classpath);          
            for (Method m : c.getMethods()) {
                if (m.isAnnotationPresent(Web.class)) {
                    Handlers h = new UrlHandler(m);
                    hm.put("/apps/" + m.getAnnotation(Web.class).value(), new UrlHandler(m));
                }
            }
            System.out.println(hm.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * realiza la solicitud pedida en el broser dependiendo del tio solicitado
     * @param inputLine corresponde a la direccion de entrada
     * @param headr encabezado de la pagina
     * @param i corresponde al indice en la url donde se empieza a pedir el recurso
     * @param clientSocket socket del cliente
     * @param br solicitud del browser
     * @throws IOException
     */
    private static void getRequest(String inputLine,String headr,Socket clientSocket, Browser br) throws IOException{
        int index = inputLine.indexOf("/apps/");
                String resource = "", urlInputLine ="";
                int i = -1;
                if (index != -1){
                    for (i = index; i < inputLine.length() && inputLine.charAt(i) != ' '; i++) {
                        resource += inputLine.charAt(i);
                    }
                }else{
                    i = inputLine.indexOf('/') + 1;
                }
                if (inputLine.contains("/apps/")) {
                   br.readApp(resource, headr);
                } else if (inputLine.contains(".html")) {
                   br.readHtml(inputLine, headr, i);
                } else if (inputLine.contains(".png")) {
                    br.readPng(inputLine, headr, i, clientSocket);
                }
    }
}
