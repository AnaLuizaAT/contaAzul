package br.com.contaazul.controller.request;

import br.com.contaazul.enums.BoletoEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BoletoRequest {

    private BoletoEnum status;
    private Date due_date;
    private String customer;
    private BigDecimal total_in_cents;
}
