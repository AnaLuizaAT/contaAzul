package br.com.contaazul.repository.entity;

import br.com.contaazul.enums.BoletoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOLETO")
public class BoletoEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private Date due_date;
    private String customer;
    private BoletoEnum status;
    private BigDecimal total_in_cents;
}
