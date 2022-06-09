package DataMapper;

public interface IMapper<Table, TId> {
    void Create(Table e) throws Exception;
    Table Read(TId id) throws Exception;
    void Update(Table e) throws Exception;
    void Delete(Table e) throws Exception;
}
