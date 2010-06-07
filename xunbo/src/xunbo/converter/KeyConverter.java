package xunbo.converter;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import ognl.DefaultTypeConverter;

import java.util.Map;

public class KeyConverter extends DefaultTypeConverter {
	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map map, Object o, Class toType) {
		if (toType == Key.class) {
			String s = ((String[]) o)[0];
			return KeyFactory.stringToKey(s);
		} else if (toType == String.class) {
			Key k = (Key) o;
			return KeyFactory.keyToString(k);
		}

		return null;
	}
}
