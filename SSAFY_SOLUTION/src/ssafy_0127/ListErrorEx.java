package ssafy_0127;

import java.util.ArrayList;
import java.util.List;

// 제네릭을 사용하지 않으면 컴파일의 문제는 없으나, 실행시에 형변환의 문제가 발생할 수 있음.
public class ListErrorEx {
@SuppressWarnings({ "rawtypes", "unchecked" })
public static void main(String[] args) {
	List list = new ArrayList();
    list.add("봄");
    list.add("여름");
    list.add("가을");
    list.add(new Integer(10));
    list.add("겨울");
    list.add(4.0);
}
}
