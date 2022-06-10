package exc1.b;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class NoStoredProcedure {
//    public void create_and_associate_Vehicle(String tag, Integer nifClient, String name, String tel, Integer alarms, Integer gps, Double lgtd, Double lttd, Double radius) throws Exception{
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            List n;
//            if (!((lgtd == null && lttd == null && radius == null) || (lgtd != null && lttd != null && radius != null)))
//                em.getTransaction().rollback();
//
//            Query q = em.createNativeQuery("select count(cliente.nif) from cliente where cliente.nif = nifClient");
//            n = q.getSingleResult();
//            if(n == 0) {
//                em.getTransaction().rollback();
//                throw new Exception("Faltam argumentos para a criação de uma zona verde");
//            }
//
//            q = em.createNativeQuery("select count(cliente.nif) from cliente natural join clienteParticular " +
//                    "where cliente.nif = nifClient");
//            n = q.getMaxResults();
//            if (n == 1) {
//                q = em.createNativeQuery("select count(veiculo.nif) into n from veiculo where veiculo.nif = nifClient");
//                n = q.getMaxResults();
//                if (n < 3) {
//                    q = em.createNativeQuery("insert into veiculo(matricula, nif, nomeCondutor, telefone, numAlarmes, gps) " +
//                            "values(tag, nifClient, name, tel, alarms, gps)");
//                    q.executeUpdate();
//                } else em.getTransaction().rollback();
//            }
//
//            if (lgtd != null && lttd != null && radius != null) {
//                q = em.createNativeQuery("insert into zonaVerde(longitude,latitude,raio,matricula) " +
//                        "values (lgtd, lttd, radius, tag)");
//                q.executeUpdate();
//            }
//
//            em.getTransaction().commit();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw e;
//        } finally {
//            assert em != null;
//            em.close();
//            emf.close();
//        }
//    }
}
//
//package BusinessLogic.Handlers.h;
//
//        import Utils.UI_Utils;
//        import static Utils.Utils.CallProcedure;
//
//        import model.EntityParameters;
//        import Utils.Utils.Parameter;
//
//        import java.util.ArrayList;
//
//public class CreateVehicle {
//
//    // IGNORE ARGS FOR NOW, MAYBE REMOVE LATER
//    public static void run() {
//        Parameter matricula = EntityParameters.MATRICULA(false, false);
//        Parameter idCliente = EntityParameters.NIF(false, true);
//        Parameter idGps = EntityParameters.GPSID(false, true);
//        Parameter estadoGps = EntityParameters.ESTADOGPS(false, true);
//        Parameter nomeCondutor = EntityParameters.NOMECONDUTOR(false);
//        Parameter telefoneCondutor = EntityParameters.TELEFONE(false);
//        Parameter numAlarmes = EntityParameters.NUMALARMES(false);
//
//        Boolean result = UI_Utils.getMultipleInputs(new ArrayList<>() {
//            {add(matricula); add(idCliente); add(idGps); add(estadoGps);
//                add(nomeCondutor); add(telefoneCondutor); add(numAlarmes);}
//        });
//
//        if (!result)
//            return;
//
//        Parameter[] args = { matricula, idCliente, idGps, estadoGps,
//                nomeCondutor,telefoneCondutor, numAlarmes };
//        CallProcedure(
//                "create_veiculo",
//                args,
//                Utils.Utils.ProcedureType.STORED_PROCEDURE,
//                Utils.Utils.ReturnType.VOID
//        );
//    }
//}
