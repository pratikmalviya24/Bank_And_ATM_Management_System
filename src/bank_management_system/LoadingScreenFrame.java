
package bank_management_system;

public class LoadingScreenFrame extends javax.swing.JFrame {

    public LoadingScreenFrame() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        bankName = new javax.swing.JLabel();
        pleaseWaitLabel = new javax.swing.JLabel();
        Loading = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Panel1.setBackground(java.awt.Color.gray);
        Panel1.setPreferredSize(new java.awt.Dimension(400, 400));

        bankName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bankName.setForeground(new java.awt.Color(0, 0, 0));
        bankName.setText("WELCOME TO INDIAN BANK");

        pleaseWaitLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pleaseWaitLabel.setForeground(new java.awt.Color(0, 0, 0));
        pleaseWaitLabel.setText("Please Wait!  Loading...");

        Loading.setBackground(new java.awt.Color(255, 255, 153));
        Loading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Loading.setForeground(new java.awt.Color(0, 0, 0));
        Loading.setStringPainted(true);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Loading, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(bankName)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pleaseWaitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(pleaseWaitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Loading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar Loading;
    public javax.swing.JPanel Panel1;
    public javax.swing.JLabel bankName;
    public javax.swing.JLabel pleaseWaitLabel;
    // End of variables declaration//GEN-END:variables
}
