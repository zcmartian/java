package java8;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FunctionClass {
    private static BiFunction<Integer, Integer, Integer> myBiFunction = Integer::sum;

    private static int addTwoNumber(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(myBiFunction.apply(1, 2));

        BiFunction<Integer, Integer, Integer> staticFunction = FunctionClass::addTwoNumber;
        System.out.println(staticFunction.apply(1, 2));

        AddClass addClass = new AddClass();
        addClass.setVal(1);

        Map<String, AddClass> mergedIntNominatorMap = new HashMap<>();
        mergedIntNominatorMap.merge("0", addClass, AddClass::add);
        System.out.println(mergedIntNominatorMap);
        mergedIntNominatorMap.merge("0", addClass, AddClass::staticAdd);
        System.out.println(mergedIntNominatorMap);
    }

    @Data
    public static class AddClass {
        private int val;
        public AddClass add(AddClass a) {
            this.val += a.val;
            return this;
        }

        public static AddClass staticAdd(AddClass a, AddClass b) {
            AddClass ret = new AddClass();
            ret.val += a.val + b.val;
            return ret;
        }
    }
}

