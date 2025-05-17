package theory.OOP;

public class Persoana {

    // OOP = programare orientata obiect
    // 4 principii: mostenire, incapsulare, polimorfism, abstractizare
    // mostenire = conceptul prin care o clasa(copil) mosteneste o alta clasa(parinte)
    // in Java putem mosteni o singura clasa
    // in momentul cand o clasa mosteneste o alta clasa, clasa copil trebuie sa apeleze constructorul din parinte
    // in momentul in care se aplica mostenirea, copilul are vizibilitate asupra variabilelor/metodelor din parinte
    // constructorul din parinte in copil se apeleaza cu "super"

    // Incapsulare = procesul prin care tinem departe anumite informatii ca ele sa nu poate fi modificate
    // facem variabilele/metodele din public in private
    // private = access control care restrictioneaza accesul doar in clasa respectiva
    // ca sa extragem/modificam o valoare a unei variabile private, ne folosim de metode get/set

    private String nume;
    private String prenume;
    private Integer varsta;

    public Persoana(String nume, String prenume, Integer varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public void infoPersoana(){
        System.out.println("Numele este: " + nume);
        System.out.println("Prenumele este: " + prenume);
        System.out.println("Varsta este: " + varsta);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
