package de.magnus.serviceloader.injectable;

import com.google.auto.service.AutoService;
import de.magnus.serviceloader.Injectable;
import de.magnus.serviceloader.loaders.InjectableLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(Injectable.class)
public class Test1Service implements Test1API{
    private static final Logger log = LoggerFactory.getLogger(Test1Service.class);

    private Test2API test2Service;

    @Override
    public void setup(InjectableLoader loader) {
        test2Service = loader.load(Test2API.class);
    }

    @Override
    public void test1Feature() {
        log.debug("test1Feature");
    }

    @Override
    public void run() {
        test1Feature();
        test2Service.test2Feature();
    }
}
