package br.com.contaazul.controller;

import br.com.contaazul.controller.request.BoletoRequest;
import br.com.contaazul.repository.entity.BoletoEntity;
import br.com.contaazul.service.implementation.BoletoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bankslip")
@RequiredArgsConstructor
public class BoletoController {

    private final BoletoServiceImpl boletoServiceImpl;

    @GetMapping
    public Iterable<BoletoEntity> retornarBoletos() {
        return boletoServiceImpl.retornarBoletos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void jurosBoleto(@RequestBody BoletoRequest boletoRequest, @PathVariable UUID id) {
        boletoServiceImpl.juros(id, boletoRequest.getDue_date(), boletoRequest.getPayment_date(), boletoRequest.getTotal_in_cents());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarBoleto(@RequestBody BoletoRequest boletoRequest) {
        boletoServiceImpl.cadastrar(boletoRequest);
    }

    @PostMapping("/{id}/payment")
    @ResponseStatus(HttpStatus.OK)
    public void pagarBoleto(@RequestBody BoletoRequest boletoRequest, @PathVariable UUID id) {
        boletoServiceImpl.pagar(id, boletoRequest.getPayment_date());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelarBoleto(@PathVariable UUID id) {
        boletoServiceImpl.cancelar(id);
    }
}