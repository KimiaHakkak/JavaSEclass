package jalase12.test;

import jalase12.model.da.PersonDa;
import jalase12.model.entity.Person;

public class PersonTest {
    public static void main(String[] args) throws Exception {
        Person person = Person.builder().id(4).name("AAA").family("BBB").build();

        try(PersonDa personDa = new PersonDa()){
//            personDa.save(person);
//            personDa.edit(person);
//            personDa.remove(4);
//            System.out.println(personDa.findAll());
//            System.out.println(personDa.findById(4));
//            System.out.println(personDa.findByFamily("BBB"));
        }
    }
}
