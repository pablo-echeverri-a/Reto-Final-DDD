package co.com.sofkau.training.ddd.reto.servicioRM.events;

import co.com.sofka.domain.generic.DomainEvent;

public class UpdatedNombreServicio extends DomainEvent {
    private final String nombreServicio;

    public UpdatedNombreServicio(String nombreServicio){
        super("co.com.sofkau.training.ddd.reto.servicioRM.events.UpdatedNombreServicio");

        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }
}
