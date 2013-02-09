package org.example.write.domain;

import org.example.write.application.ChangeSex;
import org.example.write.application.RegisterPerson;
import org.junit.Test;

public class PersonTest {
    private static final String GUID = "123";
    private static final String BIRTHDAY = "2010-01-02";
    private static final String GENDER = "female";
    private static final String TITLE = "title";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test(expected = IllegalArgumentException.class)
    public void failsToRegisterWithNullTitle() {
        new Person(new RegisterPerson(GUID, null, FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankTitle() {
        new Person(new RegisterPerson(GUID, "", FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullFirstName() {
        new Person(new RegisterPerson(GUID, TITLE, null, LAST_NAME, BIRTHDAY, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankFirstName() {
        new Person(new RegisterPerson(GUID, TITLE, "", LAST_NAME, BIRTHDAY, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullLastName() {
         new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, null, BIRTHDAY, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankLastName() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, "", BIRTHDAY, GENDER));
    }

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullBirthday() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, LAST_NAME, null, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidBirthday() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, LAST_NAME, "foo", GENDER));
    }

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullGender() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidGender() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, "bar"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToChangeSexToExistingSex() {
        new Person(new RegisterPerson(GUID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER)).changeSex(new ChangeSex(GUID, GENDER));
    }
}