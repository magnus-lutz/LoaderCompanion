package de.magnus.serviceloader;

import com.google.auto.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(Injectable.class)
public class Test3Service implements Injectable {
    private static final Logger log = LoggerFactory.getLogger(Test3Service.class);

    @Override
    public void setup(ClassBasedInjectableLoader loader) {
        log.debug("hey");
    }
}
