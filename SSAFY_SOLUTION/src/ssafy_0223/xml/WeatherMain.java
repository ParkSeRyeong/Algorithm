package ssafy_0223.xml;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class WeatherMain {
	JFrame f = new JFrame("Weather Info");
	JButton b = new JButton("call Weather");
	JList<Object> li = new JList<>();
	WeatherSAX dao;

	public WeatherMain() {
		dao = new WeatherSAX();
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		java.util.List<Weather> datas = dao
				.getNewsList("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4127352500");
		li.removeAll();
		li.setListData(datas.toArray());
	}

	private void createGUI() {
		f.add(b, "North");
		f.add(li);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}
}
/*
https://www.weather.go.kr/w/index.do
(구)날씨누리 바로가기  -> 생활과 산업  -> 서비스(인터넷)


※ XML에 있는 데이터를 추출하는 방식(파싱 API)
1. DOM(Document Object Model)
   - XML 문서의 프로그래밍 interface
   - 정보 전체를 메모리에 로딩 후 접근
   
   -------------우린 SAX로---------------
2. SAX(Simple API for XML)
   - SAX 방식은 라인을 하나하나 순차적으로 읽어가며 파싱을 수행한다.
   - XML 정보를 한줄씩 로딩하여 처리하지만 재로딩은 안됨
   - 속도가 빠르고 메모리 효율이 좋음
	
3. DOM과 SAX 방식 장단점
1)XML 문서를 수정하는 등의 추가적인 핸들링 작업이 들어갈 경우 DOM 방식을 사용한다.
2)단순히 데이터를 파싱하여, 화면에 View하는 경우는 SAX 방식을 사용한다.
3)대용량의 데이터로 인해서, 메모리에 문제가 발생할 경우, SAX 방식을 사용한다.
4)XML 문서의 구조가 복잡할 경우, DOM 방식을 사용한다.
5)단순한 설정을 읽는 경우는 SAX 방식을 사용한다.

DOM 방식의 파싱을 처리하는 파서 객체를 얻기 (DocumentBuilder)
DocumentBuilder를 얻기 위해서는 DocumentBuilderFactory 클래스를 활용한다.
DocumentBuilderFactory는 추상 클래스로 객체 생성이 불가능하다 
 */











