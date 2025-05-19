package theory.oop;

public class AngajatStudent extends Persoana implements AngajatInt, StudentInt {

    private String firma;
    private Integer experienta;
    private Integer zileConcediu;
    private String facultate;
    private String an;
    private Boolean bursa;

    public AngajatStudent(String nume, String prenume, Integer varsta,
                          String firma, Integer experienta, Integer zileConcediu,
                          String facultate, String an, Boolean bursa) {
        super(nume, prenume, varsta);
        this.firma = firma;
        this.experienta = experienta;
        this.zileConcediu = zileConcediu;
        this.facultate = facultate;
        this.an = an;
        this.bursa = bursa;
    }

    @Override
    public void mergeLaMunca() {

    }

    @Override
    public void primesteSalariu() {

    }

    @Override
    public void mergeInPauza() {

    }

    @Override
    public void prezintaDemisie() {

    }

    @Override
    public void mergeLaCurs() {

    }

    @Override
    public void sustineExamene() {

    }

    @Override
    public void mergeLaCafea() {

    }
}
