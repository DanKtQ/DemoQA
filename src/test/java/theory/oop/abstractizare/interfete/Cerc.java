package theory.oop.abstractizare.interfete;

// spre deosebire de clasele abstracte, aici putem implementa mai multe interfete
public class Cerc implements FormeGeometrice, FormeGeometrice2 {

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

    @Override
    public void deseneaza() {
        System.out.println("Deseneaza cerc");
    }
}
