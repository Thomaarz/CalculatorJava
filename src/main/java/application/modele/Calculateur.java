package application.modele;

import java.util.LinkedList;

public class Calculateur {

    private LinkedList<Integer> nombres;
    private LinkedList<Operator> operators;

    public Calculateur() {
        this.nombres = new LinkedList<Integer>();
        this.operators = new LinkedList<Operator>();
    }

    private void addCalcul(Integer nombre1, Integer nombre2, Operator operator) {
        if (operator.getPriority() == 2) {
            nombres.addFirst(nombre1);
            nombres.addFirst(nombre2);
            operators.addFirst(operator);
        } else {
            nombres.addLast(nombre1);
            nombres.addLast(nombre2);
            operators.addLast(operator);
        }
    }

    private void addCalcul(String calcul) {

    }

    private int calculer() {
        int result = 0;
        while (operators.size() > 0) {
            Operator operator = operators.pop();

            result += operator.result(nombres.pop(), nombres.pop());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Calculateur{" +
                "nombres=" + nombres +
                ", operators=" + operators +
                '}';
    }

    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();

        calculateur.addCalcul(1, 2, new Operator('+'));
        System.out.println(calculateur.calculer());

    }
}
