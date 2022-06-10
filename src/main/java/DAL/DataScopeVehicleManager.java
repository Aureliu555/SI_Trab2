package DAL;

import DAO.Mappers.MapperAlarme;
import DAO.Repositories.RepositoryAlarme;
import model.Alarme;

import java.util.List;

public class DataScopeVehicleManager extends AbstractDataScope implements AutoCloseable {
    public DataScopeVehicleManager() throws Exception{
        super();
    }

    public List<Alarme> getAllAlarms() throws Exception {
        return new RepositoryAlarme().getAll();
    }

    public Alarme findStudent(Integer Id) throws Exception  {
        return new MapperAlarme().read(Id);
    }

    public void deleteStudent(Alarme a) throws Exception {
        new MapperAlarme().delete(a);
    }

    public void deleteAlarmeByKey(Integer Id) throws Exception {
        Alarme a = new Alarme();
        a.setId(Id);
        new MapperAlarme().delete(a);
    }

    public void updateStudent(Alarme a) throws Exception {
        new MapperAlarme().update(a);
    }

    public void insertAlarme(Alarme a) throws Exception {
        new MapperAlarme().create(a);
    }
}
