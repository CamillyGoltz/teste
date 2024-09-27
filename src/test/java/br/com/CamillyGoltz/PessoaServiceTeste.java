package br.com.CamillyGoltz;

import br.com.CamillyGoltz.model.Person;
import br.com.CamillyGoltz.service.IPersonService;
import br.com.CamillyGoltz.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTeste {

    Person person;
    IPersonService service;
    List<Person> persons;

    @BeforeEach
    void setup() {
        service = new PersonService();
        person = new Person("Jhon", "Doe", "john.doe@email.com", "Santa Catarina - SC", "M");
        persons = new ArrayList<>();
        persons.add(new Person("John0", "Doe", "john0.doe@email.com", "Santa Catarina - SC", "M"));
        persons.add(new Person("John1", "Doe", "john1.doe@email.com", "Santa Catarina - SC", "M"));
        persons.add(new Person("John2", "Doe", "john2.doe@email.com", "Santa Catarina - SC", "M"));

    }

    @DisplayName("Teste busca todas pessoas quando sucesso")
    @Test
    void testeBuscaTodasPessoas_QuandoSucesso_DeveRetornarListaPessoas() {
        service.setPersons(Arrays.asList(person, new Person("Jane", "Doe", "jane.doe@email.com", "Santa Catarina - Sc", "F")));
        List<Person> persons = service.findAllPersons();
        assertNotNull(persons, () -> "buscarTodasPessoas() não deve retornar NULL!!!");
        assertEquals(2, persons.size(), () -> "Lista de pessoas está incorreta!!!");
    }

    @DisplayName("Teste busca todas pessoas quando a lista for nula")
    @Test
    void testeBuscaTodasPessoas_QuandoListaNula_DeveRetornarRuntimeException() {
        // Busca todas as pessoas
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> service.findAllPersons(),
                () -> "Lista de pessoas é nula, RuntimeException!!!");

        // Verifica se a mensagem da exceção é a esperada
        assertEquals("Lista de pessoas é nula!!!", exception.getMessage(), () -> "Mensagem da Exception está incorreta!!!");
    }

    @DisplayName("Teste busca todas pessoas quando a lista nula deve retornar sucesso")
    @Test
    void testeBuscaTodasPessoas_QuandoListaNula_DeveRetornarSucesso() {
        List<Person> persons = service.findAllPersons();
        assertTrue(persons.isEmpty(), () -> "Lista de pessoas não está vazia!!!");
    }

    @DisplayName("Teste busca pessoa por ID quando sucesso")
    @Test
    void testeBuscaPessoaPorId_QuandoSucesso_DeveRetornarObjetoPessoa() {
        service.setPersons(Arrays.asList(person));
        Person personFind= service.findPersonById(person.getId());
        assertNotNull(personFind, () -> "buscarPessoaPorId() não deve retornar NULL!!!");
        assertEquals(person, personFind, () -> "Pessoa encontrada é diferente da esperada!!!");
    }

    @DisplayName("Teste busca pessoa por ID não válido quando não encontrado")
    @Test
    void testeBuscaPessoaPorId_NaoEncontrado_DeveRetornarIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.findPersonById(123L),
                () -> "ID não encontrado, IllegalArgumentException!!!");

        assertEquals("Pessoa não encontrada!!!", exception.getMessage(), () -> "Mensagem da Exception está incorreta!!!");
    }

    @DisplayName("Teste busca pessoa por ID não válido quando não encontrado")
    @Test
    void testeBuscaPessoaPorId_NaoEncontrado_DeveRetornarIllegalArgumentExceptionEMensagem() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.findPersonById(123L),
                () -> "ID não encontrado, IllegalArgumentException!!!");

        assertEquals("Pessoa não encontrada!!!", exception.getMessage(), () -> "Mensagem da Exception está incorreta!!!");
    }

    @DisplayName("Teste exclui pessoa quando sucesso")
    @Test
    void testeExcluirPessoa_QuandoSucesso_DeveRemoverObjetoPessoaDaLista() {
        service.setPersons(Arrays.asList(person));
        service.removePerson(person.getId());

        List<Person> persons = service.findAllPersons();
        assertTrue(persons.isEmpty(), () -> "Lista de pessoas não está vazia!!!");
    }
}