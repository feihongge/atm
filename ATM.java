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
 * (2) 
 * (3) 将实验4每个事件的操作契约写在operationN的注释中。
 * (4) 先完成domain类所有业务逻辑，最后再考虑和界面集成。
 * (5) 所有Swing类的Frame/Panel只依赖ATM，不依赖其他domain类
 * (6) ATM是控制器，负责委托协调。ATM负责通过硬件接口完成读卡、吐钞、打印等。
 * (7) ATM是控制器，负责委托协调。ATM中的方法自身并不完成具体的密码验证、取款交易等业务逻辑，需设计专门的业务逻辑类。
 * (8) 密码验证、取款交易只能通过remote包中的RemoteInvoke接口调用服务。调用演示写在测试类RemoteInvokeTest中。
 * (9) 开发过程中不得修改bank-system和bank-sdk代码。atm-clint不能加入bank-system模块maven依赖。不能import导入bank-system模块中的类。
 * 
 * (11) Atm项目的OOD与OOP分三次实验课完成：
 *        第一次：完成插卡、验证密码两个事件的设计。
 *        第二次：完成输入取款金额、取走现金两个事件的设计。
 *        第三次：完成打印凭证、退卡两个事件的设计。
 * (12) 特别注意几下几点：
 *        本课程对象设计的目标不是实现功能，而是创建优雅、高级的对象设计。
 *        要经常性思考某一行代码写到哪里更适合（课程讲解的职责分配）。
 *        实现功能后，尝试使用GRASP或GOF设计模式重构优化设计。
 * (13)
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
     * （2）创建了一个新的Session实例S
     * （3）cardReader对象与card对象建立了关联；
     * （4）S与Card形成关联；
     * 
     *
     */
    public void readCard(String cardNo){
       System.out.println("读到卡号：" + cardNo);
       //Todo 交给你了
    }
    /**
     * enterPIN
     * 输入密码，远程验证账户密码。
     * 操作契约：
     * （1）修改了Session对象的authenticated属性为true(如果密码正确)；
     * （2）修改了Session对象的state属性为"TRANSACTION_SELECTION"；
     * （3）Session对象与Account对象建立了关联；
     */
    public void operation2(){ //返回类型、方法名、参数各组自行设计
       
    }
    
   /**
     * enterAmount
     * 输入取款金额，远程更新账户，钞箱吐钞。
     * 操作契约：
     * （1）修改了Session.currentTransaction对象的amount属性；
     * （2）修改了Session.currentTransaction.account对象的balance属性；
     * （3）修改了Session对象的state属性为"CASH_DISPENSING"；
     * （4）修改了Session.currentTransaction对象的status属性为"AUTHORIZED"；
     * （5）修改了ATM.cashDispenser对象的cashOnHand属性；
     */
    public void operation3(){ //返回类型、方法名、参数各组自行设计
       
    }
    
    
   **
     * takeCash
     * 取走钞箱吐出的现金，交易成功。
     * 操作契约：
     * （1）修改了Session.currentTransaction对象的status属性为"COMPLETED"；
     * （2）修改了Session对象的state属性为"RECEIPT_PRINTING"；
     */
    public void operation4(){  //返回类型、方法名、参数各组自行设计
    
    }

   /**
     * printReceipt
     * 打印交易凭证。
     * 操作契约：
     * （1）创建了Receipt对象实例；
     * （2）Receipt对象与Transaction对象建立了关联；
     * （3）修改了Session对象的state属性为"CARD_RETURN"；
     */
    public void operation5(){  //返回类型、方法名、参数各组自行设计

    }

    /**
     * takeCard
     * 退卡。
     * 操作契约：
     * （1）Session对象与Card对象解除了关联；
     * （2）Session对象与Account对象解除了关联；
     * （3）Session对象的state属性被重置；
     * （4）Session.currentTransaction属性被清空；
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
