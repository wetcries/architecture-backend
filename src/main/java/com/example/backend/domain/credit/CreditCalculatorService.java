package com.example.backend.domain.credit;

import org.springframework.stereotype.Service;

/**
 * Сервис, предоставляющий функциональность по подсчету кредитов.
 */
@Service
public class CreditCalculatorService {

    public AnnuityPayment calculate(CalculateRequest request) {
        double rate = 0.07;
        int creditTerm = request.creditTerm;
        double loanAmount = request.loanAmount;
        double monthPayment = annuityPayment(loanAmount, creditTerm, rate);
        double fullPayment = monthPayment * creditTerm;
        double overpayment = fullPayment - loanAmount;
        return AnnuityPayment.builder()
                .monthPayment(monthPayment)
                .creditTerm(creditTerm)
                .loanAmount(loanAmount)
                .rate(rate)
                .fullPayment(fullPayment)
                .overpayment(overpayment)
                .build();
    }

    /**
     * Подсчет аннуитетного платежа по кредиту
     * @param loanAmount Запрашиваемая сумма займа
     * @param creditTerm Срок кредита в месяцах
     * @param rate Процентная ставка (указвыается в долях: 0.07)
     * @return Месячный платеж
     */
    private double annuityPayment(double loanAmount, int creditTerm, double rate) {
        rate = rate / 12;
        return loanAmount * rate * Math.pow(1 + rate, creditTerm) /
                (Math.pow(1 + rate, creditTerm) - 1);
    }
}
