package DAL;

import DAO.Mappers.MapperCliente;
import DAO.Repositories.RepositoryAlarme;
import DAO.Repositories.RepositoryCliente;
import DAO.Repositories.RepositoryProcessado;
import DAO.Repositories.RepositoryRegistoNProcessado;
import model.Alarme;
import model.*;

import java.util.List;

public class DataScopeVehicleManager extends AbstractDataScope implements AutoCloseable {
    public DataScopeVehicleManager() throws Exception{
        super();
    }

    public List<Cliente> getAllClients() throws Exception {
        return new RepositoryCliente().getAll();
    }

    public List<RegistoNProcessado> getAllRegistoNProcessado() throws Exception {
        return new RepositoryRegistoNProcessado().getAll();
    }

    public List<Processado> getAllProcessado() throws Exception {
        return new RepositoryProcessado().getAll();
    }

    public Cliente findClient(Integer Id) throws Exception  {
        return new MapperCliente().read(Id);
    }

    public void deleteClient(Cliente c) throws Exception {
        new MapperCliente().delete(c);
    }

    public void deleteClientById(Integer Id) throws Exception {
        Cliente c = new Cliente();
        c.setId(Id);
        new MapperCliente().delete(c);
    }

    public void updateClient(Cliente c) throws Exception {
        new MapperCliente().update(c);
    }

    public void insertClient(Cliente c) throws Exception {
        new MapperCliente().create(c);
    }
}
