/*
 Walter Vieira (2022-04-22)
 Sistemas de Informa��o - projeto JPAAulas_ex1
 C�digo desenvolvido para iulustra��o dos conceitos sobre acesso a dados, concretizados com base na especifica��o JPA.
 Todos os exemplos foram desenvolvidos com EclipseLinlk (3.1.0-M1), usando o ambientre Eclipse IDE vers�o 2022-03 (4.23.0).
 
N�o existe a pretens�o de que o c�digo estaja completo.

Embora tenha sido colocado um esfor�o significativo na corre��o do c�digo, n�o h� garantias de que ele n�o contenha erros que possam 
acarretar problemas v�rios, em particular, no que respeita � consist�ncia dos dados.  
 
*/

package BusinessLogic;

import java.util.List;
import jakarta.persistence.*;

import model.*;

/**
 * Hello world!
 *
 */
public class BLService 
{
    @SuppressWarnings("unchecked")
	public void test() throws Exception
    { //
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try 
        {
        	//Criar um aluno
            System.out.println("Ler um aluno");
            em.getTransaction().begin();

        	String sql = "SELECT a FROM Aluno a";
        	Query query = em.createQuery(sql);
            List<Aluno> la = query.getResultList();


            for (Aluno ax : la) 
            {
                System.out.printf("%d ", ax.getNumal());
                System.out.printf("%s \n", ax.getNomeal());
            }
            
  
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
