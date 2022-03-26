package application.modele;

import application.exception.CalculException;
import application.exception.RequeteException;

import java.util.Stack;

public class Calculator {

	public Calculator(){}



	public String verifRequete(String s) throws RequeteException {
		String newRequete = "";
		for (int i = 0; i <s.length() ; i++) {
			char c = s.charAt(i);
			//verifcaractere inconnu
			if(estInconnu(c)){
				throw new RequeteException();
			}
			//requete se finit avec un operateur ou une parenthese ouvrante
			if(estOperatorPasParenthese(s.charAt(s.length()-1)) || s.charAt(s.length()-1) == '('){
				throw new RequeteException();
			}
			//traitement de la suivi de deux opérateur
			if(c!=s.length()-1){
				//les deux operateurs + et - cas particulier
				if(c == '+' && s.charAt(i+1) == '-'){
					newRequete = s.substring(0,i) + s.substring(i+1);;
					System.out.println("ancienne requete :" + s
					+ "\n nouvelle requete : " + newRequete);
				} else if(c == '-' && s.charAt(i+1) == '+'){
					newRequete =  s.substring(0,i+1) + s.substring(i+2);
					System.out.println("ancienne requete :" + s + "\n nouvelle requete : " + newRequete);

				}else if(estOperatorPasParenthese(c) && estOperatorPasParenthese(s.charAt(i+1))){
					throw new RequeteException();
				}
				else {
					newRequete = s;
				}}}
		return newRequete;
	}

	public void verifOperation(Operator p, double x, double y) throws CalculException {
		if(p.getSymbol() == '/' && x==0.0){
			throw new CalculException();
		}
	}
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

	public double calculate(Operator operator,double firstArg, double secondArg){
		switch(operator.getSymbol()) {
			case '+':
				return secondArg + firstArg;
			case '-':
				return secondArg - firstArg;
			case '*':
				return secondArg * firstArg;
			case '/':
				return secondArg / firstArg;
			case '^':
				return Math.pow(secondArg, firstArg);

		}

		return 0;
	}

	public boolean estOperator(char c){
		if(c == '+' ||c == '-' ||c == '*'  ||c == '/' || c=='^' || c== '(' || c==')' || c==' '){
			return true;
		}
		return false;
	}

	public boolean estOperatorPasParenthese(char c){
		if(c == '+' ||c == '-' || c=='^' ||c == '*' ||c == '/' ){
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
