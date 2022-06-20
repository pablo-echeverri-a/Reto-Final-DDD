package co.com.sofkau.training.ddd.reto.mecanico;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.mecanico.entities.Empleado;
import co.com.sofkau.training.ddd.reto.mecanico.events.ChangedEspecialidad;
import co.com.sofkau.training.ddd.reto.mecanico.events.CreatedMecanico;
import co.com.sofkau.training.ddd.reto.mecanico.events.UpdatedEmpleado;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;

public class MecanicoChange extends EventChange {
    public MecanicoChange(Mecanico mecanico){
        apply((CreatedMecanico event) -> {
            mecanico.especialidad = new Especialidad(Especialidad.Especialidades.GENERAL);;
            mecanico.empleado = new Empleado(event.getEmpleadoId(), event.getNombre(), event.
                    getDocumentoIdentidad(), event.getActivo(), event.getCodigo());
        });

        apply((UpdatedEmpleado event)->{
            mecanico.empleado = new Empleado(new EmpleadoId());
            var empleadoId = event.getEmpleadoId();
            var empleado = new Empleado(empleadoId, event.getNombrePersona(), event.getDocumentoIdentidad(),
                    event.getActivo(), event.getCodigo());

            mecanico.empleado.actualizarEmpleado(empleado);
        });

        apply((ChangedEspecialidad event) -> {
            mecanico.especialidad = new Especialidad(event.getEspecialidad().value());
        });

    }
}
