/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Ocenki;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;


public class OcenkiService extends AbstractService<Ocenki>{
    

    public OcenkiService() {
    }

    public OcenkiService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Ocenki entity) throws SQLException {
        try{
            String query = "insert into ocenki values"
                    + "(nextval('seq_ocenka'),'" + entity.getOcenki() + "',"
                    +entity.getId_attestacii()+","
                    + entity.getId_zachetki() +");";
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<Ocenki> all() throws SQLException {
        List<Ocenki> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select * from ocenki");
            while(rs.next()){
                Ocenki entity = new Ocenki();
                entity.setId(rs.getLong("id_ocenki"));
                entity.setOcenki(rs.getString("ocenka"));
                entity.setId_attestacii(rs.getLong("id_attestacii"));
                if (rs.wasNull()) {
                    entity.setId_attestacii(null);
                }
                entity.setId_zachetki(rs.getLong("id_zachetki"));
                if (rs.wasNull()) {
                    entity.setId_zachetki(null);
                }
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Ocenki entity) throws SQLException {
        try{
            String query = "delete from ocenki where id_ocenki = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Ocenki entity) throws SQLException {
        try{
            String query = "update ocenki set ocenka = '" + entity.getOcenki() + "',"
                    + "id_attestacii = " + entity.getId_attestacii() + ","
                    + "id_zachetki = " + entity.getId_zachetki() + " "
                    + "where id_ocenki = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    
}
