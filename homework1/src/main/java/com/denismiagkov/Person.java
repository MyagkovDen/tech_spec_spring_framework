package com.denismiagkov;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Person implements Serializable {
    private final String firstname;
    private final String lastname;
    private int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstname", firstname)
                .append("lastname", lastname)
                .append("age", age)
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return new EqualsBuilder()
                .append(age, person.age)
                .append(firstname, person.firstname)
                .append(lastname, person.lastname)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstname)
                .append(lastname)
                .append(age)
                .toHashCode();
    }


}
