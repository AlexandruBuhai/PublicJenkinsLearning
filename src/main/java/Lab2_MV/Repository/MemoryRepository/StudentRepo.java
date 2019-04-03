package Lab2_MV.Repository.MemoryRepository;
import Lab2_MV.Validator.IValidator;
import Lab2_MV.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}