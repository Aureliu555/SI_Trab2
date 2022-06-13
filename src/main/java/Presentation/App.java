package Presentation;

import exc1.b.*;

public class App {
    @SuppressWarnings("unchecked")

    public static void main(String[] args) throws Exception {
        try {

            NoStoredProcedure test_h = new NoStoredProcedure();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_h.createAndAssociateVehicle("10-PG-20",689425389,"Pedro Miguel", "912345678",0,2, null, null, null);

        } catch (Exception e) {
            throw e;
        }

    }
}