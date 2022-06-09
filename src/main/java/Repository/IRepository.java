package Repository;

import exc1.a.K;

import java.util.*;

public interface IRepository<Entity, Key> {
    List<Entity> getAll() throws Exception;
    Entity find(Key k) throws Exception;

    void add(Entity entity) throws Exception;
    void delete(Entity entity) throws Exception;
    void save(Entity entity) throws Exception;
}
