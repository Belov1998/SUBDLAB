
package service;


import entities.Prepodavatel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class PrepodavatelService extends AbstractService<Prepodavatel>{

    public PrepodavatelService() {
    }

    public PrepodavatelService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Prepodavatel entity) throws SQLException {
        try{
            String query = "insert into prepodavatel values"
                + "(nextval('seq_prepodavatel'),'" + entity.getFamilia() + "','"
                + entity.getImia() + "','"
                + entity.getOtchestvo() + "','"
                + entity.getDolgnost() + "');";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Prepodavatel> all() throws SQLException {
        List<Prepodavatel> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from prepodavatel");
            while(rs.next()){
                Prepodavatel entity = new Prepodavatel();
                entity.setId(rs.getLong("id_prepodavatel"));
                entity.setFamilia(rs.getString("familia"));
                entity.setImia(rs.getString("imia"));
                entity.setOtchestvo(rs.getString("otchectvo"));
                entity.setDolgnost(rs.getString("dolgnost"));
                entities.add(entity);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Prepodavatel entity) throws SQLException {
        try{
            String query = "delete from prepodavatel where id_prepodavatel = " + entity.getId();
            dbManager.executeQuery(query);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Prepodavatel entity) throws SQLException {
        try{
            String query = "update prepodavatel set familia= '" + entity.getFamilia() + "'," 
                + "imia = '" + entity.getImia() + "',"
                + "otchectvo = '" + entity.getOtchestvo() + "' "
                + "where id_prepodavatel = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    
}
