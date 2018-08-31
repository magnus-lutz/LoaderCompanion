package de.magnus.serviceloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonServiceLoaderTest {

    private static final Logger log = LoggerFactory.getLogger(SingletonServiceLoaderTest.class);

    public static void main(String[] args) {
        ClassBasedInjectableLoader loader = ClassBasedInjectableLoader.getInstance();


        for(Injectable service : loader.loadAll()){
            log.debug("iterating through service");
            if(service instanceof RunnableService){
                RunnableService rs = (RunnableService)service;
                rs.run();
            }
        }

    }

}
