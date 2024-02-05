package com.denismiagkov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class PersonService {

    public String copyPerson(Person person) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(person);
    }

    public Person loadPerson(String copyPerson) {
        return new Gson().fromJson(copyPerson, Person.class);
    }
}
