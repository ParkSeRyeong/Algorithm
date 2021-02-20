package ssafy_0129.stream;

import java.util.Arrays;
import java.util.Comparator;

//기본 생성자, 인자3개받는 생성자, toString()
class Student implements Comparable<Student> {
	public String name;
	public int num;
	public double score;

	public Student() {
		super();
	}

	public Student(String name, int num, double score) {
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
	public int compareTo(Student o) {
		return 0;
	}
}

public class StudentMain1 {
	public static void main(String[] args) {
		Student[] s = new Student[5];
		s[0] = new Student("Dave", 20170301, 4.5);
		s[1] = new Student("Amie", 20160301, 3.5);
		s[2] = new Student("Emma", 20180301, 2.5);
		s[3] = new Student("Brad", 20150301, 4.5);
		s[4] = new Student("Cara", 20150302, 3.8);

		// 익명중첩클래스 (Anonymous inner class)
		// 학점이 같으면 학번으로 오름차순, 그렇지 않으면 학점 내림차순
		Arrays.sort(s, new Comparator<Student>() {         
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.score==o2.score) {
					return Integer.compare(o1.num, o2.num);
				}
				return Double.compare(o2.score, o1.score);
			}
		});
		
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
