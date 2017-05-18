
package service;

import entities.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class StudentService extends AbstractService<Student>{


    public StudentService() {
    }

    public StudentService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Student entity) throws SQLException {
        try{
            String query = "insert into student values"
                + "(nextval('seq_student'),'" + entity.getFamilia() + "','"
                + entity.getImia() + "','"
                + entity.getOtchestvo() + "',"
                + entity.getId_group() + ");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Student> all() throws SQLException {
        List<Student> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select id_zachetki, familia, imia, otchectvo, student.id_group, nazvanie from student join groups on student.id_group=groups.id_group");
            while(rs.next()){
                Student entity = new Student();
                entity.setId(rs.getLong("id_zachetki"));
                entity.setFamilia(rs.getString("familia"));
                entity.setImia(rs.getString("imia"));
                entity.setOtchestvo(rs.getString("otchectvo"));
                entity.setId_group(rs.getLong("id_group"));
                entity.setGroup(rs.getString("nazvanie"));
                if (rs.wasNull()) {
                    entity.setId_group(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Student entity) throws SQLException {
        try{
            String query = "delete from student where id_zachetki = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Student entity) throws SQLException {
        try{
            String query = "update student set familia = '" + entity.getFamilia() + "'," 
                + "imia = '" + entity.getImia() + "',"
                + "otchectvo = '" + entity.getOtchestvo() + "',"
                + "id_group = " + entity.getId_group() + " "
                + "where id_zachetki = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
