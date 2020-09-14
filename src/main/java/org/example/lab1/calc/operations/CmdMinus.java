package org.example.lab1.calc.operations;

public class CmdMinus extends Cmd {
    CmdMinus(){
        this.setCmdIndex(1);
    }


    @Override
    public String getResult(int operand1, int operand2)  {
        return Integer.toString(operand1 - operand2);
    }

}
