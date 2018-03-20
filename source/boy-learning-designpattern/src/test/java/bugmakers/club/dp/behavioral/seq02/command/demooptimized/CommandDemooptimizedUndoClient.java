package bugmakers.club.dp.behavioral.seq02.command.demooptimized;

import bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo.AbstractCalcuCommand;
import bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo.CalculatorForm;
import bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo.ConcreteCalcuCommand;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:50
 */
public class CommandDemooptimizedUndoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        CalculatorForm form = new CalculatorForm();

        AbstractCalcuCommand command = new ConcreteCalcuCommand();
        form.setCommand(command);

        System.out.println("compute-----------------------");
        form.compute(1);
        form.compute(2);
        form.compute(3);
        form.compute(4);
        form.compute(5);
        form.compute(6);

        System.out.println("undo-----------------------");
        form.undo();
        form.undo();
        form.undo();
        form.undo();
        form.undo();

        System.out.println("redo-----------------------");
        form.redo();
        form.redo();
        form.redo();
        form.redo();
        form.redo();
    }
}
