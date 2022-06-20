package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.CreatePuestoTrabajoCommand;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.CreatedPuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePuestoTrabajoUseCaseTest {
    @Test
    void createPuestoTrabajo(){
        //arrange
        NumeroBanco numeroBanco = new NumeroBanco("Banco 2");
        Sector sector = new Sector("Zona Norte");
        var command = new CreatePuestoTrabajoCommand(new BancoTrabajoId(), numeroBanco, sector);
        var usecase = new CreatePuestoTrabajoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        CreatedPuestoTrabajo event = (CreatedPuestoTrabajo) events.get(0);
        Assertions.assertEquals("Banco 2", event.getNumeroBanco().value());
        Assertions.assertEquals("Zona Norte", event.getSector().value());
    }

}