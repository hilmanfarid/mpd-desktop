/*
 * Copyright Vladimir Petrenko. All rights reserved
 * Contact: 
 *   Mitteldamm 48a
 *   32429 Minden
 *   Germany
 *   vladipetrenko@gmx.de 
 * Developer: Vladimir Petrenko
 */

package virtualkeyboard.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.text.JTextComponent;
import virtualkeyboard.lang.KeyEnums;

/**
 * Keyboard inside this JPanel
 * @author Vladimir Petrenko
 * @version 1.0
 * @since 01.01.2013
 */
public class PanelVirtualKeyboardNumber extends javax.swing.JPanel {
    ResourceBundle keyBundle = null;
    KeyEnums keyEnums = null;
    JTextComponent textComponent;
    Window window = null;
    Locale localeL;

    boolean poitToUp = false;
    boolean shiftBs = false;
    int layer=0;
    int gap = 2;
    int tab = 4;

    /** Creates new form PanelVirtualKeyboard */
    public PanelVirtualKeyboardNumber() {

        initComponents();
        localeL= Locale.getDefault(); //Set locale to default

//        localeL= new Locale("en", "GB");
        try {
            keyBundle = ResourceBundle.getBundle("virtualkeyboard.lang.Keyboard", localeL);
        } catch (MissingResourceException e) {
            System.err.println(e);
        }        
        updateGUI();
        layer=0;
    }

    /**
     * Set focus to ENTER button
     */
    public void setFocusToEXE(){
        jBExe.requestFocus();
    }

    public final void updateGUI() {
        switch (layer) {
            case 0:
                //ROW1*********************************************************************
                jBR1B1.setText(keyBundle.getString(KeyEnums.jBR1B1.toString()));
                jBR1B2.setText(keyBundle.getString(KeyEnums.jBR1B2.toString()));
                jBR1B3.setText(keyBundle.getString(KeyEnums.jBR1B3.toString()));
                jBR1B4.setText(keyBundle.getString(KeyEnums.jBR1B4.toString()));
                jBR1B5.setText(keyBundle.getString(KeyEnums.jBR1B5.toString()));
                jBR1B6.setText(keyBundle.getString(KeyEnums.jBR1B6.toString()));
                jBR1B7.setText(keyBundle.getString(KeyEnums.jBR1B7.toString()));
                jBR1B8.setText(keyBundle.getString(KeyEnums.jBR1B8.toString()));
                jBR1B9.setText(keyBundle.getString(KeyEnums.jBR1B9.toString()));
                jBR1B10.setText(keyBundle.getString(KeyEnums.jBR1B10.toString()));
                jBR1B11.setText(keyBundle.getString(KeyEnums.jBR1B11.toString()));
                jBR1B12.setText(keyBundle.getString(KeyEnums.jBR1B12.toString()));
                jBR1B13.setText(keyBundle.getString(KeyEnums.jBR1B13.toString()));
//              jBBackspace.setText(keyBundle.getString(KeyEnums.jBR1BACKSPACE.toString()));
                //ROW2*********************************************************************
//                jBR2B1.setText(keyBundle.getString(KeyEnums.jBR2B1.toString())); //Tab Key
/*                jBR2B2.setText(keyBundle.getString(KeyEnums.jBR2B2.toString()));
                jBR2B3.setText(keyBundle.getString(KeyEnums.jBR2B3.toString()));
                jBR2B4.setText(keyBundle.getString(KeyEnums.jBR2B4.toString()));
                jBR2B5.setText(keyBundle.getString(KeyEnums.jBR2B5.toString()));
                jBR2B6.setText(keyBundle.getString(KeyEnums.jBR2B6.toString()));
                jBR2B7.setText(keyBundle.getString(KeyEnums.jBR2B7.toString()));
                jBR2B8.setText(keyBundle.getString(KeyEnums.jBR2B8.toString()));
                jBR2B9.setText(keyBundle.getString(KeyEnums.jBR2B9.toString()));
                jBR2B10.setText(keyBundle.getString(KeyEnums.jBR2B10.toString()));
                jBR2B11.setText(keyBundle.getString(KeyEnums.jBR2B11.toString()));
                jBR2B12.setText(keyBundle.getString(KeyEnums.jBR2B12.toString()));
                jBR2B13.setText(keyBundle.getString(KeyEnums.jBR2B13.toString()));*/
//              jBEnter.setText(keyBundle.getString(KeyEnums.jBENTER.toString()));
                //ROW3*********************************************************************
//              jBR3B1.setText(keyBundle.getString(KeyEnums.jBR3B1.toString())); //Cap Key
//              jBR4B13.setText(keyBundle.getString(KeyEnums.jBR4B13.toString())); //Shift Key
                //ROW5*********************************************************************
//              jBCtrl.setText(keyBundle.getString(KeyEnums.jBCTRL.toString()));  //Ctrl Key
//              jBSpace.setText(keyBundle.getString(KeyEnums.jBSPACE.toString()));  //Space Key
                break;
            case 1:
                //ROW1*********************************************************************
                jBR1B1.setText(keyBundle.getString(KeyEnums.jBR1B1_0.toString()));
                jBR1B2.setText(keyBundle.getString(KeyEnums.jBR1B2_0.toString()));
                jBR1B3.setText(keyBundle.getString(KeyEnums.jBR1B3_0.toString()));
                jBR1B4.setText(keyBundle.getString(KeyEnums.jBR1B4_0.toString()));
                jBR1B5.setText(keyBundle.getString(KeyEnums.jBR1B5_0.toString()));
                jBR1B6.setText(keyBundle.getString(KeyEnums.jBR1B6_0.toString()));
                jBR1B7.setText(keyBundle.getString(KeyEnums.jBR1B7_0.toString()));
                jBR1B8.setText(keyBundle.getString(KeyEnums.jBR1B8_0.toString()));
                jBR1B9.setText(keyBundle.getString(KeyEnums.jBR1B9_0.toString()));
                jBR1B10.setText(keyBundle.getString(KeyEnums.jBR1B10_0.toString()));
                jBR1B11.setText(keyBundle.getString(KeyEnums.jBR1B11_0.toString()));
                jBR1B12.setText(keyBundle.getString(KeyEnums.jBR1B12_0.toString()));
                jBR1B13.setText(keyBundle.getString(KeyEnums.jBR1B13_0.toString()));
//              jBBackspace.setText(keyBundle.getString(KeyEnums.jBR1BACKSPACE_0.toString()));
                //ROW2*********************************************************************
//              jBR2B1.setText(keyBundle.getString(KeyEnums.jBR2B1_0.toString())); //Tab Key
                /*jBR2B2.setText(keyBundle.getString(KeyEnums.jBR2B2_0.toString()));
                jBR2B3.setText(keyBundle.getString(KeyEnums.jBR2B3_0.toString()));
                jBR2B4.setText(keyBundle.getString(KeyEnums.jBR2B4_0.toString()));
                jBR2B5.setText(keyBundle.getString(KeyEnums.jBR2B5_0.toString()));
                jBR2B6.setText(keyBundle.getString(KeyEnums.jBR2B6_0.toString()));
                jBR2B7.setText(keyBundle.getString(KeyEnums.jBR2B7_0.toString()));
                jBR2B8.setText(keyBundle.getString(KeyEnums.jBR2B8_0.toString()));
                jBR2B9.setText(keyBundle.getString(KeyEnums.jBR2B9_0.toString()));
                jBR2B10.setText(keyBundle.getString(KeyEnums.jBR2B10_0.toString()));
                jBR2B11.setText(keyBundle.getString(KeyEnums.jBR2B11_0.toString()));
                jBR2B12.setText(keyBundle.getString(KeyEnums.jBR2B12_0.toString()));
                jBR2B13.setText(keyBundle.getString(KeyEnums.jBR2B13_0.toString()));*/
//              jBEnter.setText(keyBundle.getString(KeyEnums.jBENTER_0.toString()));
                //ROW3*********************************************************************
//              jBR3B1.setText(keyBundle.getString(KeyEnums.jBR3B1_0.toString())); //Cap Key
//              jBR4B13.setText(keyBundle.getString(KeyEnums.jBR4B13_0.toString())); //Shift Key
                //ROW5*********************************************************************
//              jBCtrl.setText(keyBundle.getString(KeyEnums.jBCTRL_0.toString()));  //Ctrl Key
//              jBSpace.setText(keyBundle.getString(KeyEnums.jBSPACE_0.toString()));  //Space Key
                break;
            case 2:
                //ROW1*********************************************************************
                jBR1B1.setText(keyBundle.getString(KeyEnums.jBR1B1_1.toString()));
                jBR1B2.setText(keyBundle.getString(KeyEnums.jBR1B2_1.toString()));
                jBR1B3.setText(keyBundle.getString(KeyEnums.jBR1B3_1.toString()));
                jBR1B4.setText(keyBundle.getString(KeyEnums.jBR1B4_1.toString()));
                jBR1B5.setText(keyBundle.getString(KeyEnums.jBR1B5_1.toString()));
                jBR1B6.setText(keyBundle.getString(KeyEnums.jBR1B6_1.toString()));
                jBR1B7.setText(keyBundle.getString(KeyEnums.jBR1B7_1.toString()));
                jBR1B8.setText(keyBundle.getString(KeyEnums.jBR1B8_1.toString()));
                jBR1B9.setText(keyBundle.getString(KeyEnums.jBR1B9_1.toString()));
                jBR1B10.setText(keyBundle.getString(KeyEnums.jBR1B10_1.toString()));
                jBR1B11.setText(keyBundle.getString(KeyEnums.jBR1B11_1.toString()));
                jBR1B12.setText(keyBundle.getString(KeyEnums.jBR1B12_1.toString()));
                jBR1B13.setText(keyBundle.getString(KeyEnums.jBR1B13_1.toString()));
//              jBBackspace.setText(keyBundle.getString(KeyEnums.jBR1BACKSPACE_1.toString()));
                //ROW2*********************************************************************
//                jBR2B1.setText(keyBundle.getString(KeyEnums.jBR2B1_1.toString())); //Tab Key
                /*jBR2B2.setText(keyBundle.getString(KeyEnums.jBR2B2_1.toString()));
                jBR2B3.setText(keyBundle.getString(KeyEnums.jBR2B3_1.toString()));
                jBR2B4.setText(keyBundle.getString(KeyEnums.jBR2B4_1.toString()));
                jBR2B5.setText(keyBundle.getString(KeyEnums.jBR2B5_1.toString()));
                jBR2B6.setText(keyBundle.getString(KeyEnums.jBR2B6_1.toString()));
                jBR2B7.setText(keyBundle.getString(KeyEnums.jBR2B7_1.toString()));
                jBR2B8.setText(keyBundle.getString(KeyEnums.jBR2B8_1.toString()));
                jBR2B9.setText(keyBundle.getString(KeyEnums.jBR2B9_1.toString()));
                jBR2B10.setText(keyBundle.getString(KeyEnums.jBR2B10_1.toString()));
                jBR2B11.setText(keyBundle.getString(KeyEnums.jBR2B11_1.toString()));
                jBR2B12.setText(keyBundle.getString(KeyEnums.jBR2B12_1.toString()));
                jBR2B13.setText(keyBundle.getString(KeyEnums.jBR2B13_1.toString()));*/
//              jBEnter.setText(keyBundle.getString(KeyEnums.jBENTER_1.toString()));
                //ROW3*********************************************************************
//              jBR3B1.setText(keyBundle.getString(KeyEnums.jBR3B1_1.toString())); //Cap Key
               
//              jBR4B13.setText(keyBundle.getString(KeyEnums.jBR4B13_1.toString())); //Shift Key
                //ROW5*********************************************************************
//              jBCtrl.setText(keyBundle.getString(KeyEnums.jBCTRL_1.toString()));  //Ctrl Key
//              jBSpace.setText(keyBundle.getString(KeyEnums.jBSPACE_1.toString()));  //Space Key
                break;
        }
    }

