package de.magnus.serviceloader.loaders;

import de.magnus.serviceloader.Injectable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectableLoader extends ClassBasedLoader<Injectable> {

    private static final Logger log = LoggerFactory.getLogger(InjectableLoader.class);

    public InjectableLoader() {
        super(Injectable.class);
        for(Injectable service : loadAll()){
            log.debug("setting up "+service.getClass().getSimpleName());
            service.setup(this);
        }
        log.debug("all services have been set up");
    }
}
