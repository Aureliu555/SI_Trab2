package BusinessLogic;

import exc1.a.*;
import exc1.b.*;
import exc2.a.F;

public class BLService {
    public void test1_1a_d_addCliente() throws Exception{
        try {
            D test_d = new D();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_d.addPrivateClient(33112233, 123123123,"Raquel Lima","933887700", "Rua Castanheira do Sul N11");

        } catch (Exception e) {
            throw e;
        }
    }

    public void test2_1a_d_updateCliente() throws Exception{
        try {
            D test_d = new D();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_d.updatePrivateClient(88224466, 456456456, "Núria Barros", "911223344","Rua Cajueiro Seco N30", 103103103, 854645646);

        } catch (Exception e) {
            throw e;
        }
    }

    public void test3_1a_d_removeCliente() throws Exception{
        try {
            D test_d = new D();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_d.removePrivateClient(66224466);

        } catch (Exception e) {
            throw e;
        }
    }

    public void test4_1a_e_countAlarms() throws Exception{
        try {
            E test_e = new E();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_e.countAlarms(2022,"20-VT-65");

        } catch (Exception e) {
            throw e;
        }
    }

    public void test5_1a_f_processRegisters() throws Exception{
        try {
            F test_f = new F();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_f.processUnprocessedRegisters();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test6_1a_g_testAlarmTrigger() throws Exception{
        try {
            G test_g = new G();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_g.test_alarm_trigger();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test7_1a_h_associateVehicle() throws Exception{
        try {
            H test_h = new H();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_h.createAndAssociateVehicle("10-PG-20",689425389,"Pedro Miguel", "912345678",0,2, null, null, null);

        } catch (Exception e) {
            throw e;
        }
    }

    public void test8_1a_i_createViewAlarm() throws Exception{
        try {
            I test_i = new I();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_i.createViewOfAlarm();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test9_1a_j_associateVehicle() throws Exception{
        try {
            J test_j = new J();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_j.insertIntoAlarmsAndProcessedRegistration();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test10_1a_k_deleteInvalids() throws Exception{
        try {
            K test_k = new K();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_k.deleteInvalidRecordsFromUnprocessed();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test11_1a_l_disableClient() throws Exception{
        try {
            L test_l = new L();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_l.disableClientOnDeletion(Boolean.TRUE);

            System.out.println("\nNot Fucntional\n");

        } catch (Exception e) {
            throw e;
        }
    }

    public void test12_1a_m_numAlarmTrigger() throws Exception{
        try {
            M test_m = new M();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_m.testNumAlarms_trigger();

        } catch (Exception e) {
            throw e;
        }
    }

    public void test13_1b_noStoreProcedure() throws Exception{
        try {
            NoStoredProcedure test_h = new NoStoredProcedure();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_h.createAndAssociateVehicle("10-PG-20",689425389,"Pedro Miguel", "912345678",0,2, null, null, null);

        } catch (Exception e) {
            throw e;
        }
    }

    public void test14_2a_testOptimisticLocking() throws Exception{
        try {
            F test_f = new F();

            // tests the function from exercise 2.g) from phase 1 made with the use of no stored procedure
            test_f.processUnprocessedRegisters();

        } catch (Exception e) {
            throw e;
        }
    }

}
