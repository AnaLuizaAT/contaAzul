package br.com.contaazul.service;

import br.com.contaazul.controller.request.BoletoRequest;
import br.com.contaazul.enums.BoletoEnum;
import br.com.contaazul.repository.BoletoRepository;
import br.com.contaazul.repository.entity.BoletoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository boletoRepository;

    public void cadastrar(BoletoRequest boletoRequest) {
        BoletoEntity boletoEntity = new BoletoEntity();
        boletoEntity.setDue_date(boletoRequest.getDue_date());
        boletoEntity.setCustomer(boletoRequest.getCustomer());
        boletoEntity.setStatus((BoletoEnum) boletoRequest.getStatus());
        boletoEntity.setTotal_in_cents(boletoRequest.getTotal_in_cents());
        boletoRepository.save(boletoEntity);
    }

    public Iterable<BoletoEntity> retornarBoletos() {
        Iterable<BoletoEntity> boletos = boletoRepository.findAll();
        return boletos;
    }
}
