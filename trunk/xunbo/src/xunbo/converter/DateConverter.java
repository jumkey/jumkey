package xunbo.converter;

import ognl.DefaultTypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public class DateConverter extends DefaultTypeConverter {
	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map map, Object o, Class toType) {
		DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);// 2007年1月18日 星期四
		//new SimpleDateFormat("yyyy-MM-dd");
		if (toType == Date.class) {
			String s = ((String[]) o)[0];
			try {
				return format.parse(s);
			} catch (ParseException e) {
				System.out.println("日期转换出错");
				return new Date();
			}
		} else if (toType == String.class) {
			Date d = (Date) o;
			return format.format(d);
		}

		return null;
	}
}
