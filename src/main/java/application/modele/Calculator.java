package application.modele;

import application.exception.CalculException;
import application.exception.RequeteException;


public class Calculator {

	public Calculator(){}



	public String verifRequete(String s) throws RequeteException {
		String newRequete = s;
		for (int i = 0; i <newRequete.length() ; i++) {
			char c = newRequete.charAt(i);
			System.out.println("le caractere est : " + c);
			//verifcaractere inconnu
			if(estInconnu(c)){
				throw new RequeteException();
			}
			//requete se finit avec un operateur ou une parenthese ouvrante
			if(estOperatorPasParenthese(newRequete.charAt(newRequete.length()-1)) || newRequete.charAt(newRequete.length()-1) == '('){
				throw new RequeteException();
			}
			//traitement de la suivi de deux opérateur
			if(c!=newRequete.length()-1){
				System.out.println("ici");
				//les deux operateurs + et - cas particulier
				if(c == '+') {
					if (newRequete.charAt(i + 1) == ' ') {
						System.out.println("vide ");
						i++;
					}
					if (newRequete.charAt(i + 1) == '-') {
						System.out.println("ancienne requete :" + newRequete);
						newRequete = newRequete.substring(0, i) + newRequete.substring(i + 1);
						i++;
						System.out.println("nouvelle requete : " + newRequete);
					}else if(newRequete.charAt(i + 1) == '+'){
						System.out.println("ancienne requete :" + newRequete);
						newRequete = newRequete.substring(0, i) + newRequete.substring(i + 1);
						i++;
						System.out.println("nouvelle requete : " + newRequete);
					}else {

					}
				} else if(c == '-') {
					if (newRequete.charAt(i + 1) == ' ') {
						i++;
					}
					if (newRequete.charAt(i + 1) == '-') {
						System.out.println("ancienne requete :" + newRequete);
						newRequete = newRequete.substring(0, i) + '+' + newRequete.substring(i+2);
						i++;
						System.out.println("nouvelle requete : " + newRequete);
					}else if(newRequete.charAt(i + 1) == '+'){
						System.out.println("ancienne requete :" + newRequete);
						newRequete = newRequete.substring(0, i+1) + newRequete.substring(i+2);
						i++;
						System.out.println("nouvelle requete : " + newRequete);
					}else {

					}
				}else if(estOperatorPasParenthese(c) && estOperatorPasParenthese(s.charAt(i+1))){
					System.out.println("throw Exception");
					throw new RequeteException();
				}
				else {
					newRequete = newRequete;
					System.out.println(" la " + newRequete);
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
