package theory.oop.abstractizare.claseAbstracte;


import org.testng.annotations.Test;

public class OOPAbstractizareTest {

    @Test
    public void metodaTest() {
        Cerc formaCerc = new Cerc();
        formaCerc.setRaza(5);
        formaCerc.calculareArie();

        Patrat formaPatrat = new Patrat();
        formaPatrat.setLatura(10);
        formaPatrat.calculareArie();
    }
}
