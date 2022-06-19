package co.com.sofkau.training.ddd.reto.values;

import co.com.sofka.domain.generic.ValueObject;

public class DocumentoIdentidad implements ValueObject<String> {
    private final String tipo;
    private final String digitos;

    public DocumentoIdentidad(String tipo, String digitos) {
        this.tipo = tipo;
        this.digitos = digitos;
    }

    @Override
    public String value() {
        return tipo + " " + digitos;
    }
}
