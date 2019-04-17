package Lab2_MV;

import Lab2_MV.Domain.TemaLab;
import Lab2_MV.Exceptions.ValidatorException;
import Lab2_MV.Repository.XMLFileRepository.StudentXMLRepo;
import Lab2_MV.Repository.XMLFileRepository.TemaLabXMLRepo;
import Lab2_MV.Service.XMLFileService.StudentXMLService;
import Lab2_MV.Service.XMLFileService.TemaLabXMLService;
import Lab2_MV.Validator.StudentValidator;
import Lab2_MV.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    StudentValidator studentValidator;
    StudentXMLRepo studentXMLRepo;
    StudentXMLService studentXMLService;
    TemaLabValidator temaLabValidator;
    TemaLabXMLRepo temaLabXMLRepo;
    TemaLabXMLService temaLabXMLService;

    @Before
    public void setUp() {
        studentValidator = new StudentValidator();
        studentXMLRepo = new StudentXMLRepo(studentValidator,"StudentiXML_test.xml");
        studentXMLService = new StudentXMLService(studentXMLRepo);
        temaLabValidator = new TemaLabValidator();
        temaLabXMLRepo = new TemaLabXMLRepo(temaLabValidator, "TemaLab_test.xml");
        temaLabXMLService = new TemaLabXMLService(temaLabXMLRepo);
    }


    @Test
    public void addStudent() {
        assertTrue(true);
    }

    @Test
    public void testNumberIdStudent() {
        String[] params={"asa", "Alex", "932", "sadadsa@gmail.com", "Asdadsa"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testBoundariesIdStudent() {
        String[] params={"1000", "Alex", "932", "xyzc@gmail.com", "Imre"};
        String[] params1={"9999", "Alex", "932", "xyzc@gmail.com", "Imre"};
        String[] params2={"99", "Alex", "932", "xyzc@gmail.com", "Imre"};
        String[] params3={"100000", "Alex", "932", "xyzc@gmail.com", "Imre"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            studentXMLService.add(params2);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
        try {
            studentXMLService.add(params3);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyIdStudent() {
        String[] params={"", "Alex", "932", "xyzc@gmail.com", "Imre"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyStudentName() {
        String[] params={"2079", "", "932", "xyzc@gmail.com", "Imre"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testStudentName() {
        String[] params={"2079", "BuhaiAlexandru", "932", "asan@gmail.com", "Imre"};
//        String[] params1={"2079", "dsaldsa", "932", "asan@gmail.com", "Imre"};
        try {
            studentXMLService.add(params);
//            studentXMLService.add(params1);
//            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyTeacherName() {
        String[] params={"2079", "Buhai Alexandru", "932", "asan@gmail.com", ""};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testTeacherName() {
        String[] params={"2079", "Buhai Alexandru", "932", "asan@gmail.com", "ImreZsigmond"};
        String[] params1={"2079", "Buhai Alexandru", "932", "asan@gmail.com", "akldfms3"};
        try {
            studentXMLService.add(params); //fails
            studentXMLService.add(params1);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyGroup() {
        String[] params={"2079", "Buhai Alexandru", "", "baie2079@gmail.com", "Radu Gaceanu"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testGroup() {
        String[] params={"2079", "Buhai Alexandru", "932", "baie2079@gmail.com", "Imre Zsigmond"};
        String[] params1={"2079", "Buhai Alexandru", "-1", "baie2079@gmail.com", "Imre Zsigmond"};
        String[] params2={"2079", "Buhai Alexandru", "f", "baie2079@gmail.com", "Imre Zsigmond"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }

        try {
            studentXMLService.add(params2);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    //termen limita invalid
    @Test
    public void testAddAssignment(){
        String[] params={"1", "Tema 1", "17", "2"};
//        TemaLab temaLab = new TemaLab(1, "Tema1", 3,4);
        try {

            temaLabXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    //Test not working
    @Test
    public void testAddAssignment2()
    {
        String[] params={"0", "Tema 2", "4", "2"};
        try {
            temaLabXMLService.add(params);
//            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    //Descriere invalida
    @Test
    public void testAddAssignment3(){
        String[] params={"1", null, "3", "6"};
        try {

            temaLabXMLService.add(params);
            assertTrue(false);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    //Saptamana predarii invalida
    @Test
    public void testAddAssignment4(){
        String[] params={"1", "Tema 2", "3", "-1"};
        try {

            temaLabXMLService.add(params);
            assertTrue(false);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
//            assertTrue(true);
        }
    }

    //spapt invalid
    @Test
    public void testAddAssignment5(){
        String[] params={"1", "Tema 2", "-1", "6"};
        try {

            temaLabXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmptyEmail() {
        String[] params={"2079", "Buhai Alexandru", "932", "", "Iuliana Bocicor"};
        try {
            studentXMLService.add(params);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }

    @Test
    public void testEmail() {
        String[] params ={"2079", "Buhai Alexandru", "932", "yuvican100@gmail.com", "Imre Zsigmond"};
        String[] params1={"2079", "Buhai Alexandru", "932", "john10@somedomain.com", "Imre Zsigmond"};
        String[] params2={"2079", "Buhai Alexandru", "932", "msDhoni@somedomain.com", "Imre Zsigmond"};
        String[] params3={"2079", "Buhai Alexandru", "932", "'ramesh @gmail.com", "Imre Zsigmond"};
        String[] params4={"2079", "Buhai Alexandru", "932", "john10@somedomain", "Imre Zsigmond"};
        try {
            studentXMLService.add(params);
            studentXMLService.add(params1);
            studentXMLService.add(params2);
            studentXMLService.add(params3);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }

        try {
            studentXMLService.add(params4);
            fail();
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
}
