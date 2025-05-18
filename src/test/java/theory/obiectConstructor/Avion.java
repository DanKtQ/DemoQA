package theory.obiectConstructor;

public class Avion {

    // Constructor = Are ca rol sa initializeze variabilele unei clase
    // Recunoastem un constructor dupa numele clasei
    // Intr-o clasa putem avea n constructori care se diferentiaza dupa numarul sau tipul de parametri
    // Exista 2 tipuri de constructori: cu parametri sau fara parametri
    // Intr-o clasa avem tot timpul un constructor default(fara parametri)
    // Constructorul trebuie sa fie Public

    // Obiect = instanta unei clase
    // Dintr-o clasa putem sa facem mai multe obiecte
    // Ca sa initializam un obiect ne folosim de cuvantul "new"
    // Cand se initializeaza un obiect, se apeleaza constructorul clasei

    public String tip;
    public String marca;
    public String model;
    public Integer capacitatePasageri;
    public String tipCombustibil;
    public Integer numarBagaje;

    public Avion(String tip, String marca, String model, Integer capacitatePasageri, String tipCombustibil) {
        this.tip = tip;
        this.marca = marca;
        this.model = model;
        this.capacitatePasageri = capacitatePasageri;
        this.tipCombustibil = tipCombustibil;
    }

    public Avion(String tip, String marca, String model, Integer capacitatePasageri, String tipCombustibil, Integer numarBagaje) {
        this.tip = tip;
        this.marca = marca;
        this.model = model;
        this.capacitatePasageri = capacitatePasageri;
        this.tipCombustibil = tipCombustibil;
        this.numarBagaje = numarBagaje;
    }

    public void prezentareAvion() {
        System.out.println("Tipul avionului: " + tip);
        System.out.println("Marca avionului: " + marca);
        System.out.println("Model avionului: " + model);
        System.out.println("Capacitate pasageri: " + capacitatePasageri);
        System.out.println("Tip Combustibil: " + tipCombustibil);
        if (numarBagaje != null) {
            System.out.println("Nr bagaje: " + numarBagaje);
        } else {
            System.out.println("Avionul nu are bagaje.");
        }
    }


}
