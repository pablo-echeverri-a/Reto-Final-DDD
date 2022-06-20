package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.factura.Factura;
import co.com.sofkau.training.ddd.reto.factura.commands.UpdateManoObraCommand;
import co.com.sofkau.training.ddd.reto.mecanico.commands.ChangeEspecialidadCommand;

public class UpdateEspecialidadUseCase extends UseCase<RequestCommand<ChangeEspecialidadCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeEspecialidadCommand> input) {
        var command = input.getCommand();
        var factura = Factura.from(command.getFacturaId(),
                repository().getEventsBy(command.getFacturaId().value()));

        factura.changeEspecialidad(command.getEspecialidad());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
