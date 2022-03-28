package application.modele;

public class Operator {

	private char symbol;
	private int priority;
	
	public Operator(char symbol) {
		this.symbol = symbol;
		this.priority = symbol == '+' || symbol == '-' ? 1 : symbol == '*' || symbol == '/' || symbol == '(' || symbol == ')' ? 2
				: symbol == '^' ? 3 : 0;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Operator{" +
				"symbol=" + symbol +
				", priority=" + priority +
				'}';
	}
}
