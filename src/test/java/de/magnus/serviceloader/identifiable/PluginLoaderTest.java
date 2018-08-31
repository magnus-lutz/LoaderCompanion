package de.magnus.serviceloader.identifiable;

import de.magnus.serviceloader.Identifiable;
import de.magnus.serviceloader.loaders.StringBasedLoader;
import de.magnus.serviceloader.loaders.UniqueLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginLoaderTest {

    private static final Logger log = LoggerFactory.getLogger(PluginLoaderTest.class);

    void run(){
        StringBasedLoader loader = new StringBasedLoader();
        Identifiable identifiable = loader.loadById("a");
        log.debug("loaded plugin of type {}",identifiable.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        new PluginLoaderTest().run();
    }

}
