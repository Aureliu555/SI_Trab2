package Presentation;

import exc1.b.*;
import exc1.c.*;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        NoStoredProcedure test_b = new NoStoredProcedure();
        test_b.createAndAssociateVehicle("20-PI-40", 100000000, "Afonso Henriques", "912115678", 0, 2, 2.88, null, null);
    }
}