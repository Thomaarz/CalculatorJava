import application.exception.CalculException;
import application.exception.RequeteException;
import application.modele.Calculator;
import application.modele.Operator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestExceptions {

    @Test
    public void testCalculs() {
        Calculator calculator = new Calculator();

        // Requete invalide
        assertThrows(RequeteException.class, () -> calculator.verifRequete("+"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("-"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("*"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("/"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("1*+"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("2*/"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("3*-"), "La requête saisie est invalide");
        assertThrows(RequeteException.class, () -> calculator.verifRequete("4*-"), "La requête saisie est invalide");

        // Diviseur impossible
        assertThrows(CalculException.class, () -> calculator.verifOperation(new Operator('/'), 0, 5), "Division impossible par 0");

    }

}
