package Presentation;

import exc1.a.*;
import exc1.b.*;
import exc1.c.*;
import exc2.a.*;
import exc2.a.F;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        NoStoredProcedure test_h = new NoStoredProcedure();
        test_h.createAndAssociateVehicle("10-PG-20",689425389,"Pedro Miguel", "912345678",0,2, null, null, null);
    }
}