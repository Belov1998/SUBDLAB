
package containers;

import entities.IEntity;

public class ThirdQueryContainer implements IEntity{
    private String familia;
    private String imia;
    private String otchestvo;

    public ThirdQueryContainer() {
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

   
    public String getFullInfo(){
        return familia + "\t" + imia + "\t" + otchestvo ;
    }
    
    @Override
    public String[] getHeader() {
        return new String[] {"surname", "first_name", "patronymic"};
    }

    @Override
    public String[] getRow() {
        return new String[] {familia , imia , otchestvo};
    }
}
