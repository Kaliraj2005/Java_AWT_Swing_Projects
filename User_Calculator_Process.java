package AWT_Swing_Projects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
public class User_Calculator_Process implements ActionListener
{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myfont=  new Font("Bold",Font.BOLD,25);

    double num1=0,num2=0,result=0;
    char operator;

    public User_Calculator_Process()
    {
        frame = new JFrame("User Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myfont);
        textField.setEditable(false);
        textField.setBackground(Color.CYAN);
        textField.setCaretColor(Color.black);

        addButton = new JButton("+");
        addButton.setBackground(Color.GREEN);
        subButton = new JButton("-");
        subButton.setBackground(Color.GREEN);
        mulButton = new JButton("*");
        mulButton.setBackground(Color.GREEN);
        divButton = new JButton("/");
        divButton.setBackground(Color.GREEN);
        decButton = new JButton(".");
        decButton.setBackground(Color.GREEN);
        equButton = new JButton("=");
        equButton.setBackground(Color.GREEN);

        delButton = new JButton("DEL");
        delButton.setBackground(Color.RED);
        clrButton = new JButton("CLR");
        clrButton.setBackground(Color.MAGENTA);
        negButton = new JButton("(-)");
        negButton.setBackground(Color.YELLOW);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0;i<9;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.darkGray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0;i<10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton)
        {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble((textField.getText()));
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble((textField.getText()));
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble((textField.getText()));
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble((textField.getText()));
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton)
        {
            num2=Double.parseDouble(textField.getText());
            switch(operator)
            {
                case '+':
                    result=num1+num2;
                    break;

                case '-':
                    result=num1-num2;
                    break;

                case '*':
                    result=num1*num2;
                    break;

                case '/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource() == clrButton)
        {
            textField.setText("");
        }
        if(e.getSource() == delButton)
        {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++)
            {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negButton)
        {
            Double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
    public static void main(String args[])
    {
        User_Calculator_Process object = new User_Calculator_Process();
    }
}
