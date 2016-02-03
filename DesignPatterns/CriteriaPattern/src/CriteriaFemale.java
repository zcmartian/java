import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/2/3.
 */
public class CriteriaFemale implements Criteria{
    @Override public List<Person> meetCriteria(List<Person> personList) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
