package theory.oop.abstractizare.interfete;

public interface FormeGeometrice2 {

    // permite doar constante, nu si fielduri/proprietati care nu sunt initializate
    // toate metodele declarate sunt by default abstracte
    public static final String culoare = "verde";

    // modifier "public" is redundant for interface members
    // modifier "abstract" is redundant for interface members
         // toate clasele din interface sunt by default publice si abstracte
         // daca incerci sa pui {} inanuntrul metodei primesti eroarea: Interface abstract methods cannot have a body
    public abstract void calculareArie();

    public abstract void deseneaza();
}
