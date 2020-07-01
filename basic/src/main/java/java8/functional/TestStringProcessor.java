package java8.functional;

public class TestStringProcessor {
    public static void main(String[] args) {
        NamedStringProcessor namedSP = new NamedStringProcessor();

        StringProcessor nanoSP = new StringProcessor() {
            @Override
            public String process(String x) {
                return x.toUpperCase();
            }
        };
        System.out.println(namedSP.process("hello"));
        System.out.println(nanoSP.process("world"));
    }
}

class NamedStringProcessor implements StringProcessor {

    @Override
    public String process(String x) {
        return x;
    }
}
