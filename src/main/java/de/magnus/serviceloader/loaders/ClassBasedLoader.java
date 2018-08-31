package de.magnus.serviceloader.loaders;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassBasedLoader<T> extends UniqueLoader<Class<T>,T> {
    private static final Logger log = LoggerFactory.getLogger(ClassBasedLoader.class);


    public ClassBasedLoader(Class<T> clazz){
        super(clazz,t -> (Class<T>)t.getClass());
    //    log.debug("initializing");

    }


    public <C> C load(Class<C> clazz){
        for(T service : getAll().values()){
            if(clazz.isAssignableFrom(service.getClass())){
                return (C)service;
            }
        }
        return null;
    }

    public <C> C loadExactly(Class<C> clazz){
        for(T service : getAll().values()){
            if(clazz.equals(service.getClass())){
                return (C)service;
            }
        }
        return null;
    }


}
