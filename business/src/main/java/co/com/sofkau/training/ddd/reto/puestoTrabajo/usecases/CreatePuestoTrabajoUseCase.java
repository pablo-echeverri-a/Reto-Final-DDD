package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.PuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.CreatePuestoTrabajoCommand;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;

public class CreatePuestoTrabajoUseCase extends UseCase<RequestCommand<CreatePuestoTrabajoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePuestoTrabajoCommand> input) {
        var command = input.getCommand();
        var puestoTrabajo = new PuestoTrabajo(new PuestoTrabajoId(), new BancoTrabajoId(), command.getNumeroBanco(), command.getSector());
        emit().onResponse(new ResponseEvents(puestoTrabajo.getUncommittedChanges()));
    }
}
