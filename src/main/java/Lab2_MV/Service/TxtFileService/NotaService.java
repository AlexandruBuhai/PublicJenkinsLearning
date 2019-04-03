package Lab2_MV.Service.TxtFileService;
import Lab2_MV.Domain.*;
import Lab2_MV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
