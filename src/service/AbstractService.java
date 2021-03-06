
package service;

import java.sql.SQLException;
import java.util.List;
import manager.DbManager;


public abstract class AbstractService<T> {
    protected DbManager dbManager;

    public AbstractService() {
    }

    public AbstractService(DbManager dbManager) {
        this.dbManager = dbManager;
    }
            
    public abstract void add(T entity) throws SQLException;
    public abstract List<T> all() throws SQLException;
    public abstract void delete(T entity) throws SQLException;
    public abstract void update(T entity) throws SQLException;
    
    public void setManager(DbManager dbManager){
        this.dbManager = dbManager;
    }
}
