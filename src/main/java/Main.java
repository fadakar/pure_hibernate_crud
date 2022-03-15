import Model.DAO.PersonDAO;
import Model.TO.Person;

/**
 * @author grf
 */
public class Main {
    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO();

        //---------------- add new person -----------------
        System.out.println(personDAO.all());


        //---------------- add new person -----------------
        Person person = new Person();
        person.setFirstName("reza");
        person.setLastName("fadakar");
        personDAO.add(person);
        System.out.println(personDAO.all());

        //---------------- find person by id --------------
        Person foundPerson = personDAO.find(2);
        System.out.println(foundPerson);

        //---------------- update person ------------------
        foundPerson.setLastName("mohammadi");
        personDAO.update(foundPerson);
        System.out.println(foundPerson);
        System.out.println(personDAO.all());


        //---------------- delete person ------------------
        personDAO.delete(foundPerson);

    }


}
