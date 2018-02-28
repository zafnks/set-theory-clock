package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 时钟组件
 * @author 刘双源
 *
 */
public interface Part {
	
    /**
     * 设置时间值
     * @param value
     * @throws IllegalClockException
     */
	public void setClockValue(String value) throws IllegalClockException;

	/**
	 * 获取亮灯情况
	 * @return
	 */
	public String getPrintStr();
	
}
