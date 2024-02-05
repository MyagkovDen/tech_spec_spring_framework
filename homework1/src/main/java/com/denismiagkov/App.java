package com.denismiagkov;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Person person = new Person("John", "White", 40);
        Person person1 = new Person("Paul", "Black", 82);
        PersonService personService = new PersonService();

        System.out.println("Объект до сериализации: " + person);
        System.out.println(person.equals(person1));
        System.out.println("Хэшкод объекта до сериализации: " + person.hashCode());

        String copyPerson = personService.copyPerson(person);
        System.out.println("Сериализованный объект: " + copyPerson);

        Person loadedPerson = personService.loadPerson(copyPerson);
        System.out.println("Объект после сериализации: " + loadedPerson);
        System.out.println(person.equals(loadedPerson));
        System.out.println("Хэшкод объекта после сериализации: " + loadedPerson.hashCode());

    }
}
