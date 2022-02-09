package br.com.contaazul.repository;

import br.com.contaazul.repository.entity.BoletoEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoletoRepository extends CrudRepository<BoletoEntity, Long> {
}