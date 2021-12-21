package com.example.backend.domain.credit;

import lombok.Data;

/**
 * Запрос на подсчет кредита.
 */
@Data
public class CalculateRequest {
    double loanAmount;
    int creditTerm;
}
