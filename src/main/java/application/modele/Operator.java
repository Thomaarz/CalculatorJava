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

	public int result(Integer n1, Integer n2) {
		switch (symbol) {
			case '+':
				return n1 + n2;
			case '-':
				return n1 - n2;
			case '*':
				return n1 * n2;
			case '/':
				return n1 / n2;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Operator{" +
				"symbol=" + symbol +
				", priority=" + priority +
				'}';
	}
}
