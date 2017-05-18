/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class Attestacia implements IEntity{
    private long id;
      private int semestr;
    private int napravlenie;
    private String predmet;
    private int id_vida_otch;
private int id_prepodavatel;
private String vida_otch;
private String prepodavatel;

    public String getVida_otch() {
        return vida_otch;
    }

    public void setVida_otch(String vida_otch) {
        this.vida_otch = vida_otch;
    }

    public String getPrepodavatel() {
        return prepodavatel;
    }

    public void setPrepodavatel(String prepodavatel) {
        this.prepodavatel = prepodavatel;
    }

public Attestacia(){}


    public Attestacia(long id, int semestr, int napravlenie, String predmet, int id_vida_otch, int id_prepodavatel, String vida_otch, String prepodavatel) {
        this.id = id;
        this.semestr = semestr;
        this.napravlenie = napravlenie;
        this.predmet = predmet;
        this.id_vida_otch = id_vida_otch;
        this.id_prepodavatel = id_prepodavatel;
        
        this.vida_otch = vida_otch;
        this.prepodavatel = prepodavatel;
        
    }
    
    
    

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

   public int getId_vida_otch() {
        return id_vida_otch;
    }

    public void setId_vida_otch(int id_vida_otch) {
        this.id_vida_otch = id_vida_otch;
    }

    public int getId_prepodavatel() {
        return id_prepodavatel;
    }

    public void setId_prepodavatel(int id_prepodavatel) {
        this.id_prepodavatel = id_prepodavatel;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public int getNapravlenie() {
        return napravlenie;
    }

    public void setNapravlenie(int napravlenie) {
        this.napravlenie = napravlenie;
    }
    
    @Override
    public String toString(){
        return semestr+" "+napravlenie+" "+predmet+" "+vida_otch+" "+prepodavatel;
    }
//////////////////////////
    @Override
    public String[] getHeader(){
        return new String[] {"id","semestr","napravlenie","predmet","vid_otch","prepodovatel"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",semestr+"",napravlenie+"",predmet,vida_otch,prepodavatel};
    }
}
