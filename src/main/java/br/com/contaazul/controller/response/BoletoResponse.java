package br.com.contaazul.controller.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class BoletoResponse {

    private Enum status;
    private Date due_date;
    private String customer;
    private BigDecimal total_in_cents;
}