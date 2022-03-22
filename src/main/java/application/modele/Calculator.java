package application.modele;

import java.util.Stack;

public class Calculator {

	public Calculator(){}

	public int comparePriority(Operator operator1, Operator operator2){
		//retourne 1 si operateur1 est plus important ou à la meme importance que operateur2
		if(operator1.getPriority() >= operator2.getPriority()){
			return 1;
		}
		return 2;
	}

	public int priority(char c){
		switch (c){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}

	public int calculate(Operator operator,int firstArg, int secondArg){
		switch(operator.getSymbol()) {
			case '+':
				return firstArg + secondArg;
			case '-':
				return firstArg - secondArg;
			case '*':
				return firstArg * secondArg;
			case '/':
				return firstArg / secondArg;
		}

		return 0;
	}

	public boolean estOperator(char c){
		if(c == '+' ||c == '-' ||c == '*' ||c == '/' || c== '(' || c==')'){
			return true;
		}
		return false;
	}

	public boolean estOperatorPasParenthese(char c){
		if(c == '+' ||c == '-' ||c == '*' ||c == '/' ){
			return true;
		}
		return false;
	}

	public boolean estParenthese(char c){
		if(c == '(' || c == ')'){
			return true;
		}
		return false;
	}

	public boolean estChiffre(char c){
		if(c >= '0' && c <= '9'){
			return true;
		}
		return false;
	}

	public boolean estInconnu(char c){
		if(!estOperator(c) && !estChiffre(c)){
			return true;
		}
		return false;
	}
}
