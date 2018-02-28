package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 时钟组件
 * @author 刘双源
 *
 */
public interface Part {
	
	public void setClockValue(String value) throws IllegalClockException;

	public String getPrintStr();
	
}
