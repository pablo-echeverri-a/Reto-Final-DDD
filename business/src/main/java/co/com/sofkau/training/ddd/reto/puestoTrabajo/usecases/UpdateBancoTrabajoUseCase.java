package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.PuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.UpdateBancoTrabajoCommand;

public class UpdateBancoTrabajoUseCase extends UseCase<RequestCommand<UpdateBancoTrabajoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateBancoTrabajoCommand> input) {
        var command = input.getCommand();
        var puestoTrabajo = PuestoTrabajo.from(command.getPuestoTrabajoId(),
                repository().getEventsBy(command.getBancoTrabajoId().value()));

        puestoTrabajo.updateBancoTrabajo(command.getBancoTrabajoId(), command.getNumeroBanco(), command.getSector());

        emit().onResponse(new ResponseEvents(puestoTrabajo.getUncommittedChanges()));
    }
}
