package DAL;

import DAO.Mappers.*;
import DAO.Repositories.*;
import exc1.a.G;
import model.*;

import java.util.List;

public class DataScopeVehicleManager extends AbstractDataScope implements AutoCloseable {
    public DataScopeVehicleManager() throws Exception{
        super();
    }

    //------------------------------------ GetAll ------------------------------------
    public List<Cliente> getAllClients() throws Exception {
        return new RepositoryCliente().getAll();
    }

    public List<ClienteInstitucional> getAllInstitutionalClients() throws Exception {
        return new RepositoryClienteInstitucional().getAll();
    }

    public List<ClienteParticular> getAllParticularClients() throws Exception {
        return new RepositoryClienteParticular().getAll();
    }

    public List<Gps> getAllGps() throws Exception {
        return new RepositoryGps().getAll();
    }

    public List<Invalido> getAllInvalids() throws Exception {
        return new RepositoryInvalido().getAll();
    }

    public List<Processado> getAllProcessado() throws Exception {
        return new RepositoryProcessado().getAll();
    }

    public List<RegistoNProcessado> getAllRegistoNProcessado() throws Exception {
        return new RepositoryRegistoNProcessado().getAll();
    }

    public List<Veiculo> getAllVehicle() throws Exception {
        return new RepositoryVeiculo().getAll();
    }

    public List<ZonaVerde> getAllZonaVerde() throws Exception {
        return new RepositoryZonaVerde().getAll();
    }

    //------------------------------------ Find ------------------------------------
    public Cliente findClient(Integer Id) throws Exception  {
        return new MapperCliente().read(Id);
    }

    public ClienteInstitucional findInstitutionalClient(Integer Id) throws Exception  {
        return new MapperClienteInstitucional().read(Id);
    }

    public ClienteParticular findParticularClient(Integer Id) throws Exception  {
        return new MapperClienteParticular().read(Id);
    }

    public Gps findGps(Integer Id) throws Exception  {
        return new MapperGps().read(Id);
    }

    public Invalido findInvalid(Integer Id) throws Exception  {
        return new MapperInvalido().read(Id);
    }

    public Processado findProcessed(Integer Id) throws Exception  {
        return new MapperProcessado().read(Id);
    }

    public RegistoNProcessado findNotProcessedRegister(Integer Id) throws Exception  {
        return new MapperRegistoNProcessado().read(Id);
    }

    public Veiculo findVehicle(String Id) throws Exception  {
        return new MapperVeiculo().read(Id);
    }

    public ZonaVerde findZonaVerde(ZonaverdeId Id) throws Exception  {
        return new MapperZonaVerde().read(Id);
    }

    //------------------------------------ Delete ------------------------------------
    public void deleteClient(Cliente c) throws Exception {
        new MapperCliente().delete(c);
    }

    public void deleteInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().delete(ci);
    }

    public void deleteParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().delete(cp);
    }

    public void deleteGps(Gps gps) throws Exception {
        new MapperGps().delete(gps);
    }

    public void deleteInvalid(Invalido i) throws Exception {
        new MapperInvalido().delete(i);
    }

    public void deleteProcessed(Processado p) throws Exception {
        new MapperProcessado().delete(p);
    }

    public void deleteNotProcessedRegister(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().delete(rnp);
    }

    public void deleteVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().delete(v);
    }

    public void deleteZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().delete(zv);
    }

    public void deleteClientById(Integer Id) throws Exception {
        Cliente c = new Cliente();
        c.setId(Id);
        new MapperCliente().delete(c);
    }

    public void deleteInstitutionalClientById(Integer Id) throws Exception {
        ClienteInstitucional ci = new ClienteInstitucional();
        ci.setId(Id);
        new MapperClienteInstitucional().delete(ci);
    }

    public void deleteParticularClientById(Integer Id) throws Exception {
        ClienteParticular cp = new ClienteParticular();
        cp.setId(Id);
        new MapperClienteParticular().delete(cp);
    }

    public void deleteGpsById(Integer Id) throws Exception {
        Gps gps = new Gps();
        gps.setId(Id);
        new MapperGps().delete(gps);
    }

    public void deleteInvalidById(Integer Id) throws Exception {
        Invalido i = new Invalido();
        i.setId(Id);
        new MapperInvalido().delete(i);
    }

    public void deleteProcessedById(Integer Id) throws Exception {
        Processado p = new Processado();
        p.setId(Id);
        new MapperProcessado().delete(p);
    }

    public void deleteNotProcessedRegisterById(Integer Id) throws Exception {
        RegistoNProcessado rnp = new RegistoNProcessado();
        rnp.setId(Id);
        new MapperRegistoNProcessado().delete(rnp);
    }

    public void deleteVehicleById(String Id) throws Exception {
        Veiculo v = new Veiculo();
        v.setId(Id);
        new MapperVeiculo().delete(v);
    }

    public void deleteZonaVerdeById(ZonaverdeId Id) throws Exception {
        ZonaVerde zv = new ZonaVerde();
        zv.setId(Id);
        new MapperZonaVerde().delete(zv);
    }

    //------------------------------------ Update ------------------------------------
    public void updateClient(Cliente c) throws Exception {
        new MapperCliente().update(c);
    }

    public void updateInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().update(ci);
    }

    public void updateParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().update(cp);
    }

    public void updateGps(Gps gps) throws Exception {
        new MapperGps().update(gps);
    }

    public void updateInvalid(Invalido i) throws Exception {
        new MapperInvalido().update(i);
    }

    public void updateProcessed(Processado p) throws Exception {
        new MapperProcessado().update(p);
    }

    public void updateNotProcessedRegister(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().update(rnp);
    }

    public void updateVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().update(v);
    }

    public void updateZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().update(zv);
    }

    //------------------------------------ Insert ------------------------------------
    public void insertClient(Cliente c) throws Exception {
        new MapperCliente().create(c);
    }

    public void insertInstitutionalClient(ClienteInstitucional ci) throws Exception {
        new MapperClienteInstitucional().create(ci);
    }

    public void insertParticularClient(ClienteParticular cp) throws Exception {
        new MapperClienteParticular().create(cp);
    }

    public void insertGps(Gps gps) throws Exception {
        new MapperGps().create(gps);
    }

    public void insertInvalid(Invalido i) throws Exception {
        new MapperInvalido().create(i);
    }

    public void insertProcessed(Processado p) throws Exception {
        new MapperProcessado().create(p);
    }

    public void insertNotProcessed(RegistoNProcessado rnp) throws Exception {
        new MapperRegistoNProcessado().create(rnp);
    }

    public void insertVehicle(Veiculo v) throws Exception {
        new MapperVeiculo().create(v);
    }

    public void insertZonaVerde(ZonaVerde zv) throws Exception {
        new MapperZonaVerde().create(zv);
    }
}
