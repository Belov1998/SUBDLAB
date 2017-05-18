
package entities;


public class Groups implements IEntity{

    public Groups(long id, String nazvanie, Long potok, Long napravlenie, Long id_kaf,String nazv_kaf) {
        this.id = id;
        this.nazvanie = nazvanie;
        this.potok = potok;
        this.napravlenie = napravlenie;
        this.id_kaf = id_kaf;
        this.nazv_kaf=nazv_kaf;
    }
    private long id;
    private String nazvanie;
    private Long potok;
    private Long napravlenie;
    private Long id_kaf;
    private String nazv_kaf;

    public String getNazv_kaf() {
        return nazv_kaf;
    }

    public void setNazv_kaf(String nazv_kaf) {
        this.nazv_kaf = nazv_kaf;
    }
    
    public Groups(){}

    public Groups(long id, String name, String abbreviation, Long id_speciality) {
        this.id = id;
        this.nazvanie = name;
        this.id_kaf = id_speciality;
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
    public Long getPotok() {
        return potok;
    }

    public void setPotok(Long potok) {
        this.potok = potok;
    }

    public Long getNapravlenie() {
        return napravlenie;
    }

    public void setNapravlenie(Long napravlenie) {
        this.napravlenie = napravlenie;
    }
   

    public Long getId_kaf() {
        return id_kaf;
    }

    public void setId_kaf(Long id_kaf) {
        this.id_kaf = id_kaf;
    }
    
    @Override
    public String toString(){
        return nazvanie + " " + potok+" "+ napravlenie;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","nazvanie","potok","napravlenie","kaf"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", nazvanie,potok+"",napravlenie+"",nazv_kaf};
    }
}
