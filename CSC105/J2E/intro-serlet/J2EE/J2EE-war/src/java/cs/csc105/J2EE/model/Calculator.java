/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.csc105.J2EE.model;

/**
 *
 * @author CSC102-105
 */
public class Calculator {
    double operator;
    double operand;
    double result;
    String operation;
    
    
    public void calculation(double operand, double operator , String operation){
        if(operation.equals("add")) result = operand + operator;
        else if(operation.equals("subtract")) result = operand - operator;
        else if(operation.equals("multiply")) result = operand * operator;
        else if(operation.equals("divide")) result = operand / operator;
    }

    public double getOperator() {
        return operator;
    }

    public double getOperand() {
        return operand;
    }

    public double getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }

    
    
}
