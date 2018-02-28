package com.paic.arch.interviews.clock.parts;

import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 时钟组件抽象模板类
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public abstract class AbstractPart implements Part{

	/**
	 * 组件相关的时间值
	 */
	protected int clockValue;

	/**
	 * 亮灯数
	 */
	protected int brightNumber;

	/**
	 * 设置时间值
	 */
	@Override
	public void setClockValue(String value) throws IllegalClockException {
		getTimeNumber(value);
		countBrightNumber();
	}

	public int getBrightNumber() {
		return brightNumber;
	}

	public void setBrightNumber(int brightNumber) {
		this.brightNumber = brightNumber;
	}

	
	/**
	 * 校验并获取有效数据
	 * @param clockValue
	 * @throws IllegalClockException
	 */
	protected abstract void getTimeNumber(String clockValue) throws IllegalClockException;

	/**
	 * 计数亮灯数目
	 */
	protected abstract void countBrightNumber();

	/**
	 * 获取亮灯情况
	 * @return 获取组件打印字符串
	 */
	@Override
	public abstract String getPrintStr();

	@Override
	public String toString() {
		return getPrintStr();
	}

}
