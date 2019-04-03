package Lab2_MV.Repository.MemoryRepository;
import Lab2_MV.Validator.IValidator;
import Lab2_MV.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}