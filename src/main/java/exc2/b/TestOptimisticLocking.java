package exc2.b;

import exc2.a.F;

public class TestOptimisticLocking {
    public static void main(String[] args) throws Exception {
        F testF = new F();
        testF.processUnprocessedRegisters();
    }
}
