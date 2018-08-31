package de.magnus.serviceloader.loaders;


import de.magnus.serviceloader.Identifiable;

public class StringBasedLoader extends UniqueLoader<String, Identifiable>{
    public StringBasedLoader() {
        super(Identifiable.class, Identifiable::getIdentifier);
    }
}
