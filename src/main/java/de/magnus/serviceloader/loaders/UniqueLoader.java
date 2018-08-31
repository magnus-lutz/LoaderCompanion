package de.magnus.serviceloader.loaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Function;

public class UniqueLoader<ID,T> {

    private static final Logger log = LoggerFactory.getLogger(UniqueLoader.class);

    private final Map<ID, T> services = new HashMap<>();

    private final Function<T,ID> mapper;

    public UniqueLoader(Class<T> clazz, Function<T,ID> mapper){
        log.debug("initializing {}",getClass().getSimpleName());
        this.mapper = mapper;
        ServiceLoader<T> loader = ServiceLoader.load(clazz);
        Iterator<T> providers = loader.iterator();
        while (providers.hasNext()) {
            T provider = providers.next();
            log.debug("found provider "+provider.getClass().getSimpleName());
            put(provider);
        }
    }

    protected void put(T object){
        services.put(mapper.apply(object),object);
    }

    protected Map<ID,T> getAll(){
        return new HashMap<>(services);
    }

    public T loadById(ID id){
        return services.get(id);
    }

    public Collection<T> loadAll(){
        return services.values();
    }

}
