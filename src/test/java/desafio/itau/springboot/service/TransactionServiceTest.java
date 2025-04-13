package desafio.itau.springboot.service;

import desafio.itau.springboot.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionServiceTest {

    @Test
    void testAddTransaction() {
        OffsetDateTime now = OffsetDateTime.now();
        Transaction transaction = new Transaction(100.0, now);

        assertEquals(100.0, transaction.getValor());
        assertEquals(now, transaction.getDataHora());
    }

    @Test
    void testGetStatistcs() {
        TransactionService transactionService = new TransactionService();
        OffsetDateTime now = OffsetDateTime.now();

        transactionService.addTransaction(new Transaction(100.0, now));
        transactionService.addTransaction(new Transaction(200.0, now.minusSeconds(30)));
        transactionService.addTransaction(new Transaction(300.0, now.minusSeconds(70)));

        var statistics = transactionService.getStatistcs();

        assertEquals(2, statistics.getCount());
        assertEquals(150.0, statistics.getAverage());
        assertEquals(300.00, statistics.getSum());
    }

    @Test
    void testClearTransactions() {
        TransactionService transactionService = new TransactionService();

        transactionService.addTransaction(new Transaction(100.0, OffsetDateTime.now()));
        transactionService.clearTransactions();

        var statistics = transactionService.getStatistcs();

        assertEquals(0, statistics.getCount());
    }

    @Test
    void testInvalidTransaction() {
        TransactionService transactionService = new TransactionService();
        OffsetDateTime now = OffsetDateTime.now();

        Transaction invalidTransaction = new Transaction(100.0, now.plusSeconds(-100));
        transactionService.addTransaction(invalidTransaction);
        var statistics = transactionService.getStatistcs();

        assertEquals(0, statistics.getCount());
    }

}
