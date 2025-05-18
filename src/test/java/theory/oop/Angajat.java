package theory.oop;

public class Angajat extends Persoana {

    private String firma;
    private Integer experienta;
    private Integer zileConcediu;

    public Angajat(String nume, String prenume, Integer varsta, String firma, Integer experienta, Integer zileConcediu) {
        super(nume, prenume, varsta);
        this.firma = firma;
        this.experienta = experienta;
        this.zileConcediu = zileConcediu;
    }

    public void infoAngajat() {
        infoPersoana();
        System.out.println("Numele firmei este: " + firma);
        System.out.println("Ani de experienta: " + experienta);
        System.out.println("Zile de concediu: " + zileConcediu);
    }

    // suprascriem metoda din parinte(polimorfism dinamic)
    public void mananca(){
        System.out.println("Angajatul mananca atunci cand are pauza de masa");
    }

    // polimorfism static
    public void marire(){
        System.out.println("Nu avem buget de mariri");
    }

    public void marire(Integer procent){
        System.out.println("Angajatul a primit o marire de " + procent + "%");
    }

    public void marire(String grad){
        System.out.println("Angajatul a primit gradul de " + grad);
    }

    public void promovare() {
        System.out.println("Angajatul cu numele " + getNume() + " a fost promovat");
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Integer getExperienta() {
        return experienta;
    }

    public void setExperienta(Integer experienta) {
        this.experienta = experienta;
    }

    public Integer getZileConcediu() {
        return zileConcediu;
    }

    public void setZileConcediu(Integer zileConcediu) {
        this.zileConcediu = zileConcediu;
    }
}
