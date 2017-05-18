
package entities;


public class Prepodavatel implements IEntity{
    private long id;
    private String familia;
    private String imia;
    private String otchestvo;
    private String dolgnost;
    
    
    public Prepodavatel(){}

    public Prepodavatel(long id, String familia, String imia, String otchestvo, String dolgnost) {
        this.id = id;
        this.familia = familia;
        this.imia = imia;
        this.otchestvo = otchestvo;
        this.dolgnost = dolgnost;
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

    public String getDolgnost() {
        return dolgnost;
    }

    public void setDolgnost(String dolgnost) {
        this.dolgnost = dolgnost;
    }

   
    
    @Override
    public String toString(){
        return familia + " " + imia + " " +
                otchestvo + " " + dolgnost ;
    }
    
    @Override
    public String[] getHeader(){
        return new String[] {"id","familia","imia","otchestvo","dolgnost"};
    }
    @Override
    public String[] getRow(){
        return new String[] {id+"",familia,imia,otchestvo,dolgnost};
    }
}
