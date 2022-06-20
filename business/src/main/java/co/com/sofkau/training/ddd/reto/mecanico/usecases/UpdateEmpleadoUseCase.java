package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.cliente.Cliente;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateUsuarioCommand;
import co.com.sofkau.training.ddd.reto.mecanico.Mecanico;
import co.com.sofkau.training.ddd.reto.mecanico.commands.UpdateEmpleadoCommand;

public class UpdateEmpleadoUseCase extends UseCase<RequestCommand<UpdateEmpleadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateEmpleadoCommand> input) {
        var command = input.getCommand();
        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.updateEmpleado(command.getEmpleadoId(), command.getNombre(), command.getDocumentoIdentidad(),
                command.getActivo(), command.getCodigo());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
