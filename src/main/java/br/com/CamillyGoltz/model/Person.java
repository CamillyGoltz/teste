package br.com.CamillyGoltz.model;

public class Person {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String state;
    private String gender;

    public Person(String name, String surname, String email, String state, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.state = state;
        this.gender = gender;
    }

    public Person(Long id, String name, String surname, String email, String state, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.state = state;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}