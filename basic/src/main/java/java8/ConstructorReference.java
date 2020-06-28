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
        System.out.println(a);
        System.out.println(t);
    }

    static Collection<String> method(Supplier<Collection<String>> container) {
        Collection<String> collection = container.get();
        for (int i = 0; i < 5; i++)
            collection.add("ID:" + UUID.randomUUID().toString());
        return collection;
    }
}


