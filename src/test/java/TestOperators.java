import application.modele.Operator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOperators {

    @Test
    public void testPriotities() {
        Operator plus = new Operator('+');
        Operator moins = new Operator('-');
        Operator multiplier = new Operator('*');
        Operator diviser = new Operator('/');
        Operator inconnu = new Operator('t');

        // Plus
        assertEquals(1, plus.getPriority());

        // Moins
        assertEquals(1, moins.getPriority());

        // Multiplier
        assertEquals(2, multiplier.getPriority());

        // Diviser
        assertEquals(2, diviser.getPriority());

        // Inconnu
        assertEquals(0, inconnu.getPriority());
    }

}
