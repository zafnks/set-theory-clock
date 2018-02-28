package com.paic.arch.interviews.clock;

import java.util.ArrayList;
import java.util.List;

import com.paic.arch.interviews.clock.parts.Part;
import com.paic.arch.interviews.exception.IllegalClockException;

/**
 * 时钟类
 * @author 刘双源
 * @date 20180227
 * @version 1.0
 */
public class Clock {

	private final static String CLOCK_VALUE_ERROE = "Illegal Clock Value";

	/**
	 * 时钟组件实现类包路径
	 */
	private final static String CLOCK_PART_PACKAGE = "com.paic.arch.interviews.clock.parts";

	/**
	 * 组件类名称，用半角分号分隔
	 */
	private final static String CLOCK_PART_CLASS = "SecondOne;HourFive;HourOne;MinuteFive;MinuteOne";

	/**
	 * 时钟组件列表
	 */
	private List<Part> clockParts = new ArrayList<Part>(4);

	/**
	 * 构建时钟
	 * @param clockValue 时钟值
	 * @return this
	 * @throws IllegalClockException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Clock buildClock(String clockValue) throws IllegalClockException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
	    // 校验数据
		validateClockValue(clockValue);
		// 清空原组件
		clockParts.clear();
		// 动态加载组件实现类
		String classFormater = "%s.%s";
		String[] implClasses = CLOCK_PART_CLASS.split(";");
		for (int i = 0; i < implClasses.length; i++) {
			Class<?> impl = Class.forName(String.format(classFormater,
					CLOCK_PART_PACKAGE, implClasses[i]));
			Part part = (Part) impl.newInstance();
			// 该组件设置时钟时间
			part.setClockValue(clockValue);
			// 增加组件到列表
			clockParts.add(part);
		}
		return this;
	}

	/**
	 * 获取时钟打印字符串
	 * @return 时钟打印字符串
	 */
	public String getClockString() {
		StringBuffer clock = new StringBuffer(35);
		for (int i = 0; i < clockParts.size(); i++) {
			clock.append(clockParts.get(i).getPrintStr());
			if (i < clockParts.size() - 1) {
				clock.append("\r\n");
			}
		}
		return clock.toString();
	}

	/**
	 * 校验数据
	 * @param clockValue
	 * @throws IllegalClockException
	 */
	private void validateClockValue(String clockValue)
			throws IllegalClockException {
		if (null == clockValue) {
			throw new IllegalClockException(CLOCK_VALUE_ERROE);
		}
	}

}
