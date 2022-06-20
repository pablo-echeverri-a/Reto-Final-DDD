package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.training.ddd.reto.factura.commands.CreateFacturaCommand;
import co.com.sofkau.training.ddd.reto.factura.events.CreatedFactura;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateFacturaUseCaseTest {
    @Test
    void CreateFactura(){
        //arrange
        Horas horas = new Horas(3);
        Costo costo = new Costo(100000);
        var command = new CreateFacturaCommand(new FacturaId(), horas, costo);
        var usecase = new CreateFacturaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedFactura) events.get(0);
        Assertions.assertEquals(3, event.getHoras().value());
        Assertions.assertEquals(100000, event.getCosto().value());
    }
}