import application.modele.Transformer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculs {

    @Test
    public void testCalculs() {
        Transformer transformer = new Transformer();

        // test infixToPostfix
        //pas d'operateur
        assertEquals("1120",transformer.infixToPostfix("1120"));

        //pas de parenthese
        assertEquals("12+6+95*+55/+",transformer.infixToPostfix("1+2+6+9*5+5/5"));

        //1 niveau de parenthese
        assertEquals("119+9*+",transformer.infixToPostfix("1+(1+9)*9"));

        //1 niveau de parenthese
        assertEquals("119+9*9*9*+",transformer.infixToPostfix("1+(((1+9)*9)*9)*9"));

        //test postfixToEvaluation
        assertEquals(1120,transformer.postfixToEvaluation("1120"));

        assertEquals(56,transformer.postfixToEvaluation("12+6+95*+52/+"));
        assertEquals(91,transformer.postfixToEvaluation("119+9*+"));
        assertEquals(7291,transformer.postfixToEvaluation("119+9*9*9*+"));



    }

}
