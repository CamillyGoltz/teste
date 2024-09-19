package br.com.osterloh;

import br.com.osterloh.model.Pessoa;
import br.com.osterloh.service.IPessoaService;
import br.com.osterloh.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTeste {

    Pessoa pessoa;
    IPessoaService service;

    @BeforeEach
    void setup() {
        pessoa = new Pessoa("John", "Doe", "john.doe@email.com", 25);
        service = new PessoaService();
    }

    @DisplayName("Teste cria pessoa")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveRetornarObjetoPessoa() {
        Pessoa atual = service.criarPessoa(pessoa);

        assertNotNull(atual, () -> "criarPessoa() não deve retornar NULL!!!");
    }

    @DisplayName("Teste cria pessoa com nome")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveConterPrimeiroNome() {
        Pessoa atual = service.criarPessoa(pessoa);

        assertNotNull(pessoa.getId(), () -> "Não possui ID!!!");
        assertEquals(pessoa.getNome(), atual.getNome(), () -> "Nome da pessoa é diferente!!!");
        assertEquals(pessoa.getSobrenome(), atual.getSobrenome(), () -> "Sobrenome da pessoa é diferente!!!");
        assertEquals(pessoa.getEmail(), atual.getEmail(), () -> "E-Mail da pessoa é diferente!!!");
        assertEquals(pessoa.getIdade(), atual.getIdade(), () -> "Idade da pessoa é diferente!!!");
    }

    @DisplayName("Teste cria pessoa E-Mail nulo")
    @Test
    void testeCriaPessoa_QuandoEmailNull_DeveRetornarThrowIllegalException() {
        pessoa.setEmail(null);

        String mensagemException = "E-Mail é nulo ou vazio!!!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.criarPessoa(pessoa),
                () -> "E-Mail vazio, IllegalException!!!");

        assertEquals(mensagemException,
                exception.getMessage(),
                () -> "Mensagem da Exception está incorreta!!!");
    }
}