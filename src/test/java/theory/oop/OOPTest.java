package theory.oop;

import org.junit.jupiter.api.Test;

public class OOPTest {

    @Test
    public void metodaTest()
    {
        Student Fane = new Student("Popescu", "Stefan", 32, "Automatica", "3", true);
//        Fane.infoStudent();
//        Fane.mananca();

        Angajat Arghezi = new Angajat("Arghezi", "Tudor", 64, "SC POET SRL", 40, 25 );
//        Arghezi.infoAngajat();
        Arghezi.marire();
        Arghezi.marire(10);
        Arghezi.marire("Senior");
//        Arghezi.promovare();
//        Arghezi.mananca();

    }
}
