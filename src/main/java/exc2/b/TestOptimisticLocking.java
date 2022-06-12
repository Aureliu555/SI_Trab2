package exc2.b;

import exc2.a.F;

public class TestOptimisticLocking {
    public static void main(String[] args) throws Exception {
        try {
            F testF = new F();

            // tests the function that divides all RegistoNProcessado objects into Invalido or Processado objects
            testF.processUnprocessedRegisters();

        } catch (Exception e) {
            System.out.println("\nERROR: The register you are trying to access is currently unstable\n");
            throw e;
        }
    }
}
