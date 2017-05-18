
package models;

import service.OcenkiService;
import service.StudentService;
import service.AttestaciaService;
import service.PrepodavatelService;
import service.Vid_OtchetnostiService;
import entities.Ocenki;
import entities.Student;
import entities.Attestacia;
import entities.Prepodavatel;
import entities.Vid_Otchetnosti;
import java.sql.SQLException;
import java.util.List;
import manager.DbManager;


public class MainInfoModel {
    private OcenkiService assessmentS = new OcenkiService();
    private StudentService studentS = new StudentService();
    private PrepodavatelService teacherS = new PrepodavatelService();
    private Vid_OtchetnostiService testTypeS = new Vid_OtchetnostiService();
    private AttestaciaService subjectS = new AttestaciaService();
    private DbManager dbManager = null;

    public MainInfoModel() {
    }

    public MainInfoModel(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
        assessmentS.setManager(dbManager);
        studentS.setManager(dbManager);
        teacherS.setManager(dbManager);
        testTypeS.setManager(dbManager);
        subjectS.setManager(dbManager);
       // kaferaS.setManager(dbManager);
    }
    
    public void add(Ocenki entity) throws SQLException{
        assessmentS.add(entity);
    }
    
    public void update(Ocenki entity) throws SQLException{
        assessmentS.update(entity);
    }
    
    public void delete(Ocenki entity) throws SQLException{
        assessmentS.delete(entity);
    }
    
    public List<Prepodavatel> getTeachers() throws SQLException{
        return teacherS.all();
    }
    
    public List<Student> getStudents() throws SQLException{
        return studentS.all();
    }
    
    public List<Vid_Otchetnosti> getTestTypes() throws SQLException{
        return testTypeS.all();
    }
    
    public List<Attestacia> getSubjects() throws SQLException{
        return subjectS.all();
    }
    
    public List<Ocenki> getAssessments() throws SQLException{
        return assessmentS.all();
    }
    
   

}
