package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.training.ddd.reto.mecanico.commands.CreateMecanicoCommand;
import co.com.sofkau.training.ddd.reto.mecanico.events.CreatedMecanico;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateMecanicoUseCaseTest {
    @Test
    void createMecanico(){
        //arrange
        NombrePersona nombrePersona = new NombrePersona("Pablo", "Echeverri");
        DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad("CC","1111111");
        Activo activo = new Activo(true);
        Codigo codigo = new Codigo("1234");
        var command = new CreateMecanicoCommand(new MecanicoId(), nombrePersona, documentoIdentidad, activo, codigo);
        var usecase = new CreateMecanicoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        CreatedMecanico event = (CreatedMecanico) events.get(0);
        Assertions.assertEquals("Pablo Echeverri", event.getNombre().value());
        Assertions.assertEquals("CC 1111111", event.getDocumentoIdentidad().value());
        Assertions.assertEquals(true, event.getActivo().value());
        Assertions.assertEquals("1234", event.getCodigo().value());
    }

}