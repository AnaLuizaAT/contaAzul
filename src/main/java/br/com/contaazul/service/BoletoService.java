package br.com.contaazul.service;

import br.com.contaazul.controller.request.BoletoRequest;
import br.com.contaazul.repository.entity.BoletoEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface BoletoService {
    void cadastrar(BoletoRequest boletoRequest);

    Iterable<BoletoEntity> retornarBoletos();

    void pagar(UUID id, LocalDate payment_date);

    void cancelar(UUID id);

    BigDecimal juros(UUID uuid, LocalDate due_date, LocalDate payment_date, BigDecimal total_in_cents);
}
