
package manager;

import entities.IEntity;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class TableTool {
    public static void FillTable(DefaultTableModel tableModel, List<IEntity> entities){
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        
        String[] headers = entities.get(0).getHeader();
        for(int i = 0; i < headers.length; i++){
            tableModel.addColumn(headers[i]);
        }
        
        String[] row = null;
        
        for(IEntity e : entities){
            row = e.getRow();
            tableModel.addRow(e.getRow());
        }
    }
}
