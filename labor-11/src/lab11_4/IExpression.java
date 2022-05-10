package lab11_4;

public interface IExpression {
    public static boolean isOperator (String op){
        if (op.matches("[/+-/*]")){
            return true;
        }
        return false;
    }
    public static double evaluate( String postfixExpression) throws ExpressionException, StackException {
        Stack stack = new Stack(postfixExpression.length());
        String[] items = postfixExpression.split(" ");

        for (String item : items) {
            if (isOperator(item)) {
                //kivesszuk a szamokat
                try {
                    double op1 = (double) stack.pop();
                    double op2 = (double) stack.pop();
                    switch (item) {
                        case "+" -> stack.push(op2 + op1);
                        case "-" -> stack.push(op2 - op1);
                        case "*" -> stack.push(op2 * op1);
                        case "/" -> stack.push(op2 / op1);
                    }
                } catch (StackException e) {
                    throw new StackException("Wrong postfix expression!");
                }
            } else {
                try {
                    stack.push(Double.parseDouble(item));
                } catch (NumberFormatException e) {
                    throw new ExpressionException("Wrong operand: " + item);
                }
            }
        }
        try{
            return (double) stack.pop();
        }
        catch (StackException e){
            throw new StackException("Wrong postfix expression!");
        }

    }
}
