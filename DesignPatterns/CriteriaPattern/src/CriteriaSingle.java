import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/2/3.
 */
public class CriteriaSingle implements Criteria{
    @Override public List<Person> meetCriteria(List<Person> personList) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
