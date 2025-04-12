package desafio.itau.springboot.controller;

import desafio.itau.springboot.repository.StatistcsResponse;
import desafio.itau.springboot.service.TransactionService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatistcsController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    public final TransactionService transactionService;

    public StatistcsController (TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatistcsResponse> getStatistcs() {
        DoubleSummaryStatistics statistics = transactionService.getStatistcs();
        log.info("Statistics returned with success");
        return ResponseEntity.ok(new StatistcsResponse(statistics));
    }

}
