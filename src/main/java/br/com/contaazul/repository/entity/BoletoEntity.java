package br.com.contaazul.repository.entity;

import br.com.contaazul.enums.BoletoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOLETO")
public class BoletoEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(precision = 11, scale = 0)
    private BigDecimal total_in_cents;

    private String customer;
    private BigDecimal juros;
    private BoletoEnum status;
    private LocalDate due_date;
    private LocalDate actual_date;
    private LocalDate payment_date;
}