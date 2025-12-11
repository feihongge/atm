package edu.scau.ooad.atm.domain;

import edu.scau.ooad.atm.physical.CardReaderSimulation;
import edu.scau.ooad.atm.physical.CashDispenserSimulation;
import edu.scau.ooad.atm.physical.ReceiptPrinterSimulation;
import org.springframework.stereotype.Controller;

/**
 * 控制器
 * 参考GRASP1控制器设计模式
 * ATM对象接收系统顺序图中所有事件
 *
 * 开发要求和建议：
 * (1) 实验3领域模型所有的概念类设计成软件类，加入到domain包。
 * (2) 修改ATM类中operationX方法的名称与实验4系统顺序图中的事件名称保持一致。
 * (3) 将实验4每个事件的操作契约写在operationN的注释中。
 * (4) 先完成domain类所有业务逻辑，最后再考虑和界面集成。
 * (5) 所有Swing类的Frame/Panel只依赖ATM，不依赖其他domain类
 * (6) ATM是控制器，负责委托协调。ATM负责通过硬件接口完成读卡、吐钞、打印等。
 * (7) ATM是控制器，负责委托协调。ATM中的方法自身并不完成具体的密码验证、取款交易等业务逻辑，需设计专门的业务逻辑类。
 * (8) 密码验证、取款交易只能通过remote包中的RemoteInvoke接口调用服务。调用演示写在测试类RemoteInvokeTest中。
 * (9) 开发过程中不得修改bank-system和bank-sdk代码。atm-clint不能加入bank-system模块maven依赖。不能import导入bank-system模块中的类。
 * (10) 每个事件进行OOD设计时：先讨论方案，画通信图草图。然后编写代码验证设计。验证成功后，StarUml绘制顺序图。
 * (11) Atm项目的OOD与OOP分三次实验课完成：
 *        第一次：完成插卡、验证密码两个事件的设计。成果：2张顺序图 + 1张类图；实现认证授权。
 *        第二次：完成输入取款金额、取走现金两个事件的设计。成果：2张顺序图 + 1张类图；实现取款交易，更新远程账户余额，减少钞箱余额。
 *        第三次：完成打印凭证、退卡两个事件的设计。成果：2张顺序图 + 1张类图。实现打印凭证、退卡。
 * (12) 特别注意几下几点：
 *        本课程对象设计的目标不是实现功能，而是创建优雅、高级的对象设计。
 *        要经常性思考某一行代码写到哪里更适合（课程讲解的职责分配）。
 *        实现功能后，尝试使用GRASP或GOF设计模式重构优化设计。
 * (13) 开发过程中只能对domain包、physical包、view包进行编写代码。
 */
@Controller
public class ATM {
	private CardReader cardReader; //建立ATM和cardReader关联。
	private CashDispenser cashDispenser;
	private ReceiptPrinter receiptPrinter;

	/**
	 * readCard
	 * 插卡
	 * 操作契约：
	 * （1）创建了card对象实例；
	 * （2）创建了Account对象实例currentAccount；
	 * （3）cardReader对象与card对象建立了关联；
	 * （4）修改了card对象属性cardNo；
	 * （5）card对象与currentAccount对象建立了关联；
	 *
	 */
	public void readCard(String cardNo){
		System.out.println("读到卡号：" + cardNo);
		//Todo 交给你了
	}
	/**
	 *
	 * 输入密码，远程验证账户密码。
	 * 操作契约：
	 *
	 *
	 */
	public void operation2(){ //返回类型、方法名、参数各组自行设计
		
	}
	
	/**
	 * 输入取款金额，远程更新账户，钞箱吐钞。
	 * 操作契约：
	 *
	 */
  	public void operation3(){ //返回类型、方法名、参数各组自行设计
  		
	}
	
	
	/**
	 * 取走钞箱吐出的现金，交易成功。
	 * 操作契约：
	 *
	 */
	public void operation4(){  //返回类型、方法名、参数各组自行设计
	
	}

	/**
	 * 打印交易凭证。
	 * 操作契约：
	 *
	 */
	public void operation5(){  //返回类型、方法名、参数各组自行设计

	}

	/**
	 * 退卡。
	 * 操作契约：
	 *
	 */
	public void operation6(){  //返回类型、方法名、参数各组自行设计

	}
	
	/**
	 * ATM开机
	 * 系统管理员用例
	 */
	public void turnOn(){
		cardReader = new CardReaderSimulation();
		/**
		 * 维护系统钞箱现金。
		 * 此处演示使用double，可以封装Cash类。即ArrayList<Cash> 100个cash对象，每个对象为100元。
		 * 本课程设计尽量用对象
		 */
		cashDispenser = new CashDispenserSimulation(10000.00d);  //模拟钞箱中放入10000元
		receiptPrinter = new ReceiptPrinterSimulation();
	}
	//getter
	public CardReader getCardReader() {
		return cardReader;
	}
	public CashDispenser getCashDispenser() {
		return cashDispenser;
	}
	public ReceiptPrinter getReceiptPrinter() {
		return receiptPrinter;
	}

}
