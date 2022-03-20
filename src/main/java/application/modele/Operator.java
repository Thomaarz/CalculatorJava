package application.modele;

public class Operator {

	private char symbol;
	private int priority;
	
	public Operator(char symbol) {
		this.symbol = symbol;
		this.priority = symbol == '+' || symbol == '-' ? 1 : symbol == '*' || symbol == '/' ? 2 : 0;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getPriority() {
		return priority;
	}
}
