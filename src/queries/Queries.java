
package queries;

import containers.FirstQueryContainer;
import containers.SecondQueryContainer;
import containers.ThirdQueryContainer;
import entities.IEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.DbManager;


public class Queries {
    private DbManager dbManager;

    public Queries() {
    }

    public Queries(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }
    
    public List<IEntity> queryFirst() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = "select familia,imia,otchectvo,id_zachetki " +
                    "from student " +
                    "where id_group=10 " +
                    "order by familia asc;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                FirstQueryContainer container = new FirstQueryContainer();
                container.setFamilia(rs.getString("familia"));
                container.setImia(rs.getString("imia"));
                container.setOtchectvo(rs.getString("otchectvo"));
                container.setId_zachetki(Long.parseLong(rs.getString("id_zachetki")));
                
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
    
    public List<IEntity> querySecond() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = " select nazvanie,count(*)"+
                    "from student "+
                    "join groups "+
                    "on student.id_group = groups.id_group "+
                    "group by nazvanie "+
                    "order by nazvanie desc ";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                SecondQueryContainer container = new SecondQueryContainer();
                container.setNazvanie(rs.getString("nazvanie"));
                container.setCount(Long.parseLong(rs.getString("count")));
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
    
    public List<IEntity> queryThird() throws SQLException{
        List<IEntity> fqContainers = null;
        try {
            fqContainers = new ArrayList<>();
            String query = "select familia,imia,otchectvo\n" +
                    "from student\n" +
                    "where id_zachetki in (\n" +
                    "select id_zachetki\n" +
                    "from ocenki\n" +
                    "where ocenka='zachet' or ocenka='horosho'or\n" +
                    "ocenka='otlich')\n" +
                    "GROUP BY familia,imia,otchectvo ;";
            ResultSet rs = dbManager.executeQuery(query);
            while(rs.next()){
                ThirdQueryContainer container = new ThirdQueryContainer();
                container.setFamilia(rs.getString("familia"));
                container.setImia(rs.getString("imia"));
                container.setOtchestvo(rs.getString("otchectvo"));
                
                fqContainers.add(container);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return fqContainers;
    }
}
