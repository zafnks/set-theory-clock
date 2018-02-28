package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.clock.ClockConstants;
import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 一分钟一格组件
 * 
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public class MinuteOne extends AbstractPart {

	/**
	 * 指针总长度
	 */
	private final static int TOTAL_LIGHT_NUMBER = 4;

	/**
	 * 计数亮灯数目
	 */
	@Override
	protected void countBrightNumber() {
		brightNumber = clockValue % 5;
	}
	
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
	 * 获取亮灯情况
	 */
	@Override
	public String getPrintStr() {
		StringBuffer str = new StringBuffer(TOTAL_LIGHT_NUMBER);
		int numberClone = brightNumber;
		for (int i = 0; i < TOTAL_LIGHT_NUMBER; i++, numberClone--) {
			str.append(numberClone < 1 ? ClockConstants.MINUTE_OFF_STRING
					: ClockConstants.MINUTE_ON_STRING);
		}
		return str.toString();
	}

}
