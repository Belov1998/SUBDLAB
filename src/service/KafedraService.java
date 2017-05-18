/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Kafedra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class KafedraService extends AbstractService<Kafedra>{

    public KafedraService() {
    }

    public KafedraService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Kafedra entity) throws SQLException {
        try{
            String query = "insert into kafedra values"
                + "(nextval('seq_kafedra'),'" + entity.getNazvanie() + "','"
                + entity.getFakultet() + "');";
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Kafedra> all() throws SQLException {
        List<Kafedra> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from kafedra");
            while(rs.next()){
                Kafedra entity = new Kafedra();
                entity.setId(rs.getLong("id_kaf"));
                entity.setNazvanie(rs.getString("nazvanie"));
                entity.setFakultet(rs.getString("fakultet"));
                entities.add(entity);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Kafedra entity) throws SQLException {
        try{
            String query = "delete from kafedra where id_kaf = " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Kafedra entity) throws SQLException {
        try{
            String query = "update kafedra set nazvanie = '" + entity.getNazvanie()+ "',"
                + "fakultet = '" + entity.getFakultet() + "' "
                + "where id_kaf= " + entity.getId();
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

}
