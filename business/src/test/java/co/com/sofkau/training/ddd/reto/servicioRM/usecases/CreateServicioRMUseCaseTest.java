package co.com.sofkau.training.ddd.reto.servicioRM.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.servicioRM.commands.CreateServicioRMCommand;
import co.com.sofkau.training.ddd.reto.servicioRM.events.CreatedServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateServicioRMUseCaseTest {
    @Test
    void createServicioRM(){
        //arrange
        NombreServicio nombreServicio = new NombreServicio("Cambio Amortiguadores");
        var command = new CreateServicioRMCommand(new FacturaId(), new PuestoTrabajoId(),
                new MecanicoId(), nombreServicio);
        var usecase = new CreateServicioRMUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        CreatedServicioRM event = (CreatedServicioRM) events.get(0);
        Assertions.assertEquals("Cambio Amortiguadores", event.getNombreServicio().value());
    }
}