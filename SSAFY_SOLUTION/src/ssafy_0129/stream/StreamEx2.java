/*package ssafy_0129.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//인자 2개받는 생성자, setter& getter, toString()==> return "이름:"+name+" 점수:"+tot
class Student {
	String name;
	int tot;

	public Student(String name, int tot) {
		super();
		this.name = name;
		this.tot = tot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	@Override
	public String toString() {
		return "이름:" + name + "  점수:" + tot;
	}
}

public class StreamEx2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("kim", 90));
		list.add(new Student("lee", 65));
		list.add(new Student("park", 100));
		list.add(new Student("hong", 75));
		list.add(new Student("kang", 80));

		// 객체중에 점수가 80점 이상인 학생만 출력(filter)
		Stream<Student> rs = list.stream().filter(s -> s.tot >= 80);
		rs.forEach(m -> System.out.println(m.toString()));

		// list.stream().filter(s->s.tot>=80).forEach(System.out::println);
		// --------------------------------------------------------------------
		// 앞에서 부터 3 객체 까지만 출력(limit)
		rs = list.stream().limit(3);
		// --------------------------------------------------------------------
		// 점수를 50점 만점으로 환산하시오(map)
		list.stream().map(i -> i.tot / 2).forEach(i -> System.out.println(i));
		// --------------------------------------------------------------------
		// 점수순으로 오름차순 정렬하시오
		list.sort((o1,o2)->o1.getTot()-o2.getTot());
		list.forEach(m->System.out.println(m.toString()));
		// --------------------------------------------------------------------
		// 이름으로 내림차순 정렬하시오
		list.sort((o1,o2)->o2.getName().compareTo(o1.getName()));
		list.forEach(m->System.out.println(m.toString()));
	}
}



*/