package xunbo.converter;

import com.google.appengine.api.datastore.Text;
import ognl.DefaultTypeConverter;

import java.util.Map;

public class TextConverter extends DefaultTypeConverter {
	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map map, Object o, Class toType) {
		if (toType == Text.class) {
			String value = ((String[]) o)[0];
			return new Text(value);
		} else if (toType == String.class) {
			Text text = (Text) o;
			return text.getValue();
		}

		return null;
	}
}
