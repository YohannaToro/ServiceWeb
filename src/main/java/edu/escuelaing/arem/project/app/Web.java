package edu.escuelaing.arem.project.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 *
 * @author YohannaToro
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Web {

    /**
     * retorna el valor de los metodos que han sido etiquetados
     * @return
     */
    String value();
}