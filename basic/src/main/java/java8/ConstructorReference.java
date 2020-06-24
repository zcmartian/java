package java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {
        ArrayList<String> a = (ArrayList<String>) method(ArrayList::new);
        TreeSet<String> t = (TreeSet<String>) method(TreeSet::new);
    }

    static Collection<String> method(Supplier<Collection<String>> container) {
        Collection<String> c = container.get();
        for (int i = 0; i < 5; i++)
            c.add("ID:" + UUID.randomUUID().toString());
        return c;
    }
}


