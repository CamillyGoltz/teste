package br.com.CamillyGoltz.service;

import br.com.CamillyGoltz.model.Person;

import java.util.List;

public interface IPersonService {

    Person createPerson(Person person);

    List<Person> findAllPersons();

    Person findPersonById(long id);

    void removePerson(long id);

    void setPersons(List<Person> persons);

}