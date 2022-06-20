package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.cliente.Cliente;
import co.com.sofkau.training.ddd.reto.cliente.commands.CreateClienteCommand;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;

public class CreateClienteUseCase  extends UseCase<RequestCommand<CreateClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateClienteCommand> input) {
        var command = input.getCommand();
        var cliente = new Cliente(new ClienteId(), new UsuarioId(), command.getNombre(), command.getDocumentoIdentidad(), command.getActivo());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
