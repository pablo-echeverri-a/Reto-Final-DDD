package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.PuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.CreateHerramientaCommand;

public class CreateHerramientaUseCase extends UseCase<RequestCommand<CreateHerramientaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateHerramientaCommand> input) {
        var command = input.getCommand();
        var puestoTrabajo = PuestoTrabajo.from(command.getPuestoTrabajoId(), repository().getEventsBy(command.getPuestoTrabajoId().value()));

        puestoTrabajo.addHerramienta(command.getHerramientaFactory());

        emit().onResponse(new ResponseEvents(puestoTrabajo.getUncommittedChanges()));
    }
}
