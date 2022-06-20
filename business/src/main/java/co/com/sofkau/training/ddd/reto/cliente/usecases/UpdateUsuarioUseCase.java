package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.cliente.Cliente;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateUsuarioCommand;

public class UpdateUsuarioUseCase extends UseCase<RequestCommand<UpdateUsuarioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateUsuarioCommand> input) {
        var command = input.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.updateUsuario(command.getUsuarioId(), command.getNombre(), command.getDocumentoIdentidad(),
                command.getActivo());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
