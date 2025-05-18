package theory.oop.abstractizare.claseAbstracte;

public class Patrat extends FormeGeometrice {

   private int latura;

    @Override
    public void calculareArie() {
        System.out.println("Aria patratului este: " + latura * latura );
    }

    public int getLatura() {
        return latura;
    }

    public void setLatura(int latura) {
        this.latura = latura;
    }
}
