package theory.oop;

public class Persoana {

    // OOP = programare orientata obiect
    // 4 principii: mostenire, incapsulare, polimorfism, abstractizare
    // mostenire = conceptul prin care o clasa(copil) mosteneste o alta clasa(parinte)
    // in Java putem mosteni o singura clasa
    // in momentul cand o clasa mosteneste o alta clasa, clasa copil trebuie sa apeleze constructorul din parinte
    // in momentul in care se aplica mostenirea, copilul are vizibilitate asupra variabilelor/metodelor din parinte
    // constructorul din parinte in copil se apeleaza cu "super"

    // INCAPSULARE = procesul prin care tinem departe anumite informatii ca ele sa nu poate fi modificate
    // facem variabilele/metodele din public in private
    // private = access control care restrictioneaza accesul doar in clasa respectiva
    // ca sa extragem/modificam o valoare a unei variabile private, ne folosim de metode get/set

    // POLIMORFISM = procesul prin care definim mai multe implementari pentru o metoda
    // poate fi de 2 feluri: dinamic(override) si static(overload)
    // polimorfism dinamic = intr-o ierarhie de clase obtinute prin mostenire, o metoda poate avea implementari diferite
    // polimorfism static = posibilitatea prin care o metoda are mai multe implementari prin diferentiarea numarului sau tipului de parametri

    // ABSTRACTIZARE = reducerea unui element complex la un element mai simplu(reducerea completa a implementarii metodelor lasand doar
          //numele functiilor, parametri si tipul returnat)
    // abstractizarea se poate obtine prin clase abstracte si/sau interfete
    // clasele abstracte sunt utilizate pentru a declara caracteristici comune unor subclase
    // o clasa abstracta nu poate fi instantiata. ea poate fi utilizate numai ca superclasa pentru alte clase care extind clasa abstracta
    // clasa abstracta poate fi definita folosind modificatorul "abstract"
    // o clasa abstracta poate contine atribute si metode pe langa clasa abstracta

    // INTERFATA ofera raspuns lipsei mostenirii multiple
    // interfata creeaza un protocol pe care clasele trebuie sa il implementeze
    // interfata contine doar metode abstracte(e o clasa pur abstracta)


    private String nume;
    private String prenume;
    private Integer varsta;

    public Persoana(String nume, String prenume, Integer varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public void infoPersoana() {
        System.out.println("Numele este: " + nume);
        System.out.println("Prenumele este: " + prenume);
        System.out.println("Varsta este: " + varsta);
    }

    //definim prima implementare pentru o metoda(polimorfism dinamic)
    public void mananca() {
        System.out.println("Persoana mananca cand ii este foame");
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
