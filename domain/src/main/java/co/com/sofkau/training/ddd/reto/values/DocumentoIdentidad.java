package co.com.sofkau.training.ddd.reto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DocumentoIdentidad implements ValueObject<String> {
    private final String tipo;
    private final String digitos;

    public DocumentoIdentidad(String tipo, String digitos) {
        this.tipo = Objects.requireNonNull(tipo);
        this.digitos = Objects.requireNonNull(digitos);
    }

    public static DocumentoIdentidad of(String tipo, String digitos){
        return new DocumentoIdentidad(tipo, digitos);
    }

    @Override
    public String value() {
        return tipo + " " + digitos;
    }
}
