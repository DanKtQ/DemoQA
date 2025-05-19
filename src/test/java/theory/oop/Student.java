package theory.oop;

public class Student extends Persoana implements StudentInt{

    private String facultate;
    private String an;
    private Boolean bursa;

    public Student(String nume, String prenume, Integer varsta, String facultate, String an, Boolean bursa) {
        super(nume, prenume, varsta);
        this.facultate = facultate;
        this.an = an;
        this.bursa = bursa;
    }

    public void infoStudent() {
        infoPersoana();
        System.out.println("Facultatea este: " + facultate);
        System.out.println("Anul in care se afla studentul este: " + an);
        System.out.println("Studentul ia/nu ia bursa: " + bursa);
    }

    public void mananca(){
        System.out.println("Studentul mananca atunci cand vrea el");
        super.mananca();
    }

    public void absolvire() {
        System.out.println("Studentul cu numele " + getNume() + " si prenumele " + getPrenume() + " a absolvit");
    }

    public String getFacultate() {
        return facultate;
    }

    public String getAn() {
        return an;
    }

    public Boolean getBursa() {
        return bursa;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public void setBursa(Boolean bursa) {
        this.bursa = bursa;
    }

    @Override
    public void mergeLaCurs() {
        System.out.println("Studentul merge la curs");
    }

    @Override
    public void sustineExamene() {
        System.out.println("Studentul are sesiune");
    }

    @Override
    public void mergeLaCafea() {
        System.out.println("Studentul este silitor, nu ca Alex");
    }
}
