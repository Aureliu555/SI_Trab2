package Presentation;

import exc1.b.*;
import exc1.c.*;

public class App {
    @SuppressWarnings("unchecked")
    public static void main( String[] args ) throws Exception {
        NoStoredProcedure test_b = new NoStoredProcedure();
        test_b.createAndAssociateVehicle("20-PI-40",689425389,"Afonso Henriques", "912115678",0,2, null, null, null);

//        WithStoredProcedure test_c = new WithStoredProcedure();
//        test_c.createAndAssociateVehicle("20-PI-40",689425389,"Pedro Henriques", "912115678",0,2, null, null, null);

//        test_d.removePrivateClient(75485454);                                                                                     Functional
//        test_d.addPrivateClient(11112222, 200000011, "Teste to Test", "999111222", "Rua dos Testes", 765865645);                  Functional
//        test_d.updatePrivateClient(10000024,200110011, "Edgar Calabroso", "999111222", "Rua dos Testes",200000011,765865645);     Functional
//        test_d.removePrivateClient(10000024);                                                                                     Functional
//        List<Integer> a = test_e.countAlarms(2021, "20-VT-65");                                                                   Functional
//        test_f.processUnprocessedRegisters();                                                                                     Functional
//        test_h.createAndAssociateVehicle("10-PG-20",689425389,"Pedro Miguel", "912345678",0,2, null, null, null);                 Functional
//        test_i.createViewOfAlarm();                                                                                               Functional
//        test_z.deleteInvalidRecordsFromUnprocessed();                                                                             Functional
//        test_m.testNumAlarms_trigger();                                                                                           Functional
    }
}