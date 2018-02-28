package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.clock.ClockConstants;
import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 五小时一格组件
 * 
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public class HourFive extends AbstractPart {

	/**
	 * 指针总长度
	 */
	private final static int TOTAL_LIGHT_NUMBER = 4;

	/**
	 * 校验并获取有效数据
	 * 
	 * @param hour
	 * @throws IllegalClockException
	 */
	@Override
	protected void getTimeNumber(String clockValue)
			throws IllegalClockException {
		try {
			String[] times = clockValue.split(":");
			if (times.length < 1) {
				throw new IllegalClockException("unable to get an hour");
			}
			int time = Integer.valueOf(times[0]);
			if (time < ClockConstants.MIN_HOUR_NUMBER || time > ClockConstants.MAX_HOUR_NUMBER) {
				throw new IllegalClockException("hour is illegal");
			}
			super.clockValue = time;
		} catch (Exception e) {
			throw new IllegalClockException("Illegal Clock Value", e);
		}
	}

	/**
	 * 计数亮灯数目
	 */
	@Override
	protected void countBrightNumber() {
		super.brightNumber = clockValue / 5;
	}

	/**
	 * 获取亮灯情况
	 */
	@Override
	public String getPrintStr() {
		StringBuffer str = new StringBuffer(TOTAL_LIGHT_NUMBER);
		int numberClone = brightNumber;
		// 拼装亮灯输出字符串
		for (int i = 0; i < TOTAL_LIGHT_NUMBER; i++, numberClone--) {
			str.append(numberClone < 1 ? ClockConstants.HOUR_OFF_STRING
					: ClockConstants.HOUR_ON_STRING);
		}
		return str.toString();
	}

}
