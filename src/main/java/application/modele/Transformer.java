package application.modele;


import java.util.Stack;

public class Transformer {

    private Calculator calculator;
    private String requete;
    private Stack<Integer> integerStack;
    private Stack<Operator> operatorStack;

    public Transformer() {
        integerStack =  new Stack<Integer>();
        operatorStack = new Stack<Operator>();
        calculator = new Calculator();
    }

    public String infixToPostfix(String s)  {
        System.out.println("begin infixToPostfix");
        requete = s;

        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i <requete.length() ; i++) {
            char c = requete.charAt(i);

            //check if char is operator
            if (calculator.priority(c) > 0) {
                while (!operatorStack.isEmpty() && calculator.priority(operatorStack.peek().getSymbol()) >= calculator.priority(c)) {
                    char pa = operatorStack.pop().getSymbol();
                    System.out.println("ajout " + pa);
                    postfix.append(pa);
                }
                operatorStack.push(new Operator(c));
            } else if (c == ')') {
                Operator x = operatorStack.pop();
                while (x.getSymbol() != '(') {
                    System.out.println("ajout " + x.getSymbol());

                    postfix.append(x.getSymbol());
                    x = operatorStack.pop();
                }
            } else if (c == '('){
                operatorStack.push(new Operator(c));
            } else {
                System.out.println(c);
                postfix.append(c);
            }
        }
        for (int i = 0; i <= operatorStack.size(); i++) {
            if (!operatorStack.isEmpty()) {
                char pa =  operatorStack.pop().getSymbol();
                System.out.println("ajout " + pa);

                postfix.append(pa);
            }

        }

        System.out.println("end infixToPostfix " +  postfix);
        return postfix.toString();
    }


    public int postfixToEvaluation(String s){
        System.out.println("begin postfixToEvaluation");
        System.out.println("infixToEvaluation " + s);

        int x, y;
        char[] ch = s.toCharArray();
        StringBuilder total = new StringBuilder();
        for(char c: ch) {
            System.out.println("infixToEvaluation loop");
            if(!calculator.estOperator(c)) {
                total.append(c);

                integerStack.push(Character.getNumericValue(c));

            } else if (!calculator.estParenthese(c)) {

                y = integerStack.pop();
                x = integerStack.pop();
                System.out.println("--------------------------------");
                System.out.println(x);
                System.out.println(y);
                Operator op = new Operator(c);
                int res = calculator.calculate(op, x , y);
                System.out.println(res);
                System.out.println("Transformer : " + x + op.getSymbol() + y +" = " + res);
                System.out.println("--------------------------------");

                integerStack.push(res);
            }
        }
        System.out.println("total : " + total.toString() + "    s = " + s);
        if (total.toString().equals(s)) {
            System.out.println(Integer.parseInt(total.toString()));
            return Integer.parseInt(total.toString());
        }
        System.out.println("end postfixToEvaluation");

        return integerStack.pop();
    }
}

