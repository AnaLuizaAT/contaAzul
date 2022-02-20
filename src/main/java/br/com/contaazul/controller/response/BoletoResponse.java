package br.com.contaazul.controller.response;

import br.com.contaazul.enums.BoletoEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class BoletoResponse {

    private BoletoEnum status;
    private LocalDate due_date;
    private LocalDate payment_date;
    private String customer;
    private BigDecimal total_in_cents;
}