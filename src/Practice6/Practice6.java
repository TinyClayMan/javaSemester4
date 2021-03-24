package Practice6;

import java.io.IOException;

public class Practice6 {

    public static void main(String[] args) throws IOException {
        FactoryMethodExample.test(); //commercialPlan, domesticPlan, institutionalPlan
        System.out.println("\n");
        AbstractFactoryExample.test(); //hdfc, icici, sbi
        System.out.println("\n");
        BuilderExample.test();
        System.out.println("\n");
        PrototypeExample.test();
    }
}
