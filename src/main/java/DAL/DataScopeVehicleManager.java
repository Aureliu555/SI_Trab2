package DAL;

import DAO.Mappers.*;
import DAO.Repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.TypedQuery;
import model.*;

import java.util.List;

public class DataScopeVehicleManager extends AbstractDataScope implements AutoCloseable {

    /**
     * The session of work
     */
    public DataScopeVehicleManager() throws Exception{
        super();
    }

    //------------------------------------ GetAll ------------------------------------

    /**
     * @return the list of all Cliente objects in RepositoryCliente
     * @throws Exception
     */
    public List<Cliente> getAllClients() throws Exception {
        return new RepositoryCliente().getAll();
    }

    /**
     * @return the list of all ClienteInstitucional objects in RepositoryClienteInstitucional
     * @throws Exception
     */
    public List<ClienteInstitucional> getAllInstitutionalClients() throws Exception {
        return new RepositoryClienteInstitucional().getAll();
    }

    /**
     * @return the list of all ClienteParticular objects in RepositoryClienteParticular
     * @throws Exception
     */
    public List<ClienteParticular> getAllParticularClients() throws Exception {
        return new RepositoryClienteParticular().getAll();
    }

    /**
     * @return the list of all Gps objects in RepositoryGps
     * @throws Exception
     */
    public List<Gps> getAllGps() throws Exception {
        return new RepositoryGps().getAll();
    }

    /**
     * @return the list of all Invalido objects in RepositoryInvalido
     * @throws Exception
     */
    public List<Invalido> getAllInvalids() throws Exception {
        return new RepositoryInvalido().getAll();
    }

    /**
     * @return the list of all Processado objects in RepositoryProcessado
     * @throws Exception
     */
    public List<Processado> getAllProcessado() throws Exception {
        return new RepositoryProcessado().getAll();
    }

    /**
     * @return the list of all RegistoNProcessado objects in RepositoryRegistoNProcessado
     * @throws Exception
     */
    public List<RegistoNProcessado> getAllRegistoNProcessado() throws Exception {
        return new RepositoryRegistoNProcessado().getAll();
    }

    /**
     * @return the list of all Veiculo objects in RepositoryVeiculo
     * @throws Exception
     */
    public List<Veiculo> getAllVehicle() throws Exception {
        return new RepositoryVeiculo().getAll();
    }

    /**
     * @return the list of all ZonaVerde objects in RepositoryZonaVerde
     * @throws Exception
     */
    public List<ZonaVerde> getAllZonaVerde() throws Exception {
        return new RepositoryZonaVerde().getAll();
    }

    /**
     * @return the list of all Veiculo objects in the data base related to the Cliente object
     * with the Id passed as parameter
     * @param cId Cliente objects id
     * @throws Exception
     */
    public List<Veiculo> getAllVehiclesByClientNif(Integer cId) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            TypedQuery<Veiculo> qv = em.createQuery("select v from Veiculo as v where v.nif.id = ?1", Veiculo.class);
            List<Veiculo> lv = qv.setParameter(1, cId).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();
            ds.validateWork();
            return lv;

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    //------------------------------------ Find ------------------------------------

    /**
     * @return the found Cliente object with the id passed as parameter or null if it doesn't find any
     * @param Id Cliente objects id
     * @throws Exception
     */
    public Cliente findClient(Integer Id) throws Exception  {
        return new MapperCliente().read(Id);
    }

    /**
     * @return the found ClienteInstitucional object with the id passed as parameter or null if it doesn't find any
     * @param Id ClienteInstitucional objects id
     * @throws Exception
     */
    public ClienteInstitucional findInstitutionalClient(Integer Id) throws Exception  {
        return new MapperClienteInstitucional().read(Id);
    }

    /**
     * @return the found ClienteParticular object with the id passed as parameter or null if it doesn't find any
     * @param Id ClienteParticular objects id
     * @throws Exception
     */
    public ClienteParticular findParticularClient(Integer Id) throws Exception  {
        return new MapperClienteParticular().read(Id);
    }

    /**
     * @return the found Gps object with the id passed as parameter or null if it doesn't find any
     * @param Id Gps objects id
     * @throws Exception
     */
    public Gps findGps(Integer Id) throws Exception  {
        return new MapperGps().read(Id);
    }

    /**
     * @return the found Invalido object with the id passed as parameter or null if it doesn't find any
     * @param Id Invalido objects id
     * @throws Exception
     */
    public Invalido findInvalid(Integer Id) throws Exception  {
        return new MapperInvalido().read(Id);
    }

    /**
     * @return the found Processado object with the id passed as parameter or null if it doesn't find any
     * @param Id Processado objects id
     * @throws Exception
     */
    public Processado findProcessed(Integer Id) throws Exception  {
        return new MapperProcessado().read(Id);
    }

