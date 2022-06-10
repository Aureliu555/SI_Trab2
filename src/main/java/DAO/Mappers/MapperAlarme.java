package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Alarme;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;


public class MapperAlarme  {
//    public void create(Alarme a) throws Exception {
//        try (DataScopeVehicleManager ds = new DataScopeVehicleManager())
//        {
//            EntityManager em = ds.getEntityManager();
//            //em.getTransaction().begin();
//            em.persist(a);
//            ds.validateWork();
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            throw e;
//        }
//
//
//    }
//
//    public Alarme read(Long id) throws Exception {
//        try (DataScopeAlunos ds = new DataScopeAlunos())
//        {
//            EntityManager em = ds.getEntityManager();
//            em.flush();  // � necess�rio para o pr�ximo find encontrar o registo caso ele tenha sido criado neste transa��o
//            Alarme a =  em.find(Aluno.class, id,LockModeType.PESSIMISTIC_READ );
//            ds.validateWork();
//            return a;
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            throw e;
//        }
//
//
//    }
//
//    public void update(Alarme a) throws Exception {
//        try (DataScopeAlunos ds = new DataScopeAlunos())
//        {
//            EntityManager em = ds.getEntityManager();
//            em.flush();  // � necess�rio para o pr�ximo find encontrar o registo caso ele tenha sido criado neste transa��o
//            Alarme a1 = em.find(Aluno.class, a.getNumal(),LockModeType.PESSIMISTIC_WRITE );
//            if (a1 == null)
//                throw new java.lang.IllegalAccessException("Entidade inexistente");
//            a1.setNomeal(a.getNomeal());
//            ds.validateWork();
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            throw e;
//        }
//
//    }
//
//    public void delete(Aluno a) throws Exception {
//        try (DataScopeAlunos ds = new DataScopeAlunos())
//        {
//            EntityManager em = ds.getEntityManager();
//            em.flush(); // � necess�rio para o pr�ximo find encontrar o registo caso ele tenha sido criado neste transa��o
//            Aluno a1 = em.find(Aluno.class, a.getNumal(),LockModeType.PESSIMISTIC_WRITE );
//            if (a1 == null)
//                throw new java.lang.IllegalAccessException("Entidade inexistente");
//            em.remove(a1);
//            ds.validateWork();
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            throw e;
//        }
//
//    }
}
