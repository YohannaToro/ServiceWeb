package edu.escuelaing.arem.project.app.model;

/**
 *
 * @author YohannaToro
 */
public interface Handlers{

    /**
     *invoca un metodo que tiene una etiqueta
     * @return una cadena con la respuesta del metodo invocado
     */
    public String process();

    /**
     *invoca un metodo que tiene una etiqueta
     * @param arg parametros pasados 
     * @return una cadena con la respuesta del metodo invocado
     * @throws Exception
     */
    public  String process(Object[] arg)  throws Exception;
}