     @Override
  protected void paintComponent( Graphics g )
  {
         //2D graphic Component loading
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent( g2D );

        //Height and width of Panel
        int lHeight=this.getHeight();
        int lWidth =this.getWidth();
        
        int width = lWidth/15-gap;
        int height = lHeight/5-gap;

        int x = gap;
        int y = gap;

        //Row 1
        jBR1B1.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B2.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B3.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B4.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B5.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B6.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B7.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B8.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B9.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B10.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B11.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B12.setBounds(x, y, width, height);
            x += width+gap;
        jBR1B13.setBounds(x, y, width, height);
            x += width+gap;
        jBBackspace.setBounds(x, y, width*2, height);

        //Row 2
        /*jBR2B2.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B3.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B4.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B5.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B6.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B7.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B8.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B9.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B10.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B11.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B12.setBounds(x, y, width, height);
            x += width+gap;
        jBR2B13.setBounds(x, y, width, height);
            x += width+gap;*/
     }

    /**
     * Get the value of locale
     *
     * @return the value of locale
     */
    public Locale getLocaleL() {
        return localeL;
    }

    /**
     * Set the value of locale
     *
     * @param locale new value of locale
     */
    public void setLocaleL(Locale localeL) {
        this.localeL = localeL;
        try {
            keyBundle = ResourceBundle.getBundle("virtualkeyboard.lang.Keyboard", this.localeL);
        } catch (MissingResourceException e) {
            System.err.println(e);
        }
        updateGUI();
    }

