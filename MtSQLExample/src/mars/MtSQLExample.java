package mars;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;

public class MtSQLExample {
	public static void main(String args[]) {
		// try {
		// Connection con = null; // 定义一个MYSQL链接对象
		// Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL驱动
		// con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
		// "root", "123456"); // 链接本地MYSQL
		// System.out.print("yes");
		// } catch (Exception e) {
		// System.out.print("MYSQL ERROR:" + e.getMessage());
		// }

		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("测试插入");
		Student addStudent = new Student();
		addStudent.setName("李四");
		addStudent.setBirth(Date.valueOf("2011-09-02"));
		addStudent.setScore(88);
		System.out.println(studentDaoImpl.addStudent(addStudent));
		System.out.println("测试根据id查询");
		System.out.println(studentDaoImpl.selectStudentById(1));
		System.out.println("测试模糊查询");
		List<Student> mohuLists = studentDaoImpl.selectStudentByName("李");
		for (Student student : mohuLists) {
			System.out.println(student);
		}
		System.out.println("测试查询所有");
		List<Student> students = studentDaoImpl.selectAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("根据id删除学生信息");
		System.out.println(studentDaoImpl.deleteStudentById(1));
		System.out.println("测试更新学生信息");
		Student updateStudent = new Student();
		updateStudent.setId(1);
		updateStudent.setName("李四1");
		updateStudent.setBirth(Date.valueOf("2011-08-07"));
		updateStudent.setScore(21);
		System.out.println(studentDaoImpl.updateStudent(updateStudent));
	}
}