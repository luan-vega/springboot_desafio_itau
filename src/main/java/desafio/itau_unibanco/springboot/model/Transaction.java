package desafio.itau_unibanco.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {
    protected double valor;
    protected OffsetDateTime dataHora;

    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}

