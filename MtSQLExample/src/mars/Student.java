package mars;

import java.sql.Date;

public class Student {
	// ע��������Ҫ��֤��һ���޲ι��췽������Ϊ����Hibernate���ڵ�ӳ�䶼��ʹ�÷���ģ����û���޲ι�����ܻ��������
	private int id;
	private String name;
	private Date birth;
	private float score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "id=" + id + "\tname=" + name + "\tmajor=" + birth + "\tscore=" + score + "\n";
	}
}