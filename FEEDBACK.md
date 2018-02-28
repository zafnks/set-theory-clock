### Candidate Chinese Name:
* 刘双源
 
- - -  
### Please write down some feedback about the question(could be in Chinese):
* 这个题目大致是这样完成的：
	1、把题目中的时钟抽象出时钟->时钟内部组件的模型，时钟类内部包含若干组件实现类。
	2、组件实现类使用反射加载，可以动态拼装，时钟和具体组件间解耦，有需求可以通过MBean等方法即时修改时钟组成无需重启服务
	3、组件结构为Part.java(接口)->AbstractPart.java(抽象类)->ImplClass(具体实现)
	4、组件使用模板方法的设计模式，以后开发新的时钟组件会比较快速
	
PS：1、在story中发现时间有24:00:00这种情况，不确定是不是正常的，故在校验数据时把最大小时常量改成24
	2、测试时发现路径有中文或者特殊符号是会加载不到story，故在ClasspathStoryFinder类加上URL DECODE部分

- - -