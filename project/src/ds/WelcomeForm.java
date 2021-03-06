
package ds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author chaosprince
 */
public class WelcomeForm extends javax.swing.JFrame {

    private String name;
    private float price;

    /**
     * Creates new form WelcomeForm
     * @param UserName username that is taken from form 1(Login/Sign up form)
     */
    public WelcomeForm(String UserName) {
        initComponents();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        this.jLabel2.setText(UserName);
        showProducts();
    }
    
    private ArrayList<Product> productList(){
        ArrayList<Product> products = new ArrayList<>();
        DBHandler ProductsFetcher = new DBHandler();
        try {
            ProductsFetcher.setQuery("SELECT * FROM `products`;");
            ResultSet rs = ProductsFetcher.executeQuery();
            Product product;
            while(rs.next()){
                product = new Product(rs.getInt("ID"),rs.getString("Name"),rs.getInt("ProductNumber"),rs.getFloat("Price"));
                products.add(product);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "fetching data faild");
        }
        ProductsFetcher.endDBConnection();
        return products;
    }
    public void showProducts(){
        ArrayList<Product> list = this.productList();
        DefaultTableModel model = (DefaultTableModel) this.Products.getModel();
        model.setRowCount(0);
        Object[] row = new Object[2];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getPrice();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Buy = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Quantity = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        Products = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Welcome, ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Products");

        Buy.setText("Buy");
        Buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");

        Quantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        Quantity.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                QuantityAncestorResized(evt);
            }
        });

        Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price"
            }
        ));
        Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Products);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Buy)
                        .addGap(54, 54, 54))))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Buy)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyActionPerformed
        //buy buttton
        
        Float total = this.price * (Integer)this.Quantity.getValue();
        int userID = 0 ,ProductNumber = 0;
        DBHandler DB = new DBHandler();
        DB.setQuery("SELECT `ID` FROM `clients` WHERE `Name`='"+this.jLabel2.getText()+"';");
        ResultSet rs1 = DB.executeQuery();
        try{
            rs1.next();
            userID = rs1.getInt("ID");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "faild to fetch user data");
        }
        DB.setQuery("SELECT * FROM `products` WHERE `Name`='"+this.name+"';");
        ResultSet rs2 = DB.executeQuery();
        try{
            rs2.next();
            ProductNumber = rs2.getInt("ProductNumber");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "faild to fetch product data");
        }
        DB.setQuery("INSERT INTO `purchases`(`ClientID`, `ProductNumber`, `quantity`) VALUES ("+userID+","+ProductNumber+","+(Integer)this.Quantity.getValue()+");");
        DB.executeQuery();
        //JOptionPane.showMessageDialog(null, "purchasing faild");
        
        DB.endDBConnection();
        JOptionPane.showMessageDialog(null, "total is: "+total);
    }//GEN-LAST:event_BuyActionPerformed

    private void QuantityAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_QuantityAncestorResized
        //quantity spinner
    }//GEN-LAST:event_QuantityAncestorResized

    private void ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsMouseClicked
        // TODO add your handling code here:
        int i = this.Products.getSelectedRow();
        TableModel model = this.Products.getModel();
        this.name = (String)model.getValueAt(i, 0);
        this.price = (Float)model.getValueAt(i, 1);
//        JOptionPane.showMessageDialog(null, "name: "+this.name+", price: "+this.price);
    }//GEN-LAST:event_ProductsMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new WelcomeForm("ahmad abboud").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buy;
    private javax.swing.JTable Products;
    private javax.swing.JSpinner Quantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