    public JTextComponent getTextComponent() {
        return textComponent;
    }

    public void setTextComponent(JTextComponent textComponent) {
        this.textComponent = textComponent;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public boolean isPoitToUp() {
        return poitToUp;
    }

    public void setPoitToUp(boolean poitToUp) {
        this.poitToUp = poitToUp;
    }

    public boolean isShiftBs() {
        return shiftBs;
    }

    public void setShiftBs(boolean shiftBs) {
        this.shiftBs = shiftBs;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
    
     /**
     * Write value to the JTextComponent to the right Caret position
     *
     * @param evt
     */
    private void writeValue(java.awt.event.ActionEvent evt){
        if(textComponent==null) return;
        if(((((JButton)evt.getSource()).getText())).equals("")) return;
        String text = textComponent.getText();        
        int index = textComponent.getCaretPosition();
        text = new StringBuffer(text).insert(index,
            ((JButton)evt.getSource()).getText()).toString();
        textComponent.setText(text);
        textComponent.setCaretPosition(index+(((JButton)evt.getSource()).getText()).toString().length());

        updateGUI();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBR1B1 = new javax.swing.JButton();
        jBR1B2 = new javax.swing.JButton();
        jBR1B3 = new javax.swing.JButton();
        jBR1B4 = new javax.swing.JButton();
        jBR1B5 = new javax.swing.JButton();
        jBR1B6 = new javax.swing.JButton();
        jBR1B7 = new javax.swing.JButton();
        jBR1B8 = new javax.swing.JButton();
        jBR1B9 = new javax.swing.JButton();
        jBR1B10 = new javax.swing.JButton();
        jBR1B11 = new javax.swing.JButton();
        jBR1B12 = new javax.swing.JButton();
        jBR1B13 = new javax.swing.JButton();
        jBBackspace = new javax.swing.JButton();
        jBExe = new javax.swing.JButton();

        jBR1B1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B1ActionPerformed(evt);
            }
        });

