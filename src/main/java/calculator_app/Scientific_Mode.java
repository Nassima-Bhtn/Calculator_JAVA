/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_app;

import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


/**
 *
 * @author nassimabenbahtane
 */
public class Scientific_Mode extends javax.swing.JFrame {

    
    // init variables
    public double num,ans;
    
    
    // constractor
    public Scientific_Mode() {
        initComponents();
    }
    
    
    // methode to verify if the brackers are balanced or not
    static boolean BracketsBalance(String equa) {
        if(!(equa.contains("(")) && !(equa.contains(")"))){ return true;}   // make sure that the input has brackets in the first place
        Deque<Character> stack = new ArrayDeque<Character>();               // array to store the occurence of the brackets 
        for (int i = 0; i < equa.length(); i++)  { 
            char x = equa.charAt(i); 
            if (x == '(')  { 
                stack.push(x);                   // when an open bracket is found, add it to the array
                continue; 
            } 
            if (x == ')')  { stack.pop(); }      // when a closing bracket is found, remove one open bracket 
        } 
        return (stack.isEmpty());                // return true if all open brackets are removed from the array
    } 
    

    
    // methode that returns a number or equation between brackests 
    public  String betweenBrackets(String s) {
        StringBuilder calc = new StringBuilder();                   // variable to store the result 

        if (s.contains(")")){                                       // in the presence of brackets get the string inside 
          return s.substring(s.indexOf("(")+1,s.indexOf(")"));
        }else{                                                      // in the absence of bracket we only need a double value 
          for(int i = s.length()-1; i>=0; i--){
              if (Character.isDigit(s.charAt(i)) == true || (s.charAt(i) == '.' )){  // make sure we get only the double
                        calc.append(s.charAt(i));                                    // add it to the return variable
              }else{ break; }
                }
            return calc.reverse().toString();
        } 

    }

    // methode to get the last number before the operation required 
    public String getNumberBefor(String str, String ch) {
      String nb = str.substring(0,str.indexOf(ch));          //stop at the operation  
      for (int i = nb.length()-1; i>=0; i--){
        if ( nb.charAt(i) == '(' ){                         // stop at the open bracket
           nb = nb.substring(i);
           break;
         }
       }
      return betweenBrackets(nb);                           // return the value before the operation 
    }
    
    // methode to solve for the value between brackets before applying the new operator 
    public String solveNumberBefor(String str, String ch) throws ScriptException{
      String operOf = getNumberBefor(str, ch);
      String resu = mathematic(textToMath(operOf));
      return betweenBrackets(resu);
    }

    public  String getNumberAfter(String str, String ch) throws ScriptException{
      String nb = str.substring(str.indexOf(ch)+1);
      return betweenBrackets(nb);
    }
    
    public  String solveNumberAfter(String str, String ch) throws ScriptException{
      String nb = getNumberAfter(str, ch);
      String resu = mathematic(textToMath(nb));
      return betweenBrackets(resu);
    }
    

