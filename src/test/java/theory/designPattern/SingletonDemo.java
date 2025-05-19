package theory.designPattern;

public class SingletonDemo {

    public static void main(String[] args) {
        SingleObject myObject = SingleObject.getInstance();

        // nu-l putem crea prin "new" pentru ca "SingleObject" has private access in 'DesignPattern.SingleObject'
        // SingleObject mySecondObject = new SingleObject();
    }
}
