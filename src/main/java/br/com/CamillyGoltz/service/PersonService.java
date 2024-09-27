package br.com.CamillyGoltz.service;

import br.com.CamillyGoltz.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {

    private List<Person> persons = new ArrayList<>();

    @Override
    public Person createPerson(Person person) {
        Long id = new AtomicLong().incrementAndGet();
        person.setId(id);

        if (Objects.isNull(person.getEmail()) || person.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-Mail é nulo ou vazio!!!");
        }

        return person;
    }

    @Override
    public List<Person> findAllPersons() {
        return persons;
    }

    @Override
    public Person findPersonById(long id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void removePerson(long id) {
        persons.removeIf(person -> person.getId() == id);
    }

    @Override
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}