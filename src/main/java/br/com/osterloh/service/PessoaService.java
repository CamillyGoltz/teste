package br.com.osterloh.service;

import br.com.osterloh.model.Pessoa;
import br.com.osterloh.service.IPessoaService;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class PessoaService implements IPessoaService {

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        Long id = new AtomicLong().incrementAndGet();
        pessoa.setId(id);

        if (Objects.isNull(pessoa.getEmail()) || pessoa.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-Mail é nulo ou vazio!!!");
        }

        return pessoa;
    }
}