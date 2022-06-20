package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.cliente.Cliente;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateUsuarioCommand;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateVehiculoCommand;

public class UpdateVehiculoUseCase extends UseCase<RequestCommand<UpdateVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateVehiculoCommand> input) {
        var command = input.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.updateVehiculo(command.getVehiculoId(), command.getTipoVehiculo(), command.getMarca(),
                command.getLinea(), command.getModelo(), command.getPlaca());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
