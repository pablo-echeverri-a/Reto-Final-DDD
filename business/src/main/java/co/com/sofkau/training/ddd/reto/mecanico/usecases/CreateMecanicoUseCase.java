package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.mecanico.Mecanico;
import co.com.sofkau.training.ddd.reto.mecanico.commands.CreateMecanicoCommand;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;

public class CreateMecanicoUseCase extends UseCase<RequestCommand<CreateMecanicoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMecanicoCommand> input) {
        var command = input.getCommand();
        var mecanico = new Mecanico(new MecanicoId(), new EmpleadoId(), command.getNombrePersona(), command.getDocumentoIdentidad(),
                command.getActivo(), command.getCodigo());
        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
