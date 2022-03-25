package application.modele;
/*
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
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        Operator operator = null;
        boolean test = false;

        for (String c : calcul.split("")) {
            Operator o = new Operator(c.charAt(0));

            if (o.getPriority() > 0) {
                operator = o;
                test = true;
            } else if (!test) {
                n1.append(c);
            } else {
                n2.append(c);
            }
        }

        if (operator != null) {
            addCalcul(Integer.parseInt(n1.toString()), Integer.parseInt(n2.toString()), operator);
        }
    }

    private int calculer() {
        int result = 0;
        while (operators.size() > 0) {
            Operator operator = operators.pop();

            result += operator.result(nombres.pop(), nombres.pop());
        }
        return result;
    }

    private void test() {
        for (Integer i : nombres) {
            System.out.print(i);
        }
        System.out.print(" ");

        for (Operator o : operators) {
            System.out.print(o.getSymbol());
        }
        System.out.println();
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

        calculateur.addCalcul("10*5");
        calculateur.addCalcul("2+7");
        calculateur.test();
        System.out.println(calculateur.calculer());

    }
}
*/