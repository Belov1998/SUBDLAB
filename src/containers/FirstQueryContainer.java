/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;


public class FirstQueryContainer implements IEntity{
    private String familia;
    private String imia;
    private String otchectvo;
    private long id_zachetki;
    public FirstQueryContainer() {
    }

    public FirstQueryContainer(String familia, String imia, String otchectvo) {
        this.familia = familia;
        this.imia = imia;
        this.otchectvo = otchectvo;
        
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getImia() {
        return imia;
    }

    public void setImia(String imia) {
        this.imia = imia;
    }

    public String getOtchectvo() {
        return otchectvo;
    }

    public void setOtchectvo(String otchectvo) {
        this.otchectvo = otchectvo;
    }
    
    public long getId_zachetki() {
        return id_zachetki;
    }

    public void setId_zachetki(long id_zachetki) {
        this.id_zachetki = id_zachetki;
    }
    
    public String getFullInfo(){
        return familia + "\t" + imia + "\t" + otchectvo+"\t"+id_zachetki;
    }

    @Override
    public String[] getHeader() {
        return new String[] {"familia","imia","otchectvo","id_zachetki"};
    }

    @Override
    public String[] getRow() {
        return new String[] {familia , imia , otchectvo,id_zachetki+""};
    }
}
