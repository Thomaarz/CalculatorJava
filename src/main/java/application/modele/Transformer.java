package application.modele;


import application.exception.CalculException;
import application.exception.RequeteException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Transformer {

    private Calculator calculator;
    private String requete;
    private Stack<Double> doubleStack;
    private Stack<Operator> operatorStack;

    public Transformer(){
        doubleStack =  new Stack<Double>();
        operatorStack = new Stack<Operator>();
        calculator = new Calculator();
    }

    public String infixToPostfix(String s) throws RequeteException, EmptyStackException {
        System.out.println("begin infixToPostfix");
        requete= calculator.verifRequete(s);
        String postfix = "";
        for (int i = 0; i <requete.length() ; i++) {
            char c = requete.charAt(i);
            if(calculator.priority(c)>0){
                while(operatorStack.isEmpty()==false &&
                        calculator.priority(operatorStack.peek().getSymbol())>= calculator.priority(c)){
                    char pa = operatorStack.pop().getSymbol();
                    postfix += pa;
                }
                operatorStack.push(new Operator(c));
            }else if(c==')'){
                Operator x = operatorStack.pop();
                while(x.getSymbol()!='('){
                    postfix += x.getSymbol();
                    x = operatorStack.pop();
                }
            }else if(c=='('){
                operatorStack.push(new Operator(c));
            }else{
                postfix += c;
            }
        }
        for (int i = 0; i <=operatorStack.size() ; i++) {
            if(!operatorStack.isEmpty()){
                char pa =  operatorStack.pop().getSymbol();
                postfix += pa;
            }
        }System.out.println("end infixToPostfix " +  postfix);return postfix;}


    public double postfixToEvaluation(String s) throws CalculException {
        System.out.println("begin postfixToEvaluation");
        System.out.println("infixToEvaluation " + s);

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            else if(Character.isDigit(c))
            {
                double n = 0;
                while(Character.isDigit(c))
                {
                    n = n*10 + (double) (c-'0');
                    i++;
                    try {
                        c = s.charAt(i);

                    }catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
                        break;
                    }
                }
                i--;
                System.out.println(n + " est  push");
                doubleStack.push(n);
            }

            else
            {
                System.out.println("*************************************");

                double val1 = doubleStack.pop();
                System.out.println("val1 = " + val1);
                double val2 = doubleStack.pop();
                System.out.println("val2 = " + val2);
                System.out.println(c);
                calculator.verifOperation(new Operator(c), val1, val2);


                double res = calculator.calculate(new Operator(c),val1,val2);
                System.out.println("res = " + res);
                doubleStack.push(res);
            }
        }
        System.out.println("end postfixToEvaluation");
        return doubleStack.pop();
    }
}

