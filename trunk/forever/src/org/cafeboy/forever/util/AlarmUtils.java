package org.cafeboy.forever.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;

public class AlarmUtils {
	/**
	 * <pre>
	 * ������������ģʽ��dateMode����
	 * 1��DATE_MODE_FIX��ָ�����ڣ���20120301   , ����dateValue��ʽ��2012-03-01
	 * 2��DATE_MODE_WEEK�����������ѣ�������һ�������� ,  ����dateValue��ʽ��1,3
	 * 3��DATE_MODE_MONTH���������ѣ���3��2��3�ţ�4��2��3��,  ����dateValue��ʽ��3,4|2,3
	 *  
	 * startTime:Ϊ���쿪ʼʱ�䣬������9��, ������ʽΪ09:00
	 * </pre>
	 */
	public static long getNextAlarmTime(int dateMode, String dateValue, String startTime) {
		final SimpleDateFormat fmt = new SimpleDateFormat();
		final Calendar c = Calendar.getInstance();
		final long now = System.currentTimeMillis();

		// ���ÿ�ʼʱ��
		try {
			if (Task.DATE_MODE_FIX == dateMode) {
				fmt.applyPattern("yyyy-MM-dd");
				Date d = fmt.parse(dateValue);
				c.setTimeInMillis(d.getTime());
			}

			fmt.applyPattern("HH:mm");
			Date d = fmt.parse(startTime);
			c.set(Calendar.HOUR_OF_DAY, d.getHours());
			c.set(Calendar.MINUTE, d.getMinutes());
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long nextTime = 0;
		if (Task.DATE_MODE_FIX == dateMode) { // ��ָ������
			nextTime = c.getTimeInMillis();
			// ָ�������ѹ�
			if (now >= nextTime)
				nextTime = 0;
		} else if (Task.DATE_MODE_WEEK == dateMode) { // ����
			final long[] checkedWeeks = parseDateWeeks(dateValue);
			if (null != checkedWeeks) {
				for (long week : checkedWeeks) {
					c.set(Calendar.DAY_OF_WEEK, (int) (week + 1));

					long triggerAtTime = c.getTimeInMillis();
					if (triggerAtTime <= now) { // ����
						triggerAtTime += AlarmManager.INTERVAL_DAY * 7;
					}
					// �����������ʱ��
					if (0 == nextTime) {
						nextTime = triggerAtTime;
					} else {
						nextTime = Math.min(triggerAtTime, nextTime);
					}
				}
			}
		} else if (Task.DATE_MODE_MONTH == dateMode) { // ����
			final long[][] items = parseDateMonthsAndDays(dateValue);
			final long[] checkedMonths = items[0];
			final long[] checkedDays = items[1];

			if (null != checkedDays && null != checkedMonths) {
				boolean isAdd = false;
				for (long month : checkedMonths) {
					c.set(Calendar.MONTH, (int) (month - 1));
					for (long day : checkedDays) {
						c.set(Calendar.DAY_OF_MONTH, (int) day);

						long triggerAtTime = c.getTimeInMillis();
						if (triggerAtTime <= now) { // ��һ��
							c.add(Calendar.YEAR, 1);
							triggerAtTime = c.getTimeInMillis();
							isAdd = true;
						} else {
							isAdd = false;
						}
						if (isAdd) {
							c.add(Calendar.YEAR, -1);
						}
						// �����������ʱ��
						if (0 == nextTime) {
							nextTime = triggerAtTime;
						} else {
							nextTime = Math.min(triggerAtTime, nextTime);
						}
					}
				}
			}
		}
		return nextTime;
	}

	public static long[] parseDateWeeks(String value) {
		long[] weeks = null;
		try {
			final String[] items = value.split(",");
			weeks = new long[items.length];
			int i = 0;
			for (String s : items) {
				weeks[i++] = Long.valueOf(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weeks;
	}

	public static long[][] parseDateMonthsAndDays(String value) {
		long[][] values = new long[2][];
		try {
			final String[] items = value.split("\\|");
			final String[] monthStrs = items[0].split(",");
			final String[] dayStrs = items[1].split(",");
			values[0] = new long[monthStrs.length];
			values[1] = new long[dayStrs.length];

			int i = 0;
			for (String s : monthStrs) {
				values[0][i++] = Long.valueOf(s);
			}
			i = 0;
			for (String s : dayStrs) {
				values[1][i++] = Long.valueOf(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
}
