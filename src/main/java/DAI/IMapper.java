package DAI;

public interface IMapper<Table, TId> {
    void create(Table e) throws Exception;
    Table read(TId id) throws Exception;
    void update(Table e) throws Exception;
    void delete(Table e) throws Exception;
}
