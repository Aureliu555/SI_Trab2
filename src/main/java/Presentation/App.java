package Presentation;

import exc1.a.*;
import exc1.b.*;
import exc1.c.*;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
//        NoStoredProcedure test_b = new NoStoredProcedure();
//        test_b.createAndAssociateVehicle("20-PI-40", 100000000, "Afonso Henriques", "912115678", 0, 2, 2.88, null, null);
        D test_d = new D();
        test_d.addPrivateClient(44112233, 103103103,"Gustavo Lima","922887700", "Rua Castanheira do Sul N11", 659486259);
    }
}