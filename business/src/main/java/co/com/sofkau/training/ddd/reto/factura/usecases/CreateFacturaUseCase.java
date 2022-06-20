package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.training.ddd.reto.factura.Factura;
import co.com.sofkau.training.ddd.reto.factura.commands.CreateFacturaCommand;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;

public class CreateFacturaUseCase extends UseCase<RequestCommand<CreateFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateFacturaCommand> input) {
        var command = input.getCommand();
        var factura = new Factura(new FacturaId(), new ManoObraId(), command.getHoras(), command.getCosto());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
