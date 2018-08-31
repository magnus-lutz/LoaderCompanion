package de.magnus.serviceloader;

import com.google.auto.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(Injectable.class)
public class Test2Service implements Test2API{
    private static final Logger log = LoggerFactory.getLogger(Test2Service.class);

    private Test1API test1Service;

    @Override
    public void setup(ClassBasedInjectableLoader loader) {
        test1Service = loader.load(Test1API.class);
    }

    @Override
    public void test2Feature() {
        log.debug("test2Feature");
    }

    @Override
    public void run() {
        test2Feature();
        test1Service.test1Feature();
    }
}
