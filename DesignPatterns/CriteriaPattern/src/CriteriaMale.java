import java.util.ArrayList;
import java.util.List;

/**
 * Created by marszhou on 16/2/3.
 */
public class CriteriaMale implements Criteria{
    @Override public List<Person> meetCriteria(List<Person> personList) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
