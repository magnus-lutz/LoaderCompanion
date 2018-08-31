package de.magnus.serviceloader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class ClassBasedInjectableLoader {
    private static final Logger log = LoggerFactory.getLogger(ClassBasedInjectableLoader.class);

    private Map<Class<? extends Injectable>, Injectable> serviceMap = new HashMap<>();

    private ClassBasedInjectableLoader init(){
        log.debug("initializing");
        ServiceLoader<Injectable> loader = ServiceLoader.load(Injectable.class);
        Iterator<Injectable> providers = loader.iterator();
        while (providers.hasNext()) {
            Injectable provider = providers.next();
            log.debug("found provider "+provider.getClass().getSimpleName());
            serviceMap.put(provider.getClass(),provider);
        }

        for(Injectable service : serviceMap.values()){
            log.debug("setting up "+service.getClass().getSimpleName());
            service.setup(this);
        }
        return this;
    }



    private static final class InstanceHolder {
        static final ClassBasedInjectableLoader INSTANCE = new ClassBasedInjectableLoader().init();
    }

    private ClassBasedInjectableLoader() {}
    public static ClassBasedInjectableLoader getInstance () {
        return InstanceHolder.INSTANCE;
    }

    public <T extends Injectable> T load(Class<T> clazz){
        for(Injectable service : serviceMap.values()){
            if(clazz.isAssignableFrom(service.getClass())){
                return (T)service;
            }
        }
        return null;
    }

    public <T extends Injectable> Collection<T> loadAll(){

        Collection<T> collection = new ArrayList<>();
        for(Injectable service : serviceMap.values()){
            collection.add((T)service);
        }

        return collection;
    }

}
