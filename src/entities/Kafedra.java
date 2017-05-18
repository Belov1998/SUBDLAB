
package entities;


public class Kafedra implements IEntity{
    private long id;
    private String nazvanie;
    private String fakultet;
    
    public Kafedra(){}

    public Kafedra(long id, String nazvanie, String fakultet) {
        this.id = id;
        this.nazvanie = nazvanie;
        this.fakultet = fakultet;
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

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }
    
    @Override
    public String toString(){
        return nazvanie + " " + fakultet;
    }

    @Override
    public String[] getHeader(){
        return new String[] {"id","nazvanie","fakultet"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"", nazvanie, fakultet};
    }
}
