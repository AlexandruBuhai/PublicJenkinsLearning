package Lab2_MV.Validator;
import Lab2_MV.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}