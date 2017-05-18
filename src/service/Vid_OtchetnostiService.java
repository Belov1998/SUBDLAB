/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Groups;
import entities.Vid_Otchetnosti;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;


public class Vid_OtchetnostiService extends AbstractService<Vid_Otchetnosti>{

    public Vid_OtchetnostiService() {
    }

    public Vid_OtchetnostiService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Vid_Otchetnosti entity) throws SQLException {
        try{
            String query = "insert into vid_otchetnosti values"
                + entity.getId()+",'" + entity.getNazvanie() + "');";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Vid_Otchetnosti> all() throws SQLException {
        List<Vid_Otchetnosti> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from vid_otchetnosti");
            while(rs.next()){
                Vid_Otchetnosti entity = new Vid_Otchetnosti();
                entity.setId(rs.getLong("id_vida_otch"));
                entity.setNazvanie(rs.getString("nazvanie"));
                
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Vid_Otchetnosti entity) throws SQLException {
        try{
            String query = "delete from vid_otchetnosti where id_vida_otch = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Vid_Otchetnosti entity) throws SQLException {
        try{
            String query = "update vid_otchetnosti set nazvanie = '" + entity.getNazvanie()+ "' "
                + "where id_vida_otch = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
