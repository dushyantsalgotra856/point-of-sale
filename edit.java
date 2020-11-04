
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lab-3_9
 */
public class edit extends javax.swing.JFrame {

    String cat, barcode;
    /**
     * Creates new form edit
     */
    String pid;

    public edit(String pid) {
        initComponents();
        tfcategory.setFocusable(false);
        tfbarcode.setFocusable(false);
        setSize(600, 700);
        setVisible(true);
        tfbarcode.setEditable(false);
        this.pid = pid;
        System.out.println("pid " + pid);
        getProduct();
    }

    public void getProduct() {

        try {
            int p = Integer.parseInt(pid);
            ResultSet rs = DBLoader.executeQuery("select * from product where pid='" + p + "'");
            if (rs.next()) {
                String pname = rs.getString("pname");
                String pdesc = rs.getString("pdesc");
                barcode = rs.getString("barcode");
                String price = rs.getString("price");
                String photo = rs.getString("photo");
                cat = rs.getString("category");
                tfcategory.setText(cat);
                tfname.setText(pname);
                tadesc.setText(pdesc);
                tfbarcode.setText(barcode);
                tfprice.setText(price);

                BufferedImage bimg = ImageIO.read(new File(photo));
                BufferedImage img = resize(bimg, lbphoto.getWidth(), lbphoto.getHeight());
                lbphoto.setIcon(new ImageIcon(img));

            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        lbcategory = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbdesc = new javax.swing.JLabel();
        lbbarcode = new javax.swing.JLabel();
        lbprice = new javax.swing.JLabel();
        lbphoto1 = new javax.swing.JLabel();
        lbphoto = new javax.swing.JLabel();
        tfcategory = new javax.swing.JTextField();
        tfname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadesc = new javax.swing.JTextArea();
        tfbarcode = new javax.swing.JTextField();
        tfprice = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbcategory.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbcategory.setForeground(new java.awt.Color(204, 0, 0));
        lbcategory.setText("Category");
        getContentPane().add(lbcategory);
        lbcategory.setBounds(60, 20, 130, 50);

        lbname.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbname.setForeground(new java.awt.Color(204, 0, 0));
        lbname.setText("Name");
        getContentPane().add(lbname);
        lbname.setBounds(60, 100, 120, 50);

        lbdesc.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbdesc.setForeground(new java.awt.Color(204, 0, 0));
        lbdesc.setText("Description ");
        getContentPane().add(lbdesc);
        lbdesc.setBounds(60, 180, 140, 50);

        lbbarcode.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbbarcode.setForeground(new java.awt.Color(204, 0, 0));
        lbbarcode.setText("Barcode");
        getContentPane().add(lbbarcode);
        lbbarcode.setBounds(60, 290, 130, 50);

        lbprice.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbprice.setForeground(new java.awt.Color(204, 0, 0));
        lbprice.setText("Price");
        getContentPane().add(lbprice);
        lbprice.setBounds(60, 360, 110, 50);

        lbphoto1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbphoto1.setForeground(new java.awt.Color(204, 0, 0));
        lbphoto1.setText("Photo");
        getContentPane().add(lbphoto1);
        lbphoto1.setBounds(60, 450, 120, 50);
        getContentPane().add(lbphoto);
        lbphoto.setBounds(270, 430, 160, 120);

        tfcategory.setEditable(false);
        getContentPane().add(tfcategory);
        tfcategory.setBounds(250, 30, 200, 40);
        getContentPane().add(tfname);
        tfname.setBounds(250, 100, 200, 40);

        tadesc.setColumns(20);
        tadesc.setRows(5);
        jScrollPane1.setViewportView(tadesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 160, 200, 96);

        tfbarcode.setEditable(false);
        getContentPane().add(tfbarcode);
        tfbarcode.setBounds(250, 300, 200, 40);
        getContentPane().add(tfprice);
        tfprice.setBounds(250, 370, 200, 40);

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 570, 140, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//        String cat = tfcategory.getText();
        String name = tfname.getText();
        String desc = tadesc.getText();
//        String barcode = tfbarcode.getText();
        String price = tfprice.getText();
//        String photo = lbphoto1.getText();
        if (name.isEmpty() || desc.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required !!!");
        } else {
//            String fname = f.getPath();
//
//            String f = new Date().getTime() + ".jpg";
//            new savefileinfolder(f, fname);
            try {
                ResultSet rs = DBLoader.executeQuery("select * from product where pid='" + pid + "'");
                if (rs.next()) {
                    rs.updateString("pname", name);
                    rs.updateString("pdesc", desc);
                    rs.updateString("price", price);
                    rs.updateRow();
                    JOptionPane.showMessageDialog(rootPane, "Product edited successfully");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No such product found");
//                  

//                    getProducts(cat);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbbarcode;
    private javax.swing.JLabel lbcategory;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel lbphoto1;
    private javax.swing.JLabel lbprice;
    private javax.swing.JTextArea tadesc;
    private javax.swing.JTextField tfbarcode;
    private javax.swing.JTextField tfcategory;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfprice;
    // End of variables declaration//GEN-END:variables

    public BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}
