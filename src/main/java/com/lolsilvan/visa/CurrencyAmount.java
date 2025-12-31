package com.lolsilvan.visa;

import java.math.BigDecimal;

public record CurrencyAmount(BigDecimal amount, String currency) {
}
