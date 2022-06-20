package co.com.sofkau.training.ddd.reto.servicioRM.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.servicioRM.ServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.commands.UpdateNombreServicioCommand;

public class UpdateNombreServicioUseCase extends UseCase<RequestCommand<UpdateNombreServicioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateNombreServicioCommand> input) {
        var command = input.getCommand();
        var servicioRM = ServicioRM.from(command.getServicioRMId(),
                repository().getEventsBy(command.getServicioRMId().value()));

        servicioRM.updateNombreServicio(command.getNombreServicio());

        emit().onResponse(new ResponseEvents(servicioRM.getUncommittedChanges()));
    }
}
