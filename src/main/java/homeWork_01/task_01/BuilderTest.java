package homeWork_01.task_01;

import homeWork_01.task_01.builder.Person;

public class BuilderTest {
    public static void main(String[] args) {
        Person person = Person.builder()
                .withAddress("Полтавская д.8")
                .withAge(56)
                .withCountry("Спб")
                .withFirstName("Парус")
                .withLastName("Кораблевич")
                .withMiddleName("Полтавский")
                .withGender("М")
                .withPhone("+7-922-344-89-45")
                .build();

        System.out.println(person);
    }
}