        jBR1B2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B2ActionPerformed(evt);
            }
        });

        jBR1B3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B3ActionPerformed(evt);
            }
        });

        jBR1B4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B4ActionPerformed(evt);
            }
        });

        jBR1B5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B5ActionPerformed(evt);
            }
        });

        jBR1B6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B6ActionPerformed(evt);
            }
        });

        jBR1B7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B7ActionPerformed(evt);
            }
        });

        jBR1B8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B8ActionPerformed(evt);
            }
        });

        jBR1B9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B9ActionPerformed(evt);
            }
        });

        jBR1B10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B10ActionPerformed(evt);
            }
        });

        jBR1B11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B11ActionPerformed(evt);
            }
        });

        jBR1B12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B12ActionPerformed(evt);
            }
        });

        jBR1B13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBR1B13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBR1B13ActionPerformed(evt);
            }
        });

        jBBackspace.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBBackspace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualkeyboard/images/backspace.gif"))); // NOI18N
        jBBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackspaceActionPerformed(evt);
            }
        });

        jBExe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBExe.setText("EXE");
        jBExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jBR1B1)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B2)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B3)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B4)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B5)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B6)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B7)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B8)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B9)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jBR1B11)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B12)
                        .addGap(5, 5, 5)
                        .addComponent(jBR1B13)
                        .addGap(5, 5, 5)
                        .addComponent(jBBackspace)
                        .addGap(106, 106, 106)
                        .addComponent(jBExe)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBR1B1)
                    .addComponent(jBR1B2)
                    .addComponent(jBR1B3)
                    .addComponent(jBR1B4)
                    .addComponent(jBR1B5)
                    .addComponent(jBR1B6)
                    .addComponent(jBR1B7)
                    .addComponent(jBR1B8)
                    .addComponent(jBR1B9)
                    .addComponent(jBR1B10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBBackspace)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBR1B11)
                                    .addComponent(jBR1B12)
                                    .addComponent(jBR1B13)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBExe)))
                .addGap(0, 143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBR1B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B1ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B1ActionPerformed

    private void jBR1B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B2ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B2ActionPerformed

    private void jBR1B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B3ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B3ActionPerformed

    private void jBR1B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B4ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B4ActionPerformed

    private void jBR1B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B5ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B5ActionPerformed

    private void jBR1B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B6ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B6ActionPerformed

    private void jBR1B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B7ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B7ActionPerformed

    private void jBR1B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B8ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B8ActionPerformed

    private void jBR1B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B9ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B9ActionPerformed

    private void jBR1B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B10ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B10ActionPerformed

    private void jBR1B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B11ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B11ActionPerformed

    private void jBR1B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B12ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B12ActionPerformed

    private void jBR1B13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBR1B13ActionPerformed
        writeValue(evt);
    }//GEN-LAST:event_jBR1B13ActionPerformed

    private void jBBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackspaceActionPerformed
        if(textComponent==null) return;
        //Delete char on caret position
        String text = textComponent.getText();
        int index = textComponent.getCaretPosition();
        if(index>0){
            text = new StringBuffer(text).delete(index-1,index).toString();
            textComponent.setText(text);
            textComponent.setCaretPosition(index-1);
        }
    }//GEN-LAST:event_jBBackspaceActionPerformed

    private void jBExeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExeActionPerformed
        if(window!=null){
            window.setVisible(false);
            window.dispose();
        }
    }//GEN-LAST:event_jBExeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBackspace;
    private javax.swing.JButton jBExe;
    private javax.swing.JButton jBR1B1;
    private javax.swing.JButton jBR1B10;
    private javax.swing.JButton jBR1B11;
    private javax.swing.JButton jBR1B12;
    private javax.swing.JButton jBR1B13;
    private javax.swing.JButton jBR1B2;
    private javax.swing.JButton jBR1B3;
    private javax.swing.JButton jBR1B4;
    private javax.swing.JButton jBR1B5;
    private javax.swing.JButton jBR1B6;
    private javax.swing.JButton jBR1B7;
    private javax.swing.JButton jBR1B8;
    private javax.swing.JButton jBR1B9;
    // End of variables declaration//GEN-END:variables
}
