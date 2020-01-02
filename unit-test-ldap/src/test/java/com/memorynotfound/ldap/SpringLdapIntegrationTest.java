package com.memorynotfound.ldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class SpringLdapIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetAllPersons() {
        List<Person> persons = personRepository.getAllPersons();
        assertNotNull(persons);
        assertEquals(persons.size(), 3);
    }

    @Test
    public void testGetAllPersonsNames() {
        List<String> persons = personRepository.getAllPersonNames();
        assertNotNull(persons);
        assertEquals(persons.size(), 3);
    }

    @Test
    public void testFindPerson() {
        Person person = personRepository.findPerson("uid=john,ou=people,dc=memorynotfound,dc=com");
        assertNotNull(person);
        assertEquals(person.getFullName(), "John Doe");
    }
}
