package fr.maxime.entity;

import fr.maxime.interfaces.Ide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

public class DiceScoreTest {
    private DiceScore diceScore;

    private Ide de = Mockito.mock(Ide.class);

    @Test
    public void testDiceScore_ifDeSame() {
        diceScore =  new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(3,3);
        Assertions.assertEquals( (3*2)+10 , diceScore.getScore());
    }

    @Test
    public void testDiceScore_ifAllDe_Same_And_Equals_at_6_result_30() {
        diceScore =  new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6,6);
        Assertions.assertEquals( 30 , diceScore.getScore());
    }

    //    dans le cas ou les dé sont quelconque on recupere la valeure du plus haut des 2
    @Test
    public void testDiceScore_ifDe_NotSame_Take_Bigger_One() {
        diceScore =  new DiceScore(de);
        Random random = new Random();
        Mockito.when(de.getRoll()).thenReturn(4,6);
        Assertions.assertEquals( 6 , diceScore.getScore());
    }
}
