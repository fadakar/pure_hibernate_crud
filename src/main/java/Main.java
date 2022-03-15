import Model.DAO.PersonDAO;
import Model.TO.Car;
import Model.TO.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        // create 1 car for this person
        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setModel("benz s500");
        car.setColor("black");
        cars.add(car);
        person.setCars(cars);

        personDAO.add(person);
        System.out.println(personDAO.all());

        //---------------- find person by id --------------
        Person foundPerson = personDAO.find(1);
        System.out.println(foundPerson);

        //---------------- update person ------------------
        foundPerson.setLastName("mohammadi");
        foundPerson.getCars().get(0).setModel("car model updated");
        personDAO.update(foundPerson);
        System.out.println(foundPerson);
        System.out.println(personDAO.all());


        //---------------- delete person ------------------
//        personDAO.delete(foundPerson);

    }


}
