package ssafy_0129.stream;

import java.util.Arrays;
import java.util.Comparator;

//기본 생성자, 인자3개받는 생성자, toString()
class Student2 implements Comparable<Student2> {
	public String name;
	public int num;
	public double score;

	public Student2() {
		super();
	}

	public Student2(String name, int num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}

	@Override
	public String toString() {
		return name + " " + num + " " + score;
	}

	@Override
	public int compareTo(Student2 o) {
		return this.name.compareTo(o.name);	//this가 앞에 있으면 오름차순/ 뒤에있으면 내림차순
	}
}

public class StudentMain2 {
	public static void main(String[] args) {
		Student2[] s = new Student2[5];
		s[0] = new Student2("Dave", 20170301, 4.5);
		s[1] = new Student2("Amie", 20160301, 3.5);
		s[2] = new Student2("Emma", 20180301, 2.5);
		s[3] = new Student2("Brad", 20150301, 4.5);
		s[4] = new Student2("Cara", 20150302, 3.8);

		// 익명중첩클래스 (Anonymous inner class)
		// 학점이 같으면 학번으로 오름차순, 그렇지 않으면 학점 내림차순
		Arrays.sort(s);

		// 익명중첩클래스 (Anonymous inner class)
		// 이름 오름차순
//		Arrays.sort(s, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.name.compareTo(o2.name);
//			}
//		});

		// 익명중첩클래스 (Anonymous inner class)
		// 학점 내림차순
//		Arrays.sort(s, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
		// 숫자 비교랑 문자열 비교랑 다름.
//				return Double.compare(o2.score, o1.score);
//			}
//		});

		// ---------------------------------------------------------
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]); // or s[i].toString()
		}
	}
}
