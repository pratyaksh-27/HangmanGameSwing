package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow extends JFrame implements ActionListener{
    
	private static final long serialVersionUID = -222365088438922446L;

	JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    JLabel lblmsg,lblword;
    JPanel msg,display,keypad,line1,line2,line3;
//	 String word[] = {"CANADA","AUSTRALIA","AMERICA","INDIA" ,"SRILANKA"};
    String word[] = CountryNames.getCountryNames();
     int rand,len,flag=0,correct, wrong;
     Random rd;
     String ch,choice,temp;
     StringBuffer missed,blanks;
        
    public GameWindow(){
        
        rd = new Random();
        missed = new StringBuffer();
        blanks = new StringBuffer();
        correct = 0;
        wrong = 0;
        
        a = new JButton("A");       
        b = new JButton("B");       
        c = new JButton("C");       
        d = new JButton("D");       
        e = new JButton("E");       
        f = new JButton("F");       
        g = new JButton("G");       
        h = new JButton("H");       
        i = new JButton("I");       
        j = new JButton("J");       
        k = new JButton("K");       
        l = new JButton("L");       
        m = new JButton("M");       
        n = new JButton("N");       
        o = new JButton("O");       
        p = new JButton("P");       
        q = new JButton("Q");       
        r = new JButton("R");       
        s = new JButton("S");       
        t = new JButton("T");       
        u = new JButton("U");       
        v = new JButton("V");       
        w = new JButton("W");       
        x = new JButton("X");       
        y = new JButton("Y");       
        z = new JButton("Z"); 
        
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        i.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        q.addActionListener(this);
        r.addActionListener(this);
        s.addActionListener(this);
        t.addActionListener(this);
        u.addActionListener(this);
        v.addActionListener(this);
        w.addActionListener(this);
        x.addActionListener(this);
        y.addActionListener(this);
        z.addActionListener(this);
        
        lblmsg = new JLabel("Guess a Country Name");
        lblword = new JLabel("Word will be displayed here");
        
        msg = new JPanel();
        msg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        
        display = new JPanel();
        display.setBackground(Color.WHITE);
        display.setSize(0,200);
        
        keypad = new JPanel();
        keypad.setBackground(Color.darkGray);
        keypad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        
        line1 = new JPanel();
        line1.setBackground(Color.darkGray);
        
        line2 = new JPanel();
        line2.setBackground(Color.darkGray);
        
        line3 = new JPanel();
        line3.setBackground(Color.darkGray);
        
        setTitle("Play Game");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void addcomponent(){
        
        
        msg.setLayout(new FlowLayout());
        msg.add(lblmsg);
        
        
        display.setLayout(new FlowLayout());
        display.add(lblword);
        
        keypad.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        
        
        line1.setLayout(new FlowLayout());
        line1.add(q);
        line1.add(w);
        line1.add(e);
        line1.add(r);
        line1.add(t);
        line1.add(y);
        line1.add(u);
        line1.add(i);
        line1.add(o);
        line1.add(p);
        
        gb.gridx = 0;
        gb.gridy = 0;
        keypad.add(line1,gb);
        
        
        
        line2.setLayout(new FlowLayout());
        line2.add(a);
        line2.add(s);
        line2.add(d);
        line2.add(f);
        line2.add(g);
        line2.add(h);
        line2.add(j);
        line2.add(k);
        line2.add(l);
        
        gb.gridx = 0;
        gb.gridy = 1;
        keypad.add(line2,gb);
        
        
        
        line3.setLayout(new FlowLayout());
        line3.add(z);
        line3.add(x);
        line3.add(c);
        line3.add(v);
        line3.add(b);
        line3.add(n);
        line3.add(m);
        
        gb.gridx = 0;
        gb.gridy = 2;
        keypad.add(line3,gb);
                
        
        setLayout(new BorderLayout());
        add(msg, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        add(keypad, BorderLayout.SOUTH);
        

    }
    
    public void startgame(){
        addcomponent();
        rand = rd.nextInt(5);
        len = word[rand].length(); 
        for(int i = 0;i<len;i++)
             blanks.append("_ ");
        lblword.setText(blanks.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
               
         
         JButton jb = (JButton) e.getSource();
         String letter = e.getActionCommand();
         flag = 0;
         for (int i = 0; i<len; i++)
         {
             if(letter.charAt(0) == word[rand].charAt(i))
             {
                 flag = 1;
                 blanks.replace((i*2), (i*2)+1,letter);
                 correct++;
             }
         }
         
         if(flag == 1)
         {
             lblword.setText(blanks.toString());
             jb.setBackground(Color.green);
             jb.setEnabled(false);
         }
         else{
             jb.setBackground(Color.red);
             jb.setEnabled(false);
             wrong++;
         }
         
         if(correct == len)
         {
             JOptionPane.showMessageDialog(this,"You Have WON !!!");
             int res = JOptionPane.showConfirmDialog(this,"Do you want to Play Again?", "Restart Game", JOptionPane.YES_NO_OPTION);
             if(res == 0)
             {
                 GameWindow obj = new GameWindow();
                 obj.startgame();
                 this.dispose();
             }
             else{
                 
                 this.dispose();
					/* Menu ob = */new Menu();
                 }
         }
         if(wrong > 5)
         {
             JOptionPane.showMessageDialog(this,"Sorry, You Lost Your Chances!");
             int res = JOptionPane.showConfirmDialog(this,"Do you want to Play Again?", "Restart Game", JOptionPane.YES_NO_OPTION);
             if(res == 0)
             {
                 GameWindow obj = new GameWindow();
                 obj.startgame();
                 this.dispose();
             }
             else{
                 
                 this.dispose();
					/* Menu ob = */new Menu();
                 }
             
         }
     
    }
    
    
}