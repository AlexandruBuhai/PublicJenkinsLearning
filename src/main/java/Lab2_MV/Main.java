package Lab2_MV;

import Lab2_MV.Exceptions.*;
import Lab2_MV.Repository.XMLFileRepository.NotaXMLRepo;
import Lab2_MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_MV.Service.XMLFileService.NotaXMLService;
import Lab2_MV.Service.XMLFileService.StudentXMLService;
import Lab2_MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_MV.Validator.*;
import Lab2_MV.UI.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}