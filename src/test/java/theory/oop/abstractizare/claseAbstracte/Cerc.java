package theory.oop.abstractizare.claseAbstracte;

// spre deosebire de interfete, aici putem face extend la o singura clasa abstracta
public class Cerc extends FormeGeometrice {

    private double raza;

    @Override
    public void calculareArie() {
        System.out.println("Aria cercului este: " + Math.PI * Math.pow(raza, 2));
    }

    public double getRaza() {
        return raza;
    }

    public void setRaza(double raza) {
        this.raza = raza;
    }
}
