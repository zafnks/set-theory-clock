package com.paic.arch.interviews.impl;

import com.paic.arch.interviews.TimeConverter;
import com.paic.arch.interviews.clock.Clock;
import com.paic.arch.interviews.exception.IllegalClockException;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		try {
			return new Clock().buildClock(aTime).getClockString();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalClockException e) {
			e.printStackTrace();
		}
		return null;
	}

}
