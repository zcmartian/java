import java.util.List;

/**
 * Created by marszhou on 16/2/3.
 */
public class AndCriteria implements Criteria {
    private List<Criteria> criterias;

    public AndCriteria(List<Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> tmpPerson = personList;
        for (Criteria criteria : criterias) {
            tmpPerson = criteria.meetCriteria(tmpPerson);
        }
        return tmpPerson;
    }
}
