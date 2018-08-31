package de.magnus.serviceloader.identifiable;

import com.google.auto.service.AutoService;
import de.magnus.serviceloader.Identifiable;

@AutoService(Identifiable.class)
public class PluginA implements Identifiable {
    @Override
    public String getIdentifier() {
        return "b";
    }
}
