package theory.oop.abstractizare.interfete;

public class Patrat implements FormeGeometrice{

    private int latura;

    public int getLatura() {
        return latura;
    }

    public void setLatura(int latura) {
        this.latura = latura;
    }

    @Override
    public void calculareArie() {
        System.out.println("Aria patratului este: " + latura * latura );
    }

    @Override
    public void deseneaza() {
        System.out.println("Deseneaza patrat");
    }
}
