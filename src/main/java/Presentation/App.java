package Presentation;

import exc1.a.*;
import exc1.b.*;
import exc1.c.*;
import exc2.a.*;
import exc2.a.F;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        F testF = new F();
        testF.processUnprocessedRegisters();
    }
}