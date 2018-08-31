package de.magnus.serviceloader.injectable;

import de.magnus.serviceloader.Injectable;
import de.magnus.serviceloader.loaders.InjectableLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonServiceLoaderTest {

    private static final Logger log = LoggerFactory.getLogger(SingletonServiceLoaderTest.class);

    public static void main(String[] args) {
        InjectableLoader loader = new InjectableLoader();


        for(Injectable service : loader.loadAll()){
            log.debug("iterating through service");
            if(service instanceof RunnableInjectable){
                RunnableInjectable rs = (RunnableInjectable)service;
                rs.run();
            }
        }

    }

}
