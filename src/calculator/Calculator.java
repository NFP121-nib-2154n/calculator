package calculator;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener {
    static JFrame f;
    static JPanel p1,p2,p3,p4,p5;
    static JPanel textfield, numbers, operators;
    static JTextField l;
    String s0, s1, s2;
    
    Calculator(){
        s0 = s1 = s2 = "";
    }
    
public static void main(String[] args) {
    f = new JFrame("Calculator");
    f.setLayout(new GridLayout());
//    f.setLayout(new FlowLayout());
    
    try {
        // set look and feel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
        System.err.println(e.getMessage());
    }
    
    Calculator c = new Calculator();
    l = new JTextField(16);
    l.setEditable(false);
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
    
    b0 = new JButton("0");
    b1 = new JButton("1");
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");
    beq1 = new JButton("=");
    ba = new JButton("+");
    bs = new JButton("-");
    bd = new JButton("/");
    bm = new JButton("*");
    beq = new JButton("C");
    be = new JButton(".");
   
    JPanel p = new JPanel();
    JPanel textfield = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel numbers = new JPanel();
    JPanel operators = new JPanel();
    numbers.setLayout(new GridLayout(4,0));
    p5.setLayout(new GridLayout(5,0));

    bm.addActionListener(c);
    bd.addActionListener(c);
    bs.addActionListener(c);
    ba.addActionListener(c);
    b9.addActionListener(c);
    b8.addActionListener(c);
    b7.addActionListener(c);
    b6.addActionListener(c);
    b5.addActionListener(c);
    b4.addActionListener(c);
    b3.addActionListener(c);
    b2.addActionListener(c);
    b1.addActionListener(c);
    b0.addActionListener(c);
    be.addActionListener(c);
    beq.addActionListener(c);
    beq1.addActionListener(c);
    
    textfield.add(l); // textfield
    
    p1.add(b1); // 1
    p1.add(b2); // 2
    p1.add(b3); // 3
    p.add(p1);
    p5.add(beq); // C
    
    p2.add(b4); // 4
    p2.add(b5); // 5
    p2.add(b6); // 6
    p.add(p2);
    p5.add(ba); // +
    
    p3.add(b7); // 7
    p3.add(b8); // 8 
    p3.add(b9); // 9
    p.add(p3);
    p5.add(bs); // -
    p5.add(bm); // *
    
    p4.add(b0); // 0
    p4.add(be); // .
    p4.add(beq1); // =
    p.add(p4);
    p5.add(bd); // /
    p.add(p5);
    
    numbers.add(p1);
    numbers.add(p2);
    numbers.add(p3);
    numbers.add(p4);
    operators.add(p5);
    
    p.add(textfield);
    p.add(numbers);
    p.add(operators);
    
    p.setBackground(Color.white);
    p1.setBackground(Color.white);
    p2.setBackground(Color.white);
    p3.setBackground(Color.white);
    p4.setBackground(Color.white);
    textfield.setBackground(Color.white);
    numbers.setBackground(Color.white);
    operators.setBackground(Color.white);
    f.add(p);
    f.setSize(250, 240);
    f.show();   
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

 public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
 
    if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
        if (!s1.equals(""))
            s2 = s2 + s;
        else
            s0 = s0 + s;
 
        l.setText(s0 + s1 + s2);
        }
    
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
 
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {
 
            double te;
 
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
            l.setText(s0 + s1 + s2 + "=" + te);
 
            s0 = Double.toString(te);
 
            s1 = s2 = "";
        }
        else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;
 
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
                s0 = Double.toString(te);
 
                s1 = s;
 
                s2 = "";
            }
 
            l.setText(s0 + s1 + s2);
        }
    }
}
