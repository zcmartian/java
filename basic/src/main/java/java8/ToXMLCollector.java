package java8;


import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;

public class ToXMLCollector implements Collector<ToXMLCollector.Employee, StringBuffer, String> {

    final String xmlstr = "\n\t<employee eid='%s'>\n\t\t" + "<name>%s</name>\n\t\t"
            + "<tech>%s</tech>\n\t\t<salary>%s</salary>\n\t</employee>";

    public static void main(String[] args) {
        Set<Employee> emps = Database.employees();
        String xmlstr = emps.parallelStream().collect(new ToXMLCollector());
        System.out.println(xmlstr);
    }

    public Supplier<StringBuffer> supplier() {
        return StringBuffer::new;
    }

    public BiConsumer<StringBuffer, Employee> accumulator() {
        return (sb, e) -> sb.append(String.format(xmlstr, e.empid, e.name, e.technology, e.salary));
    }

    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    public Function<StringBuffer, String> finisher() {
        return sb -> String.format("<employees> %s \n</employees>", sb.toString());
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(CONCURRENT);
    }

//    public Set<Characteristics> characteristics() {
//        return EnumSet.of(CONCURRENT);
//    }

    @AllArgsConstructor
    static class Employee {
        public String name;
        public String empid;
        public String technology;
        public double salary;
    }

    static class Database {
        static Set<Employee> employees() {
            Set<Employee> ret = new HashSet<>();
            ret.add(new Employee("Mr Bean", "E1001", "Cloud Computing", 100D));
            ret.add(new Employee("J Smith", "E1002", "Java", 100D));
            return ret;
        }
    }
}
