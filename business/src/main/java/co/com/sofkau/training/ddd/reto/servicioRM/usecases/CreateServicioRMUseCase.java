package co.com.sofkau.training.ddd.reto.servicioRM.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.servicioRM.ServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.commands.CreateServicioRMCommand;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;

public class CreateServicioRMUseCase extends UseCase<RequestCommand<CreateServicioRMCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateServicioRMCommand> input) {
        var command = input.getCommand();
        var servicioRM = new ServicioRM(new ServicioRMId(), command.getFacturaId(), command.getPuestoTrabajoId(),
                command.getMecanicoId(), command.getNombreServicio());
        emit().onResponse(new ResponseEvents(servicioRM.getUncommittedChanges()));
    }
}
