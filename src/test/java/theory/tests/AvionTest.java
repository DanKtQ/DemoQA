package theory.tests;

import org.testng.annotations.Test;
import theory.obiectConstructor.Avion;

public class AvionTest {

    @Test
    public void metodaTest() {
        Avion avion1 = new Avion("Pasageri", "Boeing", "B-127", 260, "Kerosen");
        avion1.prezentareAvion();

        Avion avion2 = new Avion("Pasageri", "Boeing", "B-180", 300, "Green");
        avion2.prezentareAvion();

        Avion avion3 = new Avion("Pasageri", "Boeing", "C-324", 440, "Kerosen", 400);
        avion3.prezentareAvion();
    }
}