    // methode that calls an egine to solve mathematical equations 
    public String mathematic(String equation) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("Nashorn");
        //ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object obje = engine.eval(equation);
        return obje.toString();
    }
    
    
    // methode to calculate factorial 
     public double factorial(double n){ 
        double fact = 1;
        if (n == 0) {return 1;}    
        else { 
            for (double i = n; i > 0; i--){
                fact = fact * i ;
            }
            if ((fact % 1) == 0) { return fact ; }       // factorial for int values 
            else{ return fact * Math.sqrt(Math.PI);}     // factorial for non integer values     
        }   
    }  
 
      // methode to calculate power 
     public double power(double n, double p){
         return Math.pow(n, p); 
     }
     
     // methode to convert the functions in the textfeald to their equavalent in java in order to perform them 
    public String textToMath(String s){
        if (s.contains("cos(") || s.contains("sin(") || s.contains("log(")
                || s.contains("sqrt(")  || s.contains("π") || s.contains("abs") 
                || s.contains("tan(") || s.contains("E") || s.contains("exp(")
                 ){
            s = s.replace("cos(", "Math.cos(");
            s = s.replace("sin(", "Math.sin(");
            s = s.replace("tan(", "Math.tan("); 
            s = s.replace("log(", "Math.log(");
            s = s.replace("sqrt(", "Math.sqrt(");
            s = s.replace("π", "Math.PI");
            s = s.replace("E", "Math.E");
            s = s.replace("exp(", "Math.exp(");
            s = s.replace("abs(", "Math.abs(");
            
          
        }
        
        return s;
    }
    
    
    // seconde methode to convert the functions in the textfeald to the methods implemented in order to perform them 
    public String textToMath2(String s) throws ScriptException {
        
        if (s.contains(")!") ){
           s = s.replace("("+ getNumberBefor(s,"!")+")!",Double.toString(factorial( Double.parseDouble(solveNumberBefor(s, "!")))) );
        }else if (s.contains("!") ){
           s = s.replace(getNumberBefor(s,"!")+"!",Double.toString(factorial( Double.parseDouble(solveNumberBefor(s, "!")))) );
        }

        if (s.contains(")^(") ) {
               s = s.replace("("+ getNumberBefor(s, "^(") + ")^("+ getNumberAfter(s, "^(") + ")" ,Double.toString(power(Double.parseDouble(solveNumberBefor(s, "^(")),Double.parseDouble(solveNumberAfter(s, "^(")))));
        }else if (s.contains("^(") ) {
               s = s.replace(getNumberBefor(s, "^(") + "^("+ getNumberAfter(s, "^(") + ")" ,Double.toString(power(Double.parseDouble(solveNumberBefor(s, "^(")),Double.parseDouble(solveNumberAfter(s, "^(")))));
        }
        
       return s; 
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlusMinus_ = new javax.swing.JButton();
        jButton4_ = new javax.swing.JButton();
        Equal_ = new javax.swing.JButton();
        jButton5_ = new javax.swing.JButton();
        DisplayField = new javax.swing.JTextField();
        jButton6_ = new javax.swing.JButton();
        AC_ = new javax.swing.JButton();
        Minus = new javax.swing.JButton();
        Del_ = new javax.swing.JButton();
        jButton1_ = new javax.swing.JButton();
        modulo_ = new javax.swing.JButton();
        jButton2_ = new javax.swing.JButton();
        Div_ = new javax.swing.JButton();
        jButton3_ = new javax.swing.JButton();
        jButton7_ = new javax.swing.JButton();
        Add_ = new javax.swing.JButton();
        jButton8_ = new javax.swing.JButton();
        jButton0_ = new javax.swing.JButton();
        jButton9_ = new javax.swing.JButton();
        Point_ = new javax.swing.JButton();
        Mul_ = new javax.swing.JButton();
        factorial_ = new javax.swing.JButton();
        sin_ = new javax.swing.JButton();
        power2_ = new javax.swing.JButton();
        sqrt_ = new javax.swing.JButton();
        exp_ = new javax.swing.JButton();
        PI_ = new javax.swing.JButton();
        abs_ = new javax.swing.JButton();
        E_ = new javax.swing.JButton();
        cos_ = new javax.swing.JButton();
        power_ = new javax.swing.JButton();
        leftBracket_ = new javax.swing.JButton();
        power3_ = new javax.swing.JButton();
        rightBracket_ = new javax.swing.JButton();
        log_ = new javax.swing.JButton();
        tan_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        Normal = new javax.swing.JMenuItem();
        Scientific = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PlusMinus_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        PlusMinus_.setText("+/-");
        PlusMinus_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusMinus_ActionPerformed(evt);
            }
        });

        jButton4_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton4_.setText("4");
        jButton4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_ActionPerformed(evt);
            }
        });

        Equal_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Equal_.setText("=");
        Equal_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Equal_ActionPerformed(evt);
            }
        });

        jButton5_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton5_.setText("5");
        jButton5_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_ActionPerformed(evt);
            }
        });

        DisplayField.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
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

        jButton6_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton6_.setText("6");
        jButton6_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6_ActionPerformed(evt);
            }
        });

        AC_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        AC_.setText("AC");
        AC_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AC_ActionPerformed(evt);
            }
        });

        Minus.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Minus.setText("-");
        Minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusActionPerformed(evt);
            }
        });

        Del_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Del_.setText("Del");
        Del_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_ActionPerformed(evt);
            }
        });

        jButton1_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton1_.setText("1");
        jButton1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });

        modulo_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        modulo_.setText("%");
        modulo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modulo_ActionPerformed(evt);
            }
        });

        jButton2_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton2_.setText("2");
        jButton2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_ActionPerformed(evt);
            }
        });

        Div_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Div_.setText("÷");
        Div_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Div_ActionPerformed(evt);
            }
        });

        jButton3_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton3_.setText("3");
        jButton3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_ActionPerformed(evt);
            }
        });

        jButton7_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton7_.setText("7");
        jButton7_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_ActionPerformed(evt);
            }
        });

        Add_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Add_.setText("+");
        Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ActionPerformed(evt);
            }
        });

        jButton8_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton8_.setText("8");
        jButton8_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8_ActionPerformed(evt);
            }
        });

        jButton0_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton0_.setText("0");
        jButton0_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0_ActionPerformed(evt);
            }
        });

        jButton9_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jButton9_.setText("9");
        jButton9_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9_ActionPerformed(evt);
            }
        });

        Point_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        Point_.setText(",");
        Point_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Point_ActionPerformed(evt);
            }
        });

        Mul_.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        Mul_.setText("x");
        Mul_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mul_ActionPerformed(evt);
            }
        });

        factorial_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        factorial_.setText("x!");
        factorial_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorial_ActionPerformed(evt);
            }
        });

        sin_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        sin_.setText("sin");
        sin_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sin_ActionPerformed(evt);
            }
        });

        power2_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        power2_.setText("x^2");
        power2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                power2_ActionPerformed(evt);
            }
        });

        sqrt_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        sqrt_.setText("√x");
        sqrt_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqrt_ActionPerformed(evt);
            }
        });

        exp_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        exp_.setText("EXP");
        exp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exp_ActionPerformed(evt);
            }
        });

        PI_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        PI_.setText("π");
        PI_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PI_ActionPerformed(evt);
            }
        });

        abs_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        abs_.setText("abs");
        abs_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abs_ActionPerformed(evt);
            }
        });

        E_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        E_.setText("E");
        E_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_ActionPerformed(evt);
            }
        });

        cos_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        cos_.setText("cos");
        cos_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cos_ActionPerformed(evt);
            }
        });

        power_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        power_.setText("x^y");
        power_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                power_ActionPerformed(evt);
            }
        });

        leftBracket_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        leftBracket_.setText("(");
        leftBracket_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBracket_ActionPerformed(evt);
            }
        });

        power3_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        power3_.setText("x^3");
        power3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                power3_ActionPerformed(evt);
            }
        });

        rightBracket_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        rightBracket_.setText(")");
        rightBracket_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBracket_ActionPerformed(evt);
            }
        });

        log_.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        log_.setText("log");
        log_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_ActionPerformed(evt);
            }
        });

        tan_.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        tan_.setText("tan");
        tan_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tan_ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayField)
                    .addGroup(layout.createSequentialGroup()
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
                                .addComponent(Equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(power_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leftBracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightBracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(abs_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cos_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(power3_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(factorial_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sin_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(power2_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(log_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tan_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(sqrt_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(exp_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PI_, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DisplayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(Equal_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(factorial_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sin_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power2_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abs_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cos_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power3_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(log_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tan_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sqrt_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exp_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PI_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(power_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leftBracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rightBracket_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlusMinus_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusMinus_ActionPerformed
         jLabel1.setText(jLabel1.getText() + "-"); 
    }//GEN-LAST:event_PlusMinus_ActionPerformed

    private void jButton4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "4");
    }//GEN-LAST:event_jButton4_ActionPerformed

    private void Equal_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Equal_ActionPerformed
        try {
            String eq = textToMath2(textToMath(jLabel1.getText()));
            if (BracketsBalance(eq)== true){

                    var result = Double.parseDouble(mathematic(eq));
                    DisplayField.setText("=" + Normal_Mode.Display_doubleORint(result)); 

            }else{
                DisplayField.setText("please check your ()");
            }
        }catch (ScriptException ex) {
                Logger.getLogger(Scientific_Mode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Equal_ActionPerformed

    private void jButton5_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "5");
    }//GEN-LAST:event_jButton5_ActionPerformed

    private void DisplayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayFieldActionPerformed

    private void DisplayFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_DisplayFieldKeyTyped

    private void jButton6_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "6");
    }//GEN-LAST:event_jButton6_ActionPerformed

    private void AC_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AC_ActionPerformed
        DisplayField.setText("0");
        jLabel1.setText("");
    }//GEN-LAST:event_AC_ActionPerformed

    private void Del_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Del_ActionPerformed
        if (jLabel1.getText().length() > 0){                            // Make sure the text feide aint empty
            StringBuilder text = new StringBuilder(jLabel1.getText());  // fill the buffer with the String input
            text.deleteCharAt(jLabel1.getText().length() - 1);          // delete the character at the last index
            jLabel1.setText(text.toString());               // convert the result back to a String and display it
        }
    }//GEN-LAST:event_Del_ActionPerformed

    private void jButton1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "1");
    }//GEN-LAST:event_jButton1_ActionPerformed

    private void jButton2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "2");
    }//GEN-LAST:event_jButton2_ActionPerformed

    private void jButton3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "3");
    }//GEN-LAST:event_jButton3_ActionPerformed

    private void jButton7_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "7");
    }//GEN-LAST:event_jButton7_ActionPerformed

    private void Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "+");
    }//GEN-LAST:event_Add_ActionPerformed

    private void jButton8_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "8");
    }//GEN-LAST:event_jButton8_ActionPerformed

    private void jButton0_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "0");
    }//GEN-LAST:event_jButton0_ActionPerformed

    private void jButton9_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "9");
    }//GEN-LAST:event_jButton9_ActionPerformed

    private void Point_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Point_ActionPerformed
        if (jLabel1.getText().length() > 0) {
            jLabel1.setText(jLabel1.getText() + ".");
        }else{
            jLabel1.setText("0.");
        }
    }//GEN-LAST:event_Point_ActionPerformed

    private void NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NormalActionPerformed
        this.dispose();
        Normal_Mode obj = new Normal_Mode();
        obj.setVisible(true);
    }//GEN-LAST:event_NormalActionPerformed

    private void ScientificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScientificActionPerformed

    }//GEN-LAST:event_ScientificActionPerformed

    private void sin_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sin_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "sin(");
    }//GEN-LAST:event_sin_ActionPerformed

    private void sqrt_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqrt_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "sqrt(");
    }//GEN-LAST:event_sqrt_ActionPerformed

    private void PI_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PI_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "π");
    }//GEN-LAST:event_PI_ActionPerformed

    private void E_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "E");
    }//GEN-LAST:event_E_ActionPerformed

    private void cos_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cos_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "cos(");
    }//GEN-LAST:event_cos_ActionPerformed

    private void log_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "log(");
    }//GEN-LAST:event_log_ActionPerformed

    private void tan_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tan_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "tan(");
    }//GEN-LAST:event_tan_ActionPerformed

    private void rightBracket_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBracket_ActionPerformed
        jLabel1.setText(jLabel1.getText() + ")");
    }//GEN-LAST:event_rightBracket_ActionPerformed

    private void modulo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modulo_ActionPerformed
        jLabel1.setText(jLabel1.getText() +"%");
    }//GEN-LAST:event_modulo_ActionPerformed

    private void Div_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Div_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "/");
    }//GEN-LAST:event_Div_ActionPerformed

    private void Mul_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mul_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "*");
    }//GEN-LAST:event_Mul_ActionPerformed

    private void MinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusActionPerformed
        jLabel1.setText(jLabel1.getText() + "-");
    }//GEN-LAST:event_MinusActionPerformed

    private void leftBracket_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBracket_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "(");
    }//GEN-LAST:event_leftBracket_ActionPerformed

    private void factorial_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factorial_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "!");
        
    }//GEN-LAST:event_factorial_ActionPerformed

    private void power2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_power2_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "^(2)");
    }//GEN-LAST:event_power2_ActionPerformed

    private void power3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_power3_ActionPerformed
       jLabel1.setText(jLabel1.getText() + "^(3)");
    }//GEN-LAST:event_power3_ActionPerformed

    private void power_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_power_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "^(");
    }//GEN-LAST:event_power_ActionPerformed

    private void exp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exp_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "exp(");
    }//GEN-LAST:event_exp_ActionPerformed

    private void abs_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abs_ActionPerformed
        jLabel1.setText(jLabel1.getText() + "abs(");
    }//GEN-LAST:event_abs_ActionPerformed

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
            java.util.logging.Logger.getLogger(Scientific_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scientific_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scientific_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scientific_Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scientific_Mode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AC_;
    private javax.swing.JButton Add_;
    private javax.swing.JButton Del_;
    private javax.swing.JTextField DisplayField;
    private javax.swing.JButton Div_;
    private javax.swing.JButton E_;
    private javax.swing.JButton Equal_;
    private javax.swing.JButton Minus;
    private javax.swing.JButton Mul_;
    private javax.swing.JMenuItem Normal;
    private javax.swing.JButton PI_;
    private javax.swing.JButton PlusMinus_;
    private javax.swing.JButton Point_;
    private javax.swing.JMenuItem Scientific;
    private javax.swing.JButton abs_;
    private javax.swing.JButton cos_;
    private javax.swing.JButton exp_;
    private javax.swing.JButton factorial_;
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
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton leftBracket_;
    private javax.swing.JButton log_;
    private javax.swing.JButton modulo_;
    private javax.swing.JButton power2_;
    private javax.swing.JButton power3_;
    private javax.swing.JButton power_;
    private javax.swing.JButton rightBracket_;
    private javax.swing.JButton sin_;
    private javax.swing.JButton sqrt_;
    private javax.swing.JButton tan_;
    // End of variables declaration//GEN-END:variables
}
