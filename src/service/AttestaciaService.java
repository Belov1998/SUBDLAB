/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Attestacia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class AttestaciaService extends AbstractService<Attestacia>{


    public AttestaciaService() {
    }

    public AttestaciaService(DbManager dbManager) {
        super(dbManager);
    }
    
    @Override
    public void add(Attestacia entity) throws SQLException {
        try{
            String query = "insert into attestacia values"
                + "(nextval('seq_attestacia'),"+entity.getSemestr()+ ","
                + entity.getNapravlenie()+","+"'" + entity.getPredmet() + "',"
                + entity.getId_vida_otch() + ","
                + entity.getId_prepodavatel() + ");";
        dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public List<Attestacia> all() throws SQLException {
        List<Attestacia> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = dbManager.executeQuery("select id_attestacii,semestr,napravlenie,predmet,attestacia.id_vida_otch,attestacia.id_prepodavatel, familia, imia, otchectvo, nazvanie "+
                    "from attestacia, prepodavatel, vid_otchetnosti "+
                    " where attestacia.id_vida_otch=vid_otchetnosti.id_vida_otch and attestacia.id_prepodavatel=prepodavatel.id_prepodavatel");
            while(rs.next()){
                Attestacia entity = new Attestacia();
                entity.setId(rs.getLong("id_attestacii"));
                entity.setSemestr(rs.getInt("semestr"));
                entity.setNapravlenie(rs.getInt("napravlenie"));
                entity.setPredmet(rs.getString("predmet"));
                entity.setId_vida_otch(rs.getInt("id_vida_otch"));
                entity.setId_prepodavatel(rs.getInt("id_prepodavatel"));
                entity.setVida_otch(rs.getString("nazvanie"));
                entity.setPrepodavatel(rs.getString("familia")+" "+rs.getString("imia")+" "+rs.getString("otchectvo"));
                entities.add(entity);
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }

    @Override
    public void delete(Attestacia entity) throws SQLException {
        try{
            String query = "delete from attestacia where id_attestacii = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }

    @Override
    public void update(Attestacia entity) throws SQLException {
        try{
            String query = "update attestacia set semestr = " + entity.getSemestr()+ ","
                + "napravlenie = " + entity.getNapravlenie() + ","
                + "predmet = '" + entity.getPredmet() + "',"
                + "id_vida_otch = " + entity.getId_vida_otch() + ", "
                    +"id_prepodavatel= "+entity.getId_prepodavatel()+" "
                + "where id_attestacii = " + entity.getId();
            dbManager.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
}
