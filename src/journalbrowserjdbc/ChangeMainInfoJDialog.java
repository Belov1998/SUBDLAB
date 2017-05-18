
package journalbrowserjdbc;

import entities.Ocenki;
import entities.*;
import entities.Prepodavatel;
import entities.Vid_Otchetnosti;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DbManager;
import models.MainInfoModel;


public class ChangeMainInfoJDialog extends javax.swing.JFrame  {

    private MainInfoModel model = new MainInfoModel();
    private DbManager dbManager = null;

    private long id;

    private List<Prepodavatel> prepodavateli = null;
    private List<Student> students = null;
    private List<Vid_Otchetnosti> vid_otch = null;
    private List<Attestacia> attestacia = null;

    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }
    
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    public ChangeMainInfoJDialog() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbIDStudent = new javax.swing.JComboBox<>();
        cbIdSubject = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();
        cbAssessment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setText("Оценка");

        jLabel4.setText("Студент");

        jLabel5.setText("Предмет");

        cbIDStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbIdSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        cbAssessment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbIdSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnOK)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbIdSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnOK))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
           Ocenki entity = new Ocenki();
           entity.setId(id);
            entity.setOcenki(cbAssessment.getSelectedItem().toString());
            entity.setId_attestacii(attestacia.get(cbIdSubject.getSelectedIndex()).getId());
            entity.setId_zachetki(students.get(cbIDStudent.getSelectedIndex()).getId());
            model.update(entity);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeMainInfoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       MainJFrame.mJf.updateInfo();
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        model.setDbManager(dbManager);
        try{
        prepodavateli = model.getTeachers();
        students = model.getStudents();
        attestacia = model.getSubjects();
        vid_otch = model.getTestTypes();
        }catch(Exception e){}
       
        cbIDStudent.removeAllItems();
        cbIdSubject.removeAllItems();
        cbAssessment.removeAllItems();
        cbAssessment.addItem("horosho");
        cbAssessment.addItem("otlich");
        cbAssessment.addItem("udval");
        cbAssessment.addItem("ploho");
        cbAssessment.addItem("zachet");
        cbAssessment.addItem(" ");
        for(Student e : students){
            cbIDStudent.addItem(e.getFamilia() + " " + e.getImia());
        }
        String dop="";
         for(Attestacia e : attestacia){
             dop="";
              for(Vid_Otchetnosti v : vid_otch){
            if(v.getId()==e.getId_vida_otch()){
               dop+= v.getNazvanie()+" ";
            }
        }  
            for(Prepodavatel p : prepodavateli){
            if(p.getId()==e.getId_prepodavatel()){
            dop+=p.getFamilia() + " " + p.getImia();
            }
            }
            cbIdSubject.addItem(e.getPredmet()+" "+dop);
        }
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbAssessment;
    private javax.swing.JComboBox<String> cbIDStudent;
    private javax.swing.JComboBox<String> cbIdSubject;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
