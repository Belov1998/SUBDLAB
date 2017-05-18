/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class Vid_Otchetnosti implements IEntity{
    private long id;
    private String nazvanie;

    public Vid_Otchetnosti(){}
    
    public Vid_Otchetnosti(long id, String nazvanie) {
        this.id = id;
        this.nazvanie = nazvanie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }
    
    @Override
    public String toString(){
        return nazvanie;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","nazvanie"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",nazvanie};
    }
}
