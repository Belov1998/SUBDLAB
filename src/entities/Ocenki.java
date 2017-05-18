
package entities;

import java.sql.Date;


public class Ocenki implements IEntity{

    public long getId() {
        return id;
    }

    public String getOcenki() {
        return ocenki;
    }

    public Long getId_attestacii() {
        return id_attestacii;
    }

    public Long getId_zachetki() {
        return id_zachetki;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    public void setOcenki(String ocenki) {
        this.ocenki = ocenki;
    }

    public void setId_attestacii(Long id_attestacii) {
        this.id_attestacii = id_attestacii;
    }

    public void setId_zachetki(Long id_zachetki) {
        this.id_zachetki = id_zachetki;
    }

    
    private long id;
    private String ocenki;
    private Long id_attestacii;
    private Long id_zachetki;
    
    
    public Ocenki(){}

    public Ocenki(long id, Date date_assessment, String field_assessment, Long id_student, Long id_subject, Long id_teacher, Long id_test_type) {
        this.id = id;
        this.ocenki = field_assessment;
        this.id_attestacii = id_student;
        this.id_zachetki = id_subject;
    }

    
    
    @Override
    public String toString(){
        return  ocenki;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","ocenka","id_attestacii","id_zachetki"};
    }
    
    @Override
    public String[] getRow(){
        return new String[] {id+"",  ocenki,
                    id_attestacii+"",id_zachetki+""};
    }
}
