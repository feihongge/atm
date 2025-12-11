package edu.scau.ooad.atm.physical;

import edu.scau.ooad.atm.domain.CardReader;

import javax.swing.JTextField;

/**
 * 使用JTextField模拟读卡器硬件
 *
 */

public class CardReaderSimulation extends JTextField implements CardReader {
	private static final long serialVersionUID = 1L;

	@Override
	public void readCard() {
		// TODO 交给你了	
	}

	@Override
	public void exitCard() {
		// TODO 交给你了	
	}

	@Override
	public void keepCard() {
		// TODO 交给你了	
	}

}
