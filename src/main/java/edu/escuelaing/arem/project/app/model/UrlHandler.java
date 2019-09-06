package edu.escuelaing.arem.project.app.model;

import java.lang.reflect.Method;

public class UrlHandler implements Handlers{
    private Method method;

    public UrlHandler(Method m){
        this.method=m;

    }

    public String process() {
        try{
            return (String) method.invoke(null, null);
        }catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
   
    }

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