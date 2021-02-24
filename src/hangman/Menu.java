package hangman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame implements ActionListener{
    
	private static final long serialVersionUID = -22110772841847240L;
	JButton btn1,btn2,btn3;
    JLabel name;
    
    public Menu(){
        
        btn1 = new JButton("Play Game");
        btn2 = new JButton("View Instructions");
        btn3 = new JButton("Exit");
        name = new JLabel("HANGMAN");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        
        g.gridx = 0;
        g.gridy = 0;
        g.anchor = GridBagConstraints.CENTER;
        g.weighty = 0.1;
        add(name,g);
        
        g.gridx = 0;
        g.gridy = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        add(btn1,g);
        
        g.gridx = 0;
        g.gridy = 2;
        g.fill = GridBagConstraints.HORIZONTAL;
        add(btn2,g);
        
        g.gridx = 0;
        g.gridy = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        add(btn3,g);
        
        setTitle("Hangman Game");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1)
        {
            GameWindow obj = new GameWindow();
            obj.startgame();
            this.dispose();
        }
        else if(e.getSource() == btn2)
        {
            String msg = new String("1.You can guess the word by clicking on the character from the Virtual Keypad"
                    + "\n2.You will get maximum 5 Chances"
                    + "\n3.The incorrect guess will be highlighted RED"
                    + "\n4.The correct guess will be highlighted GREEN");
            JOptionPane.showMessageDialog(this,msg ,"Instructions", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource() == btn3)
        {
            System.exit(0);
        }
        
     }
    
    
}
