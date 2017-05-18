/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import entities.IEntity;

public class SecondQueryContainer implements IEntity{
    private String nazvanie;
    private long count;

    public SecondQueryContainer() {
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    
  
    
    public String getFullInfo(){
        return nazvanie + "\t" + count ;
    }
    
    @Override
    public String[] getHeader() {
        return new String[] {"nazvanie", "count"};
    }

    @Override
    public String[] getRow() {
        return new String[] {nazvanie , count+"" };
    }
}
