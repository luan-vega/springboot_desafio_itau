package desafio.itau.springboot.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void testTransaction() {
        // Arrange
        double valor = 100.0;
        OffsetDateTime dataHora = OffsetDateTime.now();

        // Act
        Transaction transaction = new Transaction(valor, dataHora);

        // Assert
        assertEquals(valor, transaction.getValor());
        assertEquals(dataHora, transaction.getDataHora());
    }

    @Test
    void testTransactionWithNegativeValue() {
        // Arrange
        double valor = -50.0;
        OffsetDateTime dataHora = OffsetDateTime.now();

        // Act
        Transaction transaction = new Transaction(valor, dataHora);

        // Assert
        assertEquals(valor, transaction.getValor());
        assertEquals(dataHora, transaction.getDataHora());
    }

    @Test
    void testTransactionWithZeroValue() {
        // Arrange
        double valor = 0.0;
        OffsetDateTime dataHora = OffsetDateTime.now();

        // Act
        Transaction transaction = new Transaction(valor, dataHora);

        // Assert
        assertEquals(valor, transaction.getValor());
        assertEquals(dataHora, transaction.getDataHora());
    }

}
