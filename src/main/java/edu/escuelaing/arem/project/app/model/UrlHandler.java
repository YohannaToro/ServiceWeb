package edu.escuelaing.arem.project.app.model;

import java.lang.reflect.Method;

/**
 *
 * @author YohannaToro
 */
public class UrlHandler implements Handlers{
    private Method method;

    /**
     *
     * @param m
     */
    public UrlHandler(Method m){
        this.method=m;

    }

    /**
     *
     * @return cadena de un metodo invoacado
     */
    public String process() {
        try{
            return (String) method.invoke(null, null);
        }catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
   
    }

    /**
     *
     * @param arg array de objetos 
     * @return cadena de la invocacion de un metodo
     * @throws Exception
     */
    @Override
    public String process(Object[] arg) throws Exception {
        try{
            return (String) method.invoke(method, arg);
        }catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
        // TODO Auto-generated method stub
        
    }

}