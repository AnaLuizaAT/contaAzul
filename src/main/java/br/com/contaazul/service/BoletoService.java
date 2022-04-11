package br.com.contaazul.service;

import br.com.contaazul.controller.request.BoletoRequest;
import br.com.contaazul.enums.BoletoEnum;
import br.com.contaazul.repository.BoletoRepository;
import br.com.contaazul.repository.entity.BoletoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository boletoRepository;

    public void cadastrar(BoletoRequest boletoRequest) {
        BoletoEntity boletoEntity = new BoletoEntity();
        boletoEntity.setDue_date(boletoRequest.getDue_date());
        boletoEntity.setCustomer(boletoRequest.getCustomer());
        boletoEntity.setStatus(BoletoEnum.PENDING);
        boletoEntity.setTotal_in_cents(boletoRequest.getTotal_in_cents());
        boletoRepository.save(boletoEntity);
    }

    public Iterable<BoletoEntity> retornarBoletos() {
        Iterable<BoletoEntity> boletos = boletoRepository.findAll();
        return boletos;
    }

    public void pagar(UUID id, LocalDate payment_date) {
        Optional<BoletoEntity> boletoEntity = boletoRepository.findById(id);
        if (boletoEntity.isPresent()) {
            boletoEntity.get().setStatus(BoletoEnum.PAID);
            boletoEntity.get().setPayment_date(payment_date);
            boletoRepository.save(boletoEntity.get());
        }
    }

    public void cancelar(UUID id, BoletoEnum status) {
        Optional<BoletoEntity> boletoEntity = boletoRepository.findById(id);
        if (boletoEntity.isPresent()) {
            boletoEntity.get().setStatus(BoletoEnum.CANCELED);
            boletoRepository.save(boletoEntity.get());
        }
    }

    public BigDecimal juros(UUID uuid, LocalDate due_date, LocalDate payment_date, BigDecimal total_in_cents) {
        if (TimeUnit.MILLISECONDS.toDays((payment_date.getDayOfMonth() - payment_date.getDayOfMonth())) < 10 ) {
            return total_in_cents.multiply(new BigDecimal("0.005")).setScale(2);
        } else {
            return total_in_cents.multiply(new BigDecimal("0.01")).setScale(2);
        }
    }
}
