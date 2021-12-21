package com.example.backend.domain.credit;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для рассчета кредитов.
 */
@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {
    CreditCalculatorService creditService;

    @Autowired
    public CreditController(CreditCalculatorService creditService) {
        this.creditService = creditService;
    }

    @Operation(summary = "Calculate credit payment")
    @PostMapping("/calculate")
    AnnuityPayment calculate(@RequestBody CalculateRequest request) {
        return creditService.calculate(request);
    }
}
