package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.factura.Factura;
import co.com.sofkau.training.ddd.reto.factura.commands.CreateRepuestoCommand;

public class CreateRepuestoUseCase extends UseCase<RequestCommand<CreateRepuestoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRepuestoCommand> input) {
        var command = input.getCommand();
        var factura = Factura.from(command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value()));

        factura.addRepuesto(command.getRepuestoFactory());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
