import java.util.Arrays;

public class JavaArrayCopyMutableObjects {

    public static void main(String[] args) {
        Employee e = new Employee("Pankaj");

        Employee[] empArray1 = {e};

        Employee[] empArray2 = new Employee[empArray1.length];

        System.arraycopy(empArray1, 0, empArray2, 0, empArray1.length);

        System.out.println("empArray1 = "+Arrays.toString(empArray1));
        System.out.println("empArray2 = "+Arrays.toString(empArray2));

        //Let's change empArray1
        empArray1[0].setName("David");

        System.out.println("empArray1 = "+Arrays.toString(empArray1));
        System.out.println("empArray2 = "+Arrays.toString(empArray2));

        empArray2 = fullCopy(empArray1);
        empArray1[0].setName("full");

        System.out.println("empArray1 = "+Arrays.toString(empArray1));
        System.out.println("empArray2 = "+Arrays.toString(empArray2));
    }

    private static Employee[] fullCopy(Employee[] source) {
        Employee[] destination = new Employee[source.length];

        for(int i=0; i< source.length; i++) {
            Employee e = source[i];
            Employee temp = new Employee(e.getName());
            destination[i] = temp;
        }
        return destination;
    }

    private static class Employee {
        private String name;

        public Employee(String n) {
            this.name = n;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

