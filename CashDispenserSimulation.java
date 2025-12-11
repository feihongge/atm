package edu.scau.ooad.atm.physical;


import edu.scau.ooad.atm.domain.CashDispenser;

import javax.swing.JButton;

/**
 * 使用JButton模拟钞箱
 */
public class CashDispenserSimulation extends JButton implements CashDispenser {
	private static final long serialVersionUID = 1L;
	private double cashBalance; // 钞箱现金余额

	/**
	 * 此处使用double，建议改为BigDecimal或封装Cash类
	 * 本课程设计尽量用对象
	 */
	public CashDispenserSimulation(double cashBalance) {
		super();
		this.cashBalance = cashBalance;
		this.setEnabled(false);  //初始按钮不可用
		this.setText("钞箱余额"+cashBalance);
	}
	
	/**
	 * 吐钞
	 * 
	 */
	@Override
	public void dispenseCash() {
		//TODO 交给你了...
	}

	@Override
	public void close() {	
		//TODO 交给你了...
	}

}
