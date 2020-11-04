
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lab-3_9
 */
public class category extends javax.swing.JFrame {

    ArrayList<categories> al = new ArrayList<>();
    MyModel tm;
    File f;

    /**
     * Creates new form category
     */
    public category() {
        initComponents();
        setSize(1200, 800);
        setVisible(true);

        tm = new MyModel();
        jTable1.setModel(tm);
        getCategories();

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
        lbdesc = new javax.swing.JLabel();
        lbphoto1 = new javax.swing.JLabel();
        tfcatname = new javax.swing.JTextField();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tacatdesc = new javax.swing.JTextArea();
        lbphoto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btbrowse = new javax.swing.JButton();
        btadd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btdelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbcategory.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbcategory.setForeground(new java.awt.Color(153, 0, 153));
        lbcategory.setText("Category Name");
        getContentPane().add(lbcategory);
        lbcategory.setBounds(50, 70, 260, 40);

        lbdesc.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbdesc.setForeground(new java.awt.Color(153, 0, 153));
        lbdesc.setText("Category Description");
        getContentPane().add(lbdesc);
        lbdesc.setBounds(40, 180, 250, 50);

        lbphoto1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbphoto1.setForeground(new java.awt.Color(153, 0, 153));
        lbphoto1.setText("Photo");
        getContentPane().add(lbphoto1);
        lbphoto1.setBounds(40, 320, 160, 60);
        getContentPane().add(tfcatname);
        tfcatname.setBounds(310, 60, 240, 50);
        getContentPane().add(jScrollBar1);
        jScrollBar1.setBounds(530, 160, 20, 100);

        tacatdesc.setColumns(20);
        tacatdesc.setRows(5);
        jScrollPane1.setViewportView(tacatdesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 160, 240, 100);
        getContentPane().add(lbphoto);
        lbphoto.setBounds(310, 300, 160, 110);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 420, 250, 30);

        btbrowse.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btbrowse.setForeground(new java.awt.Color(153, 0, 153));
        btbrowse.setText("Browse");
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowse);
        btbrowse.setBounds(480, 330, 110, 40);

        btadd.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btadd.setForeground(new java.awt.Color(102, 0, 102));
        btadd.setText("ADD");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(210, 450, 190, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(640, 140, 460, 402);

        btdelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btdelete.setForeground(new java.awt.Color(153, 0, 153));
        btdelete.setText("DELETE");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btdelete);
        btdelete.setBounds(730, 600, 180, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowseActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            try {
                BufferedImage bimg = ImageIO.read(f);
                BufferedImage img = resize(bimg, lbphoto.getWidth(), lbphoto.getHeight());
                lbphoto.setIcon(new ImageIcon(img));

            } catch (IOException ex) {
                Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btbrowseActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        String cat = tfcatname.getText();
        String desc = tacatdesc.getText();
        if (cat.isEmpty() || desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required !!!");
        } else {
            String fname = f.getPath();

            String filename = new Date().getTime() + ".jpg";
            new savefileinfolder(f, filename);
            ResultSet rs = DBLoader.executeQuery("select * from category");
            try {
                rs.moveToInsertRow();
                rs.updateString("cname", cat);
                rs.updateString("cdesc", desc);
                rs.updateString("cphoto", "src/uploaded_pics/" + filename);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Category added");
                getCategories();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btaddActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {
            int cid = Integer.parseInt(al.get(jTable1.getSelectedRow()).cid);
            ResultSet rs = DBLoader.executeQuery("select * from category where cid='" + cid + "'");
            try {
                if (rs.next()) {
                    rs.deleteRow();
                    JOptionPane.showMessageDialog(this, "Row deleted successfully");
                    getCategories();

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btdeleteActionPerformed

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
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton btbrowse;
    private javax.swing.JButton btdelete;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbcategory;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel lbphoto1;
    private javax.swing.JTextArea tacatdesc;
    private javax.swing.JTextField tfcatname;
    // End of variables declaration//GEN-END:variables

    class MyModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            //To change body of generated methods, choose Tools | Templates.
            return al.size();
        }

        @Override
        public int getColumnCount() {
//To change body of generated methods, choose Tools | Templates.
            return 3;
        }

        @Override
        public Object getValueAt(int i, int j) {
//To change body of generated methods, choose Tools | Templates.
            categories cat = al.get(i);
            if (j == 0) {
                return cat.cname;
            } else if (j == 1) {
                return cat.cdesc;
            } else {
                return cat.cphoto;
            }

        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"catname", "desc", "photo"};

            //To change body of generated methods, choose Tools | Templates.
            return col[j];
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon;
        BufferedImage bufferedImage;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {

                icon = new ImageIcon(al.get(row).cphoto);
                Image im = icon.getImage();
                Image newimage = im.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimage);
                lbl.setIcon(icon);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return lbl;
        }

    }

    public BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public void getCategories() {
        al.clear();
        jTable1.removeAll();
        ResultSet rs = DBLoader.executeQuery("select * from category");
        try {
            while (rs.next()) {
                String cid = rs.getString("cid");
                String cname = rs.getString("cname");
                String cdesc = rs.getString("cdesc");
                String cphoto = rs.getString("cphoto");
                System.out.println("Adding in arraylist");
                al.add(new categories(cid, cname, cdesc, cphoto));
                jTable1.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
                jTable1.setRowHeight(100);
                tm.fireTableDataChanged();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}