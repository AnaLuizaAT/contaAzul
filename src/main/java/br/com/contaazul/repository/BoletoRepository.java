package br.com.contaazul.repository;

import br.com.contaazul.repository.entity.BoletoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BoletoRepository extends CrudRepository<BoletoEntity, UUID> {
}