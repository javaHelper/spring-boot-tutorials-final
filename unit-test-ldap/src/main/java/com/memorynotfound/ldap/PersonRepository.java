package com.memorynotfound.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class PersonRepository {

	@Autowired
	private LdapTemplate ldapTemplate;

	/**
	 * Retrieves all the persons in the ldap server, but we need to map each
	 * attribute individually
	 * 
	 * @return list of person names
	 */
	public List<String> getAllPersonNames() {
		return ldapTemplate.search(query().where("objectclass").is("person"), new AttributesMapper<String>() {
			public String mapFromAttributes(Attributes attrs) throws NamingException {
				return (String) attrs.get("cn").get();
			}
		});
	}

	/**
	 * Retrieves all the persons in the ldap server, using
	 * {@link PersonAttributesMapper}
	 * 
	 * @return list of persons
	 */
	public List<Person> getAllPersons() {
		return ldapTemplate.search(query().where("objectclass").is("person"), new PersonAttributesMapper());
	}

	/**
	 * Searching for one person, using {@link PersonAttributesMapper}
	 * 
	 * @param dn distinguaged name for the person
	 * @return person
	 */
	public Person findPerson(String dn) {
		return ldapTemplate.lookup(dn, new PersonAttributesMapper());
	}

	/**
	 * Custom person attributes mapper, maps the attributes to the person POJO
	 */
	private class PersonAttributesMapper implements AttributesMapper<Person> {
		public Person mapFromAttributes(Attributes attrs) throws NamingException {
			Person person = new Person();
			person.setFullName((String) attrs.get("cn").get());
			person.setLastName((String) attrs.get("sn").get());
			return person;
		}
	}
}
