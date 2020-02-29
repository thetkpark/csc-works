public class AddLargeNumber {

    Stack operand1, operand2, result;

    public AddLargeNumber (int maxNumberLength) {
        operand1 = new Stack(maxNumberLength);
        operand2 = new Stack(maxNumberLength);
        result = new Stack(maxNumberLength+1);
    }

    public void setOperand1(String operandInString){
        for(int i=0;i<operandInString.length();i++){
            int digit = Integer.parseInt(operandInString.substring(i,i+1));
            this.operand1.push(digit);
        }
    }

    public void setOperand2(String operandInString){
        for(int i=0;i<operandInString.length();i++){
            int digit = Integer.parseInt(operandInString.substring(i,i+1));
            this.operand2.push(digit);
        }
    }

    public String add(String op1, String op2){
        setOperand1(op1);
        setOperand2(op2);
        int carry=0, digit1, digit2;
        while(!operand1.isEmpty() || !operand2.isEmpty()){
            digit1 = operand1.isEmpty()? 0:operand1.pop();
            digit2 = operand2.isEmpty()? 0:operand2.pop();

            int answer = digit1 + digit2 + carry;
            int backDigit = answer%10;
            carry = answer/10;
            this.result.push(backDigit);
        }

        if(carry>0) result.push(carry);
        String resultOfAddition = "";
        while(!result.isEmpty()){
            resultOfAddition = resultOfAddition + result.pop();
        }
        return resultOfAddition;
    }





}
