/**
 * Created by mars on 2017/1/24.
 */
public class AssertionDriver {
    public static void main(String args[]) {
        Employee employee = new Employee();
//        employee.setName("Lang Yu");
//        employee.setEmail("silentbalanceyh@126.com");
        businessProcess(employee);
    }

    public static void businessProcess(Employee employee) {
        try {
            assert employee.getName() != null && employee.getEmail() != null
                    && employee.getPassword() != null : employee;
        } catch (AssertionError error) {
            System.out.println(error);
        }
    }
}

class Employee {
    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "/nName:" + name + "/n" + "Email:" + email + "/n" + "Password:" + password;
    }
}
