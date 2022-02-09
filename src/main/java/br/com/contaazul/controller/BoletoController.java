package br.com.contaazul.controller;

import br.com.contaazul.controller.request.BoletoRequest;
import br.com.contaazul.repository.entity.BoletoEntity;
import br.com.contaazul.service.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankslip")
@RequiredArgsConstructor
public class BoletoController {

    private final BoletoService boletoService;

    @GetMapping
    public Iterable<BoletoEntity> retornarBoletos() {
        return boletoService.retornarBoletos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarBoleto(@RequestBody BoletoRequest boletoRequest) {
        boletoService.cadastrar(boletoRequest);
    }
}
