package edu.escuelaing.arem.project.app;

import edu.escuelaing.arem.project.app.model.Handlers;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author 2132219
 */
public class Browser {
    private BufferedReader bf;
    private PrintWriter out;
    private HashMap<String, Handlers> hm= new HashMap<String, Handlers>();
    private int i;

    /**
     * Constructor de la clase browser
     * @param bf
     * @param out
     * @param hm metodos que poseen anotaciones POJOs
     */
    public Browser(BufferedReader bf,PrintWriter out,HashMap<String, Handlers> hm) {
        this.bf=bf;
        this.out=out;
        this.hm=hm;
    }

    /**
     * identifica que tipo de solicitud fue pedida al servidor, para taer el metodo con la anotacion correspondiente escrita en la direccion de la pagina
     * @param resource recurso solicitado en la url
     * @param headr encabezado de la pagina
     */
    public void readApp(String resource,String headr){
        try {
                        out.println(headr);
                        if(resource.contains(":")) {
                            int id = resource.indexOf(":");
                            out.println(hm.get(resource.substring(0, id)).process(new Object[]{resource.substring(id+1)}));
                        }else {
                        out.println(hm.get(resource).process());
                        }
                    } catch (Exception e) {
                    }
    }

    /**
     *publica en el servidor una pagina web html buscando el recurso .html de la url solicitad
     * posteandolo en el servidor en forma de pagina web
     * @param inputLine corresponde a la direccion de entrada
     * @param headre ncabezado de la pagina
     * @param i corresponde al indice en la url donde se empieza a pedir el recurso
     * @throws IOException
     */
    public void readHtml(String inputLine,String headr,int i) throws IOException{
        String urlInputLine="";
        while (!urlInputLine.endsWith(".html") && i < inputLine.length()) {
                        urlInputLine += (inputLine.charAt(i++));
                    }
                    String urlDirectoryServer = System.getProperty("user.dir") + "/recursos/" + urlInputLine;
        try {
                        BufferedReader readerFile = new BufferedReader(new FileReader(urlDirectoryServer));
                        out.println(headr);
                        while (readerFile.ready()) {
                            out.println(readerFile.readLine());
                        }
                    } catch (FileNotFoundException e) {
                     
                        System.out.println(e.getMessage());
                    }
    
    }

    /**
     * publica en el servidor la imagen buscando el recurso .png de la solicitud
     * @param inputLine corresponde a la direccion de entrada
     * @param headr encabezado de la pagina
     * @param i corresponde al indice en la url donde se empieza a pedir el recurso
     * @param clientSocket socket del cliente
     * @throws IOException
     */
    public void readPng(String inputLine,String headr,int i,Socket clientSocket) throws IOException{
       String urlInputLine="";
    while (!urlInputLine.endsWith(".png") && i < inputLine.length()) {
                        urlInputLine += (inputLine.charAt(i++));
                    }
                    BufferedImage github = ImageIO.read(new File(System.getProperty("user.dir") + "/recursos/" + urlInputLine));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(github, "png", baos);
                    byte [] imageBy = baos.toByteArray();
                    DataOutputStream outImg = new DataOutputStream(clientSocket.getOutputStream());
                    outImg.writeBytes("HTTP/1.1 200 OK \r\n");
                    outImg.writeBytes("Content-Type: image/png\r\n");
                    outImg.writeBytes("Content-Length: " + imageBy.length);
                    outImg.writeBytes("\r\n\r\n");
                    outImg.write(imageBy);
					outImg.close();
                    out.println(outImg.toString());
    }
    public void notFound(Socket clientSocket) throws IOException{
      
                   BufferedImage github = ImageIO.read(new File(System.getProperty("user.dir") + "/recursos/not-found.png" ));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(github, "png", baos);
                    byte [] imageBy = baos.toByteArray();
                    DataOutputStream outImg = new DataOutputStream(clientSocket.getOutputStream());
                    outImg.writeBytes("HTTP/1.1 200 OK \r\n");
                    outImg.writeBytes("Content-Type: image/png\r\n");
                    outImg.writeBytes("Content-Length: " + imageBy.length);
                    outImg.writeBytes("\r\n\r\n");
                    outImg.write(imageBy);
					outImg.close();
                    out.println(outImg.toString());
    }
}