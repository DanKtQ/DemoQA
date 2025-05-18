package theory.oop.abstractizare.claseAbstracte;

public abstract class FormeGeometrice {

    public String culoare;

    public abstract void calculareArie();

    public void deseneaza() {
        System.out.println("Deseneaza forma");
    }
}
