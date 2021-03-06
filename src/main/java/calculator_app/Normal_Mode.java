package calculator_app;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author nassimabenbahtane
 */
public class Normal_Mode extends javax.swing.JFrame {
    
    // init variables
    public double num,ans;
    public int operation;
    
    // constructor 
    public Normal_Mode() {
        initComponents();           // initialise all the components of the GUI
    }
    
    // methode that verifies if a number is an int or a double and converts it to a string accordinly  
    public static String Display_doubleORint(double ans){ 
        String result;
        if ((ans % 1) == 0) {
            result = Integer.toString((int) ans);      // convert the int to a string 
        }else{
            result = Double.toString(round(ans,4));    // convert the double to a string while keeping only 4 decimal values
        }
        return result;
    }
    
    // methode that limits the number of values after the comma of a double 
    public static double round(double num, int places) {
        if (places < 0) throw new IllegalArgumentException();           // ensure that the nb of dicimal values is positif and plausible 
        double roundDouble = new BigDecimal(num).setScale(places, RoundingMode.HALF_UP).doubleValue();  //HALF_UP is the option to round up in the middle  
        return roundDouble;
    }
    
    // methode that contains all the arithmetic operation that our calculator can perform 
    public void arithmetic_operation(){
        switch(operation){
            case 1 :  // addition
                ans= num + Double.parseDouble(DisplayField.getText()); // convert string to double 
                DisplayField.setText(Display_doubleORint(ans));        // display an int or a double according to the tipe 
                break;
            case 2 :    // subtraction 
                ans= num - Double.parseDouble(DisplayField.getText()); // convert string to double 
                DisplayField.setText(Display_doubleORint(ans));
                break;
            case 3 :    // multiplication 
                ans= num * Double.parseDouble(DisplayField.getText()); // convert string to double 
                DisplayField.setText(Display_doubleORint(ans));
                break;               
            case 4 :    // division
                ans= num / Double.parseDouble(DisplayField.getText()); // convert string to double 
                DisplayField.setText(Display_doubleORint(ans));
                break;   
            case 5 :    // modulo
                ans= num % Double.parseDouble(DisplayField.getText()); // convert string to double 
                DisplayField.setText(Display_doubleORint(ans));
                break;
            default :
                ans = Double.parseDouble(DisplayField.getText());
                DisplayField.setText(Display_doubleORint(ans));
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Minus = new javax.swing.JButton();
        jButton1_ = new javax.swing.JButton();
        jButton2_ = new javax.swing.JButton();
        jButton3_ = new javax.swing.JButton();
        Add_ = new javax.swing.JButton();
        jButton0_ = new javax.swing.JButton();
        Point_ = new javax.swing.JButton();
        PlusMinus_ = new javax.swing.JButton();
        Equal_ = new javax.swing.JButton();
        DisplayField = new javax.swing.JTextField();
        AC_ = new javax.swing.JButton();
        Del_ = new javax.swing.JButton();
        modulo_ = new javax.swing.JButton();
        Div_ = new javax.swing.JButton();
        jButton7_ = new javax.swing.JButton();
        jButton8_ = new javax.swing.JButton();
        jButton9_ = new javax.swing.JButton();
        Mul_ = new javax.swing.JButton();
        jButton4_ = new javax.swing.JButton();
        jButton5_ = new javax.swing.JButton();
        jButton6_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        Normal = new javax.swing.JMenuItem();
        Scientific = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Minus.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Minus.setText("-");
        Minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusActionPerformed(evt);
            }
        });

        jButton1_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton1_.setText("1");
        jButton1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });

        jButton2_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton2_.setText("2");
        jButton2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_ActionPerformed(evt);
            }
        });

        jButton3_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton3_.setText("3");
        jButton3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_ActionPerformed(evt);
            }
        });

        Add_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Add_.setText("+");
        Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ActionPerformed(evt);
            }
        });

        jButton0_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton0_.setText("0");
        jButton0_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0_ActionPerformed(evt);
            }
        });

        Point_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Point_.setText(",");
        Point_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Point_ActionPerformed(evt);
            }
        });

        PlusMinus_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        PlusMinus_.setText("+/-");
        PlusMinus_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusMinus_ActionPerformed(evt);
            }
        });

        Equal_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Equal_.setText("=");
        Equal_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Equal_ActionPerformed(evt);
            }
        });

        DisplayField.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        DisplayField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DisplayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayFieldActionPerformed(evt);
            }
        });
        DisplayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DisplayFieldKeyTyped(evt);
            }
        });

        AC_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        AC_.setText("AC");
        AC_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AC_ActionPerformed(evt);
            }
        });

        Del_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Del_.setText("Del");
        Del_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_ActionPerformed(evt);
            }
        });

        modulo_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        modulo_.setText("%");
        modulo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modulo_ActionPerformed(evt);
            }
        });

        Div_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Div_.setText("÷");
        Div_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Div_ActionPerformed(evt);
            }
        });

        jButton7_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton7_.setText("7");
        jButton7_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_ActionPerformed(evt);
            }
        });

        jButton8_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton8_.setText("8");
        jButton8_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8_ActionPerformed(evt);
            }
        });

        jButton9_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton9_.setText("9");
        jButton9_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9_ActionPerformed(evt);
            }
        });

        Mul_.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        Mul_.setText("x");
        Mul_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mul_ActionPerformed(evt);
            }
        });

        jButton4_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton4_.setText("4");
        jButton4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_ActionPerformed(evt);
            }
        });

        jButton5_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton5_.setText("5");
        jButton5_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_ActionPerformed(evt);
            }
        });

        jButton6_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton6_.setText("6");
        jButton6_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6_ActionPerformed(evt);
            }
        });

        jMenu5.setText("Mode");

        Normal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Normal.setText("Normal Mode");
        Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NormalActionPerformed(evt);
            }
        });
        jMenu5.add(Normal);

        Scientific.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Scientific.setText("Scientific Mode");
        Scientific.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScientificActionPerformed(evt);
            }
        });
        jMenu5.add(Scientific);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mul_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AC_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Del_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modulo_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Div_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Minus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton0_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Point_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlusMinus_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DisplayField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisplayField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AC_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Del_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modulo_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Div_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mul_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton0_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Point_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlusMinus_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // action on 1 button
    private void jButton1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "1");
    }//GEN-LAST:event_jButton1_ActionPerformed

    // action on 2 button
    private void jButton2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "2");
    }//GEN-LAST:event_jButton2_ActionPerformed

    
    // action on 3 button
    private void jButton3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "3");
    }//GEN-LAST:event_jButton3_ActionPerformed

    
    // action on + button
    private void Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ActionPerformed
        num = Double.parseDouble(DisplayField.getText());
        operation = 1;
        DisplayField.setText("");
        jLabel1.setText(Display_doubleORint(num) + "+"); 
    }//GEN-LAST:event_Add_ActionPerformed

    
    // action on 0 button
    private void jButton0_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "0");
    }//GEN-LAST:event_jButton0_ActionPerformed

    
    // action on . button
    private void Point_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Point_ActionPerformed
        if (DisplayField.getText().length() > 0) {
            DisplayField.setText(DisplayField.getText() + ".");
        }else{
            DisplayField.setText("0.");
        }
    }//GEN-LAST:event_Point_ActionPerformed

    
    // action on +/- button
    private void PlusMinus_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusMinus_ActionPerformed
        if (DisplayField.getText().length() > 0) {
            num = Double.parseDouble(DisplayField.getText());
            ans = num * (-1);
            DisplayField.setText(Display_doubleORint(ans));
        }else{
            DisplayField.setText("-");
        }
    }//GEN-LAST:event_PlusMinus_ActionPerformed

    
    // action on = button
    private void Equal_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Equal_ActionPerformed
        jLabel1.setText( DisplayField.getText());
        if( jLabel1.getText().length() > 0){
            arithmetic_operation(); 
        }else{
            DisplayField.setText(DisplayField.getText());
        }
    }//GEN-LAST:event_Equal_ActionPerformed

    private void DisplayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayFieldActionPerformed

    // action on the AC button
    private void AC_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AC_ActionPerformed
        DisplayField.setText("0");
        jLabel1.setText("");
    }//GEN-LAST:event_AC_ActionPerformed

    
    // action on the Del button
    private void Del_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Del_ActionPerformed
        if (DisplayField.getText().length() > 0){                            // Make sure the text feide aint empty
            StringBuilder text = new StringBuilder(DisplayField.getText());  // fill the buffer with the String input
            text.deleteCharAt(DisplayField.getText().length() - 1);          // delete the character at the last index
            DisplayField.setText(text.toString());                           // convert the result back to a String and display it
        }
    }//GEN-LAST:event_Del_ActionPerformed

    // action on 7 button
    private void jButton7_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "7");
    }//GEN-LAST:event_jButton7_ActionPerformed

    // action on 8 button
    private void jButton8_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "8");
    }//GEN-LAST:event_jButton8_ActionPerformed
    
    // action on 9 button
    private void jButton9_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "9");
    }//GEN-LAST:event_jButton9_ActionPerformed
 
    // action on 4 button
    private void jButton4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "4");
    }//GEN-LAST:event_jButton4_ActionPerformed

    // action on 5 button
    private void jButton5_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "5");
    }//GEN-LAST:event_jButton5_ActionPerformed

    // action on 6 button
    private void jButton6_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6_ActionPerformed
        DisplayField.setText(DisplayField.getText() + "6");
    }//GEN-LAST:event_jButton6_ActionPerformed

    private void NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NormalActionPerformed

    // action on the menue item to switch to the scientific mode 
    private void ScientificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScientificActionPerformed
        this.dispose();                                     // remove the current jFrame
        Scientific_Mode obj = new Scientific_Mode();         
        obj.setVisible(true);                               // make the new jFrame visible
        
    }//GEN-LAST:event_ScientificActionPerformed

    // methode to prevent the user from writing in the DisplayFiel using the keyboard 
    private void DisplayFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayFieldKeyTyped
        char c = evt.getKeyChar();          // get the keystoks 
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ){
           evt.consume();    // prevents the event from being processed by the source which originated it.              
        }
    }//GEN-LAST:event_DisplayFieldKeyTyped
    
    // action on - button 
    private void MinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusActionPerformed
        num = Double.parseDouble(DisplayField.getText());
        operation = 2;
        DisplayField.setText("");
        jLabel1.setText(Display_doubleORint(num) + "-"); 
    }//GEN-LAST:event_MinusActionPerformed

    // action on x button 
    private void Mul_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mul_ActionPerformed
        num = Double.parseDouble(DisplayField.getText());
        operation = 3;
        DisplayField.setText("");
        jLabel1.setText(Display_doubleORint(num) + "x");
    }//GEN-LAST:event_Mul_ActionPerformed

    // action on ÷ button
    private void Div_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Div_ActionPerformed
        num = Double.parseDouble(DisplayField.getText());
        operation = 4;
        DisplayField.setText("");
        jLabel1.setText(Display_doubleORint(num) + "÷");
    }//GEN-LAST:event_Div_ActionPerformed

    // action on % button 
    private void modulo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modulo_ActionPerformed
        num = Double.parseDouble(DisplayField.getText());
        operation = 5;
        DisplayField.setText("");
        jLabel1.setText(Display_doubleORint(num) + "%");
    }//GEN-LAST:event_modulo_ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Normal_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Normal_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Normal_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Normal_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Normal_Mode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AC_;
    private javax.swing.JButton Add_;
    private javax.swing.JButton Del_;
    private javax.swing.JTextField DisplayField;
    private javax.swing.JButton Div_;
    private javax.swing.JButton Equal_;
    private javax.swing.JButton Minus;
    private javax.swing.JButton Mul_;
    private javax.swing.JMenuItem Normal;
    private javax.swing.JButton PlusMinus_;
    private javax.swing.JButton Point_;
    private javax.swing.JMenuItem Scientific;
    private javax.swing.JButton jButton0_;
    private javax.swing.JButton jButton1_;
    private javax.swing.JButton jButton2_;
    private javax.swing.JButton jButton3_;
    private javax.swing.JButton jButton4_;
    private javax.swing.JButton jButton5_;
    private javax.swing.JButton jButton6_;
    private javax.swing.JButton jButton7_;
    private javax.swing.JButton jButton8_;
    private javax.swing.JButton jButton9_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton modulo_;
    // End of variables declaration//GEN-END:variables
}
