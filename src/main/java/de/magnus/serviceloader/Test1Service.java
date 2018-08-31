package de.magnus.serviceloader;

import com.google.auto.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(Injectable.class)
public class Test1Service implements Test1API{
    private static final Logger log = LoggerFactory.getLogger(Test1Service.class);

    private Test2API test2Service;

    @Override
    public void setup(ClassBasedInjectableLoader loader) {
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
