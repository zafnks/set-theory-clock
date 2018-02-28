package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.clock.ClockConstants;
import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 十五分钟一格组件
 * 
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public class MinuteFive extends AbstractPart {

	/**
	 * 指针总长度
	 */
	private final static int TOTAL_LIGHT_NUMBER = 11;
	
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
			if (times.length < 2) {
				throw new IllegalClockException("unable to get an minute");
			}
			int time = Integer.valueOf(times[1]);
			if (time < ClockConstants.MIN_MINUTE_NUMBER || time > ClockConstants.MAX_MINUTE_NUMBER) {
				throw new IllegalClockException("minute is illegal");
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
		int index = 1;
		for (int i = 0; i < TOTAL_LIGHT_NUMBER; i++, index++) {
			String light = index <= brightNumber ? (0 == index % 3 ? ClockConstants.MINUTE_ON_SPLIT_STRING
					: ClockConstants.MINUTE_ON_STRING)
					: ClockConstants.MINUTE_OFF_STRING;
			str.append(light);
		}
		return str.toString();
	}

}
