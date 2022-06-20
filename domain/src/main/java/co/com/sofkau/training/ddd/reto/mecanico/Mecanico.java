package co.com.sofkau.training.ddd.reto.mecanico;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.mecanico.entities.Empleado;
import co.com.sofkau.training.ddd.reto.mecanico.events.ChangedEspecialidad;
import co.com.sofkau.training.ddd.reto.mecanico.events.CreatedMecanico;
import co.com.sofkau.training.ddd.reto.mecanico.events.UpdatedEmpleado;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

import java.util.List;

public class Mecanico extends AggregateEvent<MecanicoId> {
    protected Empleado empleado;
    protected Especialidad especialidad;

    public Mecanico(MecanicoId id, EmpleadoId empleadoId, NombrePersona nombre, DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo) {
        super(id);
        subscribe(new MecanicoChange(this));
        appendChange(new CreatedMecanico(empleadoId, nombre, documentoIdentidad, activo, codigo)).apply();
    }

    public Mecanico(MecanicoId entityId) {
        super(entityId);
        subscribe(new MecanicoChange(this));
    }

    public static Mecanico from(MecanicoId id, List<DomainEvent> events) {
        var mecanico = new Mecanico(id);
        events.forEach(mecanico::applyEvent);
        return mecanico;
    }

    public void updateEmpleado(EmpleadoId empleadoId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo){
        appendChange(new UpdatedEmpleado(empleadoId, nombrePersona, documentoIdentidad, activo, codigo)).apply();
    }

    public void changeEspecialidad(Especialidad especialidad){
        appendChange(new ChangedEspecialidad(especialidad)).apply();
    }
}
