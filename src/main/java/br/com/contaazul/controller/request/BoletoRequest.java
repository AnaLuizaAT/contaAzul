package br.com.contaazul.controller.request;

import br.com.contaazul.enums.BoletoEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BoletoRequest {

    private String customer;

    private BigDecimal juros;
    private BigDecimal total_in_cents;

    private BoletoEnum status;

    private LocalDate due_date;
    private LocalDate actual_date;
    private LocalDate payment_date;
}
