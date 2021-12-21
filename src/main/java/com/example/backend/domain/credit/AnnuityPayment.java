package com.example.backend.domain.credit;

import lombok.Builder;
import lombok.Data;

/**
 * Сущность аннуитетного платежа по кредиту.
 */
@Data
@Builder
public class AnnuityPayment {
    /**
     * Размер кредита.
     */
    double loanAmount;
    /**
     * Ежемесячный платеж.
     */
    double monthPayment;
    /**
     * Размер полной выплаты по кредиту.
     */
    double fullPayment;
    /**
     * Переплата по кредиту.
     */
    double overpayment;
    /**
     * Срок кредита.
     */
    int creditTerm;
    /**
     * Размер процентой ставки.
     */
    double rate;
}
