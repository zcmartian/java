package mars;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mars.Student;
import mars.StudentDao;

public class StudentDaoImpl implements StudentDao {
	private static SqlMapClient sqlMapClient = null;

	// ��ȡ�����ļ�
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mars/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean addStudent(Student student) {
		Object object = null;
		boolean flag = false;
		try {
			object = sqlMapClient.insert("addStudent", student);
			System.out.println("���ѧ����Ϣ�ķ���ֵ��" + object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteStudentById(int id) {
		boolean flag = false;
		Object object = null;
		try {
			object = sqlMapClient.delete("deleteStudentById", id);
			System.out.println("ɾ��ѧ����Ϣ�ķ���ֵ��" + object + "�����ﷵ�ص���Ӱ�������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateStudent(Student student) {
		boolean flag = false;
		Object object = false;
		try {
			object = sqlMapClient.update("updateStudent", student);
			System.out.println("����ѧ����Ϣ�ķ���ֵ��" + object + "������Ӱ�������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public List<Student> selectAllStudent() {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectAllStudent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public List<Student> selectStudentByName(String name) {
		List<Student> students = null;
		try {
			students = sqlMapClient.queryForList("selectStudentByName", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public Student selectStudentById(int id) {
		Student student = null;
		try {
			student = (Student) sqlMapClient.queryForObject("selectStudentById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}
