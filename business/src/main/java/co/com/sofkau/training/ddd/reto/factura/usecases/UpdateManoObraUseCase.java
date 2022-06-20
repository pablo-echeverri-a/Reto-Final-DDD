package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.factura.Factura;
import co.com.sofkau.training.ddd.reto.factura.commands.UpdateManoObraCommand;

public class UpdateManoObraUseCase extends UseCase<RequestCommand<UpdateManoObraCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateManoObraCommand> input) {
        var command = input.getCommand();
        var factura = Factura.from(command.getFacturaId(),
                repository().getEventsBy(command.getFacturaId().value()));

        factura.updateManoObra(command.getManoObraId(), command.getHoras(), command.getCosto());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