    /**
     * @return the found RegistoNProcessado object with the id passed as parameter or null if it doesn't find any
     * @param Id RegistoNProcessado objects id
     * @throws Exception
     */
    public RegistoNProcessado findNotProcessedRegister(Integer Id) throws Exception  {
        return new MapperRegistoNProcessado().read(Id);
    }

    /**
     * @return the found Veiculo object with the id passed as parameter or null if it doesn't find any
     * @param Id Veiculo objects id
     * @throws Exception
     */
    public Veiculo findVehicle(String Id) throws Exception  {
        return new MapperVeiculo().read(Id);
    }

    /**
     * @return the found ZonaVerde object with the id passed as parameter or null if it doesn't find any
     * @param Id ZonaVerde objects id
     * @throws Exception
     */
    public ZonaVerde findZonaVerde(ZonaverdeId Id) throws Exception  {
        return new MapperZonaVerde().read(Id);
    }

    //------------------------------------ Delete ------------------------------------

    /**
     * Deletes the Cliente object passed as parameter from the data base
     * @param c the Cliente object
     * @throws Exception
     */
    public void deleteClient(Cliente c) throws Exception {
        new MapperCliente().delete(c);
    }

    /**
     * Deletes the ClienteInstitucional object passed as parameter from the data base
     * @param ci the ClienteInstitucional object
     * @throws Exception
     */
    public void deleteInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().delete(ci);
    }

    /**
     * Deletes the ClienteParticular object passed as parameter from the data base
     * @param cp the ClienteParticular object
     * @throws Exception
     */
    public void deleteParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().delete(cp);
    }

    /**
     * Deletes the Gps object passed as parameter from the data base
     * @param gps the Gps object
     * @throws Exception
     */
    public void deleteGps(Gps gps) throws Exception {
        new MapperGps().delete(gps);
    }

    /**
     * Deletes the Invalido object passed as parameter from the data base
     * @param i the Invalido object
     * @throws Exception
     */
    public void deleteInvalid(Invalido i) throws Exception {
        new MapperInvalido().delete(i);
    }

    /**
     * Deletes the Processado object passed as parameter from the data base
     * @param p the Processado object
     * @throws Exception
     */
    public void deleteProcessed(Processado p) throws Exception {
        new MapperProcessado().delete(p);
    }

    /**
     * Deletes the RegistoNProcessado object passed as parameter from the data base
     * @param rnp the RegistoNProcessado object
     * @throws Exception
     */
    public void deleteNotProcessedRegister(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().delete(rnp);
    }

    /**
     * Deletes the Veiculo object passed as parameter from the data base
     * @param v the Veiculo object
     * @throws Exception
     */
    public void deleteVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().delete(v);
    }

    /**
     * Deletes the ZonaVerde object passed as parameter from the data base
     * @param zv the ZonaVerde object
     * @throws Exception
     */
    public void deleteZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().delete(zv);
    }

    //---------------------- delete by id ---------------------------------------------

    /**
     * Deletes the Cliente object identified by the id passed as parameter from the data base
     * @param Id Cliente objects id
     * @throws Exception
     */
    public void deleteClientById(Integer Id) throws Exception {
        Cliente c = new Cliente();
        c.setId(Id);
        new MapperCliente().delete(c);
    }

    /**
     * Deletes the ClienteInstitucional object identified by the id passed as parameter from the data base
     * @param Id ClienteInstitucional objects id
     * @throws Exception
     */
    public void deleteInstitutionalClientById(Integer Id) throws Exception {
        ClienteInstitucional ci = new ClienteInstitucional();
        ci.setId(Id);
        new MapperClienteInstitucional().delete(ci);
    }

    /**
     * Deletes the ClienteParticular object identified by the id passed as parameter from the data base
     * @param Id ClienteParticular objects id
     * @throws Exception
     */
    public void deleteParticularClientById(Integer Id) throws Exception {
        ClienteParticular cp = new ClienteParticular();
        cp.setId(Id);
        new MapperClienteParticular().delete(cp);
    }

    /**
     * Deletes the Gps object identified by the id passed as parameter from the data base
     * @param Id Gps objects id
     * @throws Exception
     */
    public void deleteGpsById(Integer Id) throws Exception {
        Gps gps = new Gps();
        gps.setId(Id);
        new MapperGps().delete(gps);
    }

    /**
     * Deletes the Invalido object identified by the id passed as parameter from the data base
     * @param Id Invalido objects id
     * @throws Exception
     */
    public void deleteInvalidById(Integer Id) throws Exception {
        Invalido i = new Invalido();
        i.setId(Id);
        new MapperInvalido().delete(i);
    }

    /**
     * Deletes the Processado object identified by the id passed as parameter from the data base
     * @param Id Processado objects id
     * @throws Exception
     */
    public void deleteProcessedById(Integer Id) throws Exception {
        Processado p = new Processado();
        p.setId(Id);
        new MapperProcessado().delete(p);
    }

    /**
     * Deletes the RegistoNProcessado object identified by the id passed as parameter from the data base
     * @param Id RegistoNProcessado objects id
     * @throws Exception
     */
    public void deleteNotProcessedRegisterById(Integer Id) throws Exception {
        RegistoNProcessado rnp = new RegistoNProcessado();
        rnp.setId(Id);
        new MapperRegistoNProcessado().delete(rnp);
    }

    /**
     * Deletes the Veiculo object identified by the id passed as parameter from the data base
     * @param Id Veiculo objects id
     * @throws Exception
     */
    public void deleteVehicleById(String Id) throws Exception {
        Veiculo v = new Veiculo();
        v.setId(Id);
        new MapperVeiculo().delete(v);
    }

    /**
     * Deletes the ZonaVerde object identified by the id passed as parameter from the data base
     * @param Id ZonaVerde objects id
     * @throws Exception
     */
    public void deleteZonaVerdeById(ZonaverdeId Id) throws Exception {
        ZonaVerde zv = new ZonaVerde();
        zv.setId(Id);
        new MapperZonaVerde().delete(zv);
    }

    //------------------------------------ Update ------------------------------------

    /**
     * Updates the ZonaVerde object passed as parameter in the data base
     * @param c the ZonaVerde object
     * @throws Exception
     */
    public void updateClient(Cliente c) throws Exception {
        new MapperCliente().update(c);
    }

    /**
     * Updates the ClienteInstitucional object passed as parameter in the data base
     * @param ci the ClienteInstitucional object
     * @throws Exception
     */
    public void updateInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().update(ci);
    }

    /**
     * Updates the ClienteParticular object passed as parameter in the data base
     * @param cp the ClienteParticular object
     * @throws Exception
     */
    public void updateParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().update(cp);
    }

    /**
     * Updates the Gps object passed as parameter in the data base
     * @param gps the Gps object
     * @throws Exception
     */
    public void updateGps(Gps gps) throws Exception {
        new MapperGps().update(gps);
    }

    /**
     * Updates the Invalido object passed as parameter in the data base
     * @param i the Invalido object
     * @throws Exception
     */
    public void updateInvalid(Invalido i) throws Exception {
        new MapperInvalido().update(i);
    }

    /**
     * Updates the Processado object passed as parameter in the data base
     * @param p the Processado object
     * @throws Exception
     */
    public void updateProcessed(Processado p) throws Exception {
        new MapperProcessado().update(p);
    }

    /**
     * Updates the RegistoNProcessado object passed as parameter in the data base
     * @param rnp the RegistoNProcessado object
     * @throws Exception
     */
    public void updateNotProcessedRegister(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().update(rnp);
    }

    /**
     * Updates the Veiculo object passed as parameter in the data base
     * @param v the Veiculo object
     * @throws Exception
     */
    public void updateVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().update(v);
    }

    /**
     * Updates the ZonaVerde object passed as parameter in the data base
     * @param zv the ZonaVerde object
     * @throws Exception
     */
    public void updateZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().update(zv);
    }

    //------------------------------------ Insert ------------------------------------

    /**
     * Inserts the Cliente object passed as parameter in the data base
     * @param c the Cliente object
     * @throws Exception
     */
    public void insertClient(Cliente c) throws Exception {
        new MapperCliente().create(c);
    }

    /**
     * Inserts the ClienteInstitucional object passed as parameter in the data base
     * @param ci the ClienteInstitucional object
     * @throws Exception
     */
    public void insertInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().create(ci);
    }

    /**
     * Inserts the ClienteParticular object passed as parameter in the data base
     * @param cp the ClienteParticular object
     * @throws Exception
     */
    public void insertParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().create(cp);
    }

    /**
     * Inserts the Gps object passed as parameter in the data base
     * @param gps the Gps object
     * @throws Exception
     */
    public void insertGps(Gps gps) throws Exception {
        new MapperGps().create(gps);
    }

    /**
     * Inserts the Invalido object passed as parameter in the data base
     * @param i the Invalido object
     * @throws Exception
     */
    public void insertInvalid(Invalido i) throws Exception {
        new MapperInvalido().create(i);
    }

    /**
     * Inserts the Processado object passed as parameter in the data base
     * @param p the Processado object
     * @throws Exception
     */
    public void insertProcessed(Processado p) throws Exception {
        new MapperProcessado().create(p);
    }

    /**
     * Inserts the RegistoNProcessado object passed as parameter in the data base
     * @param rnp the RegistoNProcessado object
     * @throws Exception
     */
    public void insertNotProcessed(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().create(rnp);
    }

    /**
     * Inserts the Veiculo object passed as parameter in the data base
     * @param v the Veiculo object
     * @throws Exception
     */
    public void insertVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().create(v);
    }

    /**
     * Inserts the ZonaVerde object passed as parameter in the data base
     * @param zv the ZonaVerde object
     * @throws Exception
     */
    public void insertZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().create(zv);
    }
}
