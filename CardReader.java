package edu.scau.ooad.atm.domain;

/**
 * 读卡器接口
 * 本地接口
 * 设计本地接口调用外部硬件和软件接口建议使用适配器模式，应对硬件多样性
 */
public interface CardReader {
	/**
	 * 读卡
	 */
	public void readCard();  //返回值及参数各组自行设计
	
	/**
	 * 退卡
	 */
	public void exitCard(); //返回值及参数各组自行设计
	
	/**
	 * 吞卡
	 */
	public void keepCard(); //返回值及参数各组自行设计
}
