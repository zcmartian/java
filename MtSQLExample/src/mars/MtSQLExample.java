package mars;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;

public class MtSQLExample {
	public static void main(String args[]) {
		// try {
		// Connection con = null; // ����һ��MYSQL���Ӷ���
		// Class.forName("com.mysql.jdbc.Driver").newInstance(); // MYSQL����
		// con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
		// "root", "123456"); // ���ӱ���MYSQL
		// System.out.print("yes");
		// } catch (Exception e) {
		// System.out.print("MYSQL ERROR:" + e.getMessage());
		// }

		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("���Բ���");
		Student addStudent = new Student();
		addStudent.setName("����");
		addStudent.setBirth(Date.valueOf("2011-09-02"));
		addStudent.setScore(88);
		System.out.println(studentDaoImpl.addStudent(addStudent));
		System.out.println("���Ը���id��ѯ");
		System.out.println(studentDaoImpl.selectStudentById(1));
		System.out.println("����ģ����ѯ");
		List<Student> mohuLists = studentDaoImpl.selectStudentByName("��");
		for (Student student : mohuLists) {
			System.out.println(student);
		}
		System.out.println("���Բ�ѯ����");
		List<Student> students = studentDaoImpl.selectAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("����idɾ��ѧ����Ϣ");
		System.out.println(studentDaoImpl.deleteStudentById(1));
		System.out.println("���Ը���ѧ����Ϣ");
		Student updateStudent = new Student();
		updateStudent.setId(1);
		updateStudent.setName("����1");
		updateStudent.setBirth(Date.valueOf("2011-08-07"));
		updateStudent.setScore(21);
		System.out.println(studentDaoImpl.updateStudent(updateStudent));
	}
}