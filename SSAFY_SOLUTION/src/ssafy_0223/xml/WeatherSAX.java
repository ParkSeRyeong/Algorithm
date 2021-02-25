package ssafy_0223.xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAX {
	List<Weather> list = new ArrayList<>();

	public List<Weather> getNewsList(String url) {
		list.removeAll(list);
		connectWeather(url);
		return list;

	}

	private List<Weather> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;
		Weather w;

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if (w != null) {
				if (name.equalsIgnoreCase("hour")) {
					w.setHour(sb.toString().trim());
				} else if (name.equalsIgnoreCase("temp")) {
					w.setTemp(sb.toString().trim());
				} else if (name.equalsIgnoreCase("wfKor")) {
					w.setWfKor(sb.toString().trim());
				} else if (name.equalsIgnoreCase("reh")) {
					w.setReh(sb.toString().trim());
				} else if (name.equalsIgnoreCase("data")) {
					list.add(w);
				}
			}
			sb.setLength(0);
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list = new ArrayList<Weather>();
			sb = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("data")) {
				w = new Weather();
			}
		}
	}

}