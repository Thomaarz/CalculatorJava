import application.exception.CalculException;
import application.exception.RequeteException;
import application.modele.Transformer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculs {

    public static void main(String[] args) throws RequeteException {
        Transformer transformer = new Transformer();
        System.out.println(transformer.infixToPostfix("1+2+6+9*45+5/5"));
    }

    @Test
    public void testCalculs() throws RequeteException, CalculException {
        Transformer transformer = new Transformer();

        // test infixToPostfix
        //pas d'operateur
        assertEquals("1120",transformer.infixToPostfix("1120"));

        //pas de parenthese
        assertEquals("1  2 + 6 + 9  45 *+ 5  5/+", transformer.infixToPostfix("1+2+6+9*45+5/5"));

        //1 niveau de parenthese
        assertEquals("1  1  9+  9*+",transformer.infixToPostfix("1 +(1 + 9) * 9"));

        //1 niveau de parenthese
        assertEquals("10  1  9+  9*  9*  9*+",transformer.infixToPostfix("10 + (((1 + 9) * 9) * 9) * 9"));

        //test postfixToEvaluation
        assertEquals(757,transformer.postfixToEvaluation("100 200 + 2 / 5 * 7 +"));
        assertEquals(91,transformer.postfixToEvaluation("1 1  9+  9*+"));
        assertEquals(7300,transformer.postfixToEvaluation("10  1  9+  9*  9*  9*+"));

    }

}
