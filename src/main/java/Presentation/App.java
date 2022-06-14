package Presentation;

import BusinessLogic.BLService;

import java.util.Scanner;

public class App {
    @SuppressWarnings("unchecked")

    protected interface ITest {
        void test();
    }

    public static void main(String[] args) throws Exception {
        BLService srv = new BLService();
        ITest tests[] = new ITest[] {
                () -> {try { srv.test1_1a_d_addCliente(); } catch(Exception e) {}} ,
                () -> {try { srv.test3_1a_d_removeCliente(); } catch(Exception e) {}} ,
                () -> {try { srv.test2_1a_d_updateCliente(); } catch(Exception e) {}} ,
                () -> {try { srv.test4_1a_e_countAlarms(); } catch(Exception e) {}} ,
                () -> {try { srv.test5_1a_f_processRegisters(); } catch(Exception e) {}} ,
                () -> {try { srv.test6_1a_g_testAlarmTrigger(); } catch(Exception e) {}} ,
                () -> {try { srv.test7_1a_h_associateVehicle(); } catch(Exception e) {}} ,
                () -> {try { srv.test8_1a_i_createViewAlarm(); } catch(Exception e) {}} ,
                () -> {try { srv.test9_1a_j_associateVehicle(); } catch(Exception e) {}} ,
                () -> {try { srv.test10_1a_k_deleteInvalids(); } catch(Exception e) {}} ,
                () -> {try { srv.test11_1a_l_disableClient(); } catch(Exception e) {}} ,
                () -> {try { srv.test12_1a_m_numAlarmTrigger(); } catch(Exception e) {}} ,
                () -> {try { srv.test13_1b_noStoreProcedure(); } catch(Exception e) {}} ,
                () -> {try { srv.test14_2a_testOptimisticLocking(); } catch(Exception e) {}} ,
        };

        Scanner in = new Scanner(System.in );
        System.out.printf("Escolha um teste (1-%d)? ",tests.length);
        int option = in.nextInt();
        if (option >= 1 && option <= tests.length)
            tests[--option].test();
    }
}