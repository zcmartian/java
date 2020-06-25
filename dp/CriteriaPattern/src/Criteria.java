import java.util.List;

/**
 * Created by marszhou on 16/2/3.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> personList);
}
