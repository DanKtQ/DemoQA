package theory.exceptions;

public class Exception1 {

    // Exceptiile reprezinta situatii care apar in timpul executiei unui program care determina oprirea acestuia
    // Exceptiile ofera un mecanism eficient de identificare si rezolvare a erorilor
    // Sunt modelate sub forma de clase: clasa error, clasa exception, runtimeException, clase personalizate
    // Exceptiile sunt gestionate folosind cuvinte predefinite in Java: tryCatch si finally;
    // Sunt 2 tipuri mari de exceptii: checked si unchecked
    // Erorile checked sunt exceptii de compilare: nu poti sa builduiesti/rulezi proiectul daca nu tratezi aceasta exceptie. Exemple: SQLException, IOException, ClassNotFoundException
    // Erorile unchecked sunt exceptii de runtime, care sunt ignorate in timpul compilarii, dar sunt aruncate in timpul executiei programului. Exemple: NullPointerException, ArrayIndexOutOfBound, ArithmeticException
    // throw este un cuvant cheie care arunca exceptia in mod explicit de la o metoda sau un bloc de cod
    // throws este un cuvant cheie care se foloseste odata cu metoda, care poate arunca un tip sau mai multe de exceptii;

    public static void main(String[] args) throws Exception {
//        try {
//            System.out.println(12 / 0);
//        } catch (ArithmeticException e) {
//            System.out.println("Error arithmetic exception trown: " + e.getMessage());
//        }
//    }

        try {
            int[] numbers = new int[10];
            numbers[11] = 5;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.getMessage());
            throw new CustomException("Eroare custom.");
        } finally {
            System.out.println("Aceasta linie se executa indiferent daca exceptia este prinsa");
        }
    }
}