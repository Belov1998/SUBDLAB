/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class Student implements IEntity{
    private long id;
    private String familia;
    private String imia;
    private String otchestvo;
    private Long id_group;
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public Student(){}

    public Student(long id, String familia, String imia, String otchestvo,  Long id_group,  String group) {
        this.id = id;
        this.familia = familia;
        this.imia = imia;
        this.otchestvo = otchestvo;
        this.id_group = id_group;
        this.group=group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

   

    public Long getId_group() {
        return id_group;
    }

    public void setId_group(Long id_group) {
        this.id_group = id_group;
    }
    
    @Override
    public String toString(){
        return familia + " " + imia + " " +  otchestvo ;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","familia","imia","otchestvo","group"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",familia,imia,otchestvo,group};
    }
}
