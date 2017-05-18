/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Groups;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class GroupService extends AbstractService<Groups>{

    public GroupService() {
    }

    public GroupService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Groups entity) throws SQLException {
        try{
            String query = "insert into groups values"
                + "(nextval('seq_grupp'),'" + entity.getNazvanie() + "',"
                + entity.getPotok() + ","
                +entity.getNapravlenie()+","
                + entity.getId_kaf() + ");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Groups> all() throws SQLException {
        List<Groups> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select groups.id_group, "+
                    "groups.nazvanie, "+ 
                    "groups.potok, "+
                    "groups.napravlenie, "+
                    "groups.id_kaf, "+
                    "kafedra.nazvanie as kaf"+
                    " from groups join kafedra on groups.id_kaf=kafedra.id_kaf");
            while(rs.next()){
                Groups entity = new Groups();
                entity.setId(rs.getLong("id_group"));
                entity.setNazvanie(rs.getString("nazvanie"));
                entity.setPotok(rs.getLong("potok"));
                entity.setNapravlenie(rs.getLong("napravlenie"));
                entity.setId_kaf(rs.getLong("id_kaf"));
                entity.setNazv_kaf(rs.getString("kaf"));
                if (rs.wasNull()) {
                    entity.setId_kaf(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Groups entity) throws SQLException {
        try{
            String query = "delete from groups where id_group = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Groups entity) throws SQLException {
        try{
            String query = "update groups set nazvanie = '" + entity.getNazvanie()+ "',"
                + "potok = " + entity.getPotok() + ","
                + "napravlenie"+entity.getNapravlenie()+"'"
                + "id_kaf = " + entity.getId_kaf() + " "
                + "where id_group = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    

}
