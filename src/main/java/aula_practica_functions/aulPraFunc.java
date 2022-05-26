package aula_practica_functions;


import aula_practica.Pessoa;
import jakarta.persistence.*;

import java.util.List;

public class aulPraFunc {

    @SuppressWarnings("unchecked")
    public void test() throws Exception
    { //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try
        {
            //Criar uma pessoa
            System.out.println("Criar uma pessoa");
            em.getTransaction().begin();

            Pessoa pessoa = new Pessoa();

            pessoa.setId(1);
            pessoa.setNome("João");
            em.persist(pessoa);
            em.getTransaction().commit();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
        finally
        {
            em.close();
            emf.close();
        }
    }
}
