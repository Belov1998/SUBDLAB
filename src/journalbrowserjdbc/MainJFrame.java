
package journalbrowserjdbc;

import containers.ConnectionContainer;
import service.KafedraService;
import service.GroupService;
import service.StudentService;
import service.AttestaciaService;
import service.PrepodavatelService;
import service.Vid_OtchetnostiService;
import entities.Ocenki;
import entities.Student;
import entities.Attestacia;
import entities.Prepodavatel;
import entities.Vid_Otchetnosti;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import manager.DbManager;
import models.MainInfoModel;


public  class  MainJFrame extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    private MainInfoModel model = new MainInfoModel();

    private ConnectionContainer conCont= new  ConnectionContainer("jdbc:postgresql://127.0.0.1:5432/decanat",
                                                    "postgres",
                                                    "");   
    private DbManager dbManager = new DbManager();
    private List<Ocenki> assessments = null;
    private List<Prepodavatel> teachers = null;
    private List<Student> students = null;
    private List<Vid_Otchetnosti> testTypes = null;
    private List<Attestacia> subjects = null;
    /**
     * Creates new form MainJFrame
     */
 
    
     public  MainJFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnQueries = new javax.swing.JButton();
        cbQueryId = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMain = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItemNewConnection = new javax.swing.JMenuItem();
        mItemDisconnect = new javax.swing.JMenuItem();
        mItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mItemFaculties = new javax.swing.JMenuItem();
        mItemGroups = new javax.swing.JMenuItem();
        mItemStudents = new javax.swing.JMenuItem();
        mItemTestTypes = new javax.swing.JMenuItem();
        mItemTeachers = new javax.swing.JMenuItem();
        mItemSubjects = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Статус подключения");

        btnQueries.setText("Запрос");
        btnQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueriesActionPerformed(evt);
            }
        });

        cbQueryId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Добавить");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnChange.setText("Изменить");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnDelete.setText("Удалить");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Обновить");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jTableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableMain);

        jMenu1.setText("Подключение");
        jMenu1.setName(""); // NOI18N

        mItemNewConnection.setText("Подключение");
        mItemNewConnection.setName(""); // NOI18N
        mItemNewConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNewConnectionActionPerformed(evt);
            }
        });
        jMenu1.add(mItemNewConnection);

        mItemDisconnect.setText("Отключить");
        mItemDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemDisconnectActionPerformed(evt);
            }
        });
        jMenu1.add(mItemDisconnect);

        mItemExit.setText("Выход");
        mItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(mItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Справочник");

        mItemFaculties.setText("Кафедры");
        mItemFaculties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemFacultiesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemFaculties);

        mItemGroups.setText("Группы");
        mItemGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemGroupsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemGroups);

        mItemStudents.setText("Студенты");
        mItemStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemStudentsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemStudents);

        mItemTestTypes.setText("Виды отчетностей");
        mItemTestTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemTestTypesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemTestTypes);

        mItemTeachers.setText("Преподователи");
        mItemTeachers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemTeachersActionPerformed(evt);
            }
        });
        jMenu2.add(mItemTeachers);

        mItemSubjects.setText("Аттестация");
        mItemSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSubjectsActionPerformed(evt);
            }
        });
        jMenu2.add(mItemSubjects);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQueries))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                        .addComponent(cbQueryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbQueryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnChange)
                            .addComponent(btnDelete)
                            .addComponent(btnRefresh))
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQueries, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        lblStatus.getAccessibleContext().setAccessibleName("lblStatus");

        pack();
    }// </editor-fold>//GEN-END:initComponents
                             
    private void mItemNewConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNewConnectionActionPerformed
        openConnectionFrame();
        dbManager.setConnectionContainer(conCont);
        dbManager.closeConnection();
        if(dbManager.openConnection()){
            lblStatus.setText("Подключено");
        }
        else{
            lblStatus.setText("Ошибка");
        }
    }//GEN-LAST:event_mItemNewConnectionActionPerformed
   public static MainJFrame mJf;
    private void mItemDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemDisconnectActionPerformed
        if(dbManager.closeConnection()){
            lblStatus.setText("Подключение закрыто");
        }
    }//GEN-LAST:event_mItemDisconnectActionPerformed

    private void mItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mItemExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        openConnectionFrame();
        dbManager.setConnectionContainer(conCont);
        if(dbManager.openConnection()){
            lblStatus.setText("Connected");
            model.setDbManager(dbManager);
        }
        else{
            lblStatus.setText("connection error");
        }
        
        jTableMain.setModel(tableModel);
        
        cbQueryId.removeAllItems();
        for(int i = 0; i < 3; i++){
            cbQueryId.addItem(i+"");
        }
        
        updateInfo();
    }//GEN-LAST:event_formWindowOpened

   public void updateInfo(){
        try{
        assessments = model.getAssessments();
        teachers = model.getTeachers();
        students = model.getStudents();
        subjects = model.getSubjects();
        testTypes = model.getTestTypes();
        }catch(Exception e){}
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        
        tableModel.addColumn("id");
                tableModel.addColumn("ocenka");

        tableModel.addColumn("student");
        tableModel.addColumn("predmet");
        tableModel.addColumn("prepodavatel");
        tableModel.addColumn("vd_otchetnositi");
        

        for(Ocenki e : assessments){
            tableModel.addRow(new String[]{e.getId()+"",e.getOcenki()+"",
                                            getStudentName(e.getId_zachetki()), getSubjectName(e.getId_attestacii()),
                                            getPrepodavatelName(e.getId_attestacii()),getVidName(e.getId_attestacii())});
        }

    }
    
    private String getSubjectName(long id){
        for(Attestacia e : subjects){
            if(e.getId() == id)
                return e.getPredmet();
        }
        return "";
    }
    
    private String getPrepodavatelName(long id){
       for(Attestacia a : subjects){
           if(a.getId() == id)
        for(Prepodavatel e : teachers){
            if(e.getId() == a.getId_prepodavatel())
                return e.getFamilia() + " " + e.getImia();
        }}
        return "";
    }
    
    private String getStudentName(long id){
        for(Student e : students){
            if(e.getId() == id)
                 return e.getFamilia() + " " + e.getImia();
        }
        return "";
    }
    
    private String getVidName(long id){
        for(Attestacia a : subjects){
           if(a.getId() == id)
        for(Vid_Otchetnosti e : testTypes){
            if(e.getId() == a.getId_vida_otch())
                return e.getNazvanie();
        }}
        return "";
    }

    
    private void mItemFacultiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemFacultiesActionPerformed
        KafedraEditJFrame assessmFrame = new KafedraEditJFrame();
        assessmFrame.setService(new KafedraService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemFacultiesActionPerformed

    private void mItemGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemGroupsActionPerformed
        GroupEditJFrame assessmFrame = new GroupEditJFrame();
       
        assessmFrame.setService(new GroupService(dbManager),new KafedraService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemGroupsActionPerformed

    private void mItemStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemStudentsActionPerformed
        StudentEditJFrame assessmFrame = new StudentEditJFrame();
        assessmFrame.setService(new StudentService(dbManager),new GroupService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemStudentsActionPerformed

    private void mItemTestTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemTestTypesActionPerformed
        Vid_otchetnostiEditJFrame assessmFrame = new Vid_otchetnostiEditJFrame();
        assessmFrame.setService(new Vid_OtchetnostiService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemTestTypesActionPerformed

    private void mItemTeachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemTeachersActionPerformed
        PrepodovatelEditJFrame assessmFrame = new PrepodovatelEditJFrame();
        assessmFrame.setService(new PrepodavatelService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemTeachersActionPerformed

    private void mItemSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSubjectsActionPerformed
        AttestaciaEditJFrame assessmFrame = new AttestaciaEditJFrame();
        assessmFrame.setService(new AttestaciaService(dbManager),new PrepodavatelService(dbManager),new Vid_OtchetnostiService(dbManager));
        assessmFrame.setVisible(true);
        assessmFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mItemSubjectsActionPerformed

    private void btnQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueriesActionPerformed
        QueriesJFrame qF = new QueriesJFrame();
        qF.setDbManager(dbManager);
        qF.setId_query(cbQueryId.getSelectedIndex());
        qF.setVisible(true);
        qF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_btnQueriesActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddMainInfoJDialog ami = new AddMainInfoJDialog();
        ami.setDbManager(dbManager);
        ami.setVisible(true);
        ami.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        ChangeMainInfoJDialog ami = new ChangeMainInfoJDialog();
        ami.setDbManager(dbManager);
        ami.setId(assessments.get(jTableMain.getSelectedRow()).getId());
        ami.setVisible(true);
        ami.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            model.delete(assessments.get(jTableMain.getSelectedRow()));
        } catch (SQLException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateInfo();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
 updateInfo();       
    }//GEN-LAST:event_btnRefreshActionPerformed

   
    
    private void openConnectionFrame(){
        ConnectionJDialog cf = new ConnectionJDialog((Frame)this.getOwner(), true);
        cf.setFields(conCont);
        cf.setVisible(true);
        conCont = cf.getFields();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbQueryId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMain;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem mItemDisconnect;
    private javax.swing.JMenuItem mItemExit;
    private javax.swing.JMenuItem mItemFaculties;
    private javax.swing.JMenuItem mItemGroups;
    private javax.swing.JMenuItem mItemNewConnection;
    private javax.swing.JMenuItem mItemStudents;
    private javax.swing.JMenuItem mItemSubjects;
    private javax.swing.JMenuItem mItemTeachers;
    private javax.swing.JMenuItem mItemTestTypes;
    // End of variables declaration//GEN-END:variables
}
