package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.clock.ClockConstants;
import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 一秒一格组件
 * 
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public class SecondOne extends AbstractPart {

	

	/**
	 * 计数亮灯数目
	 */
	@Override
	protected void countBrightNumber() {
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
			if (times.length < 3) {
				throw new IllegalClockException("unable to get an second");
			}
			int time = Integer.valueOf(times[2]);
			if (time < ClockConstants.MIN_SECOND_NUMBER || time > ClockConstants.MAX_SECOND_NUMBER) {
				throw new IllegalClockException("second is illegal");
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
		String result = null;
		if (0 == clockValue % 2) {
			result = ClockConstants.SECOND_ON_STRING;
		} else {
			result = ClockConstants.SECOND_OFF_STRING;
		}

		return result;
	}

}
