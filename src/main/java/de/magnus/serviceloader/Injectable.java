package de.magnus.serviceloader;

import de.magnus.serviceloader.loaders.InjectableLoader;

public interface Injectable {

    void setup(InjectableLoader loader);

}
