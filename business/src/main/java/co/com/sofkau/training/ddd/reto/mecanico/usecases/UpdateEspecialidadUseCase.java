package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.mecanico.Mecanico;
import co.com.sofkau.training.ddd.reto.mecanico.commands.ChangeEspecialidadCommand;

public class UpdateEspecialidadUseCase extends UseCase<RequestCommand<ChangeEspecialidadCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeEspecialidadCommand> input) {
        var command = input.getCommand();
        var mecanico = Mecanico.from(command.getMecanicoId(),
                repository().getEventsBy(command.getMecanicoId().value()));

        mecanico.changeEspecialidad(command.getEspecialidad());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
