package Presentation;

import exc1.a.*;

import java.util.List;

public class App {
    @SuppressWarnings("unchecked")
    public static void main( String[] args ) throws Exception {
        D test_d = new D();
        E test_e = new E();
        //it's ok. AA
//        test_d.removePrivateClient(75485454); //Functional
//        test_d.addPrivateClient(11112222, 200000011, "Teste to Test", "999111222", "Rua dos Testes", 765865645);
//        test_d.addPrivateClient(11112223, 200100011, "Teste to Test", "999111222", "Rua dos Testes");
//        test_d.updatePrivateClient(10000024,200110011, "Edgar Calabroso", "999111222", "Rua dos Testes",200000011,765865645);
//        test_d.removePrivateClient(11112223);
        List<Integer> a = test_e.countAlarms(2021, "20-VT-65");
        System.out.println(a);
    }
}

