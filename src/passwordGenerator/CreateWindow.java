package passwordGenerator;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWindow implements ActionListener {
    private JFrame mainWindow;
    private JPanel mainPanel, checkBoxPanel;
    private JTextField passwordField;
    private JCheckBox lower, upper, numbers, symbols, date;
    private JCheckBox[] passSettings = new JCheckBox[5];
    private JButton generate, copy;
    private JSpinner passwordLength;
    private JLabel title, spinnerText;

    public CreateWindow(){
        /**
         * creating main window app
         */

        mainWindow = new JFrame("Random password generator");
        mainWindow.setSize(550,350);
        mainWindow.setResizable(false);
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(3);
        mainWindow.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(20,17,61));
        mainPanel.setBounds(0,0,550,350);
        mainPanel.setLayout(null);

        checkBoxPanel = new JPanel();
        checkBoxPanel.setBackground(new Color(59, 32, 32));
        checkBoxPanel.setBounds(355,105,150,180);
        checkBoxPanel.setLayout(null);

        upper=new JCheckBox("Upper letters");
        upper.setBounds(0,0,150,36);
        upper.setOpaque(false);
        upper.setForeground(Color.white);

        lower = new JCheckBox("Lower letters");
        lower.setBounds(0,36,150,36);
        lower.setOpaque(false);
        lower.setForeground(Color.white);

        numbers = new JCheckBox("Numbers");
        numbers.setBounds(0,72,150,36);
        numbers.setOpaque(false);
        numbers.setForeground(Color.white);

        symbols = new JCheckBox("Special symbols");
        symbols.setBounds(0,108,150,36);
        symbols.setOpaque(false);
        symbols.setForeground(Color.white);

        date = new JCheckBox("Date");
        date.setBounds(0,144,150,36);
        date.setOpaque(false);
        date.setForeground(Color.white);

        generate = new JButton("Generate");
        generate.addActionListener(this);
        generate.setBounds(30,235,135,50);

        copy = new JButton("Copy");
        copy.addActionListener(this);
        copy.setBounds(200,235,135,50);

        passSettings[0] = upper;
        passSettings[1] = lower;
        passSettings[2] = numbers;
        passSettings[3] = symbols;
        passSettings[4] = date;

        passwordLength = new JSpinner(new SpinnerNumberModel(8,8,64,1));
        passwordLength.setBounds(260,120,50,20);

        spinnerText = new JLabel("Password length:");
        spinnerText.setForeground(Color.white);
        spinnerText.setBounds(240,100,150,20);

        title = new JLabel("<html>RANDOM<br/>    PASSWORD<br/> GENERATOR\n</html>", SwingConstants.CENTER);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial",Font.BOLD,20));

        title.setBounds(-30,100,250,90);

        checkBoxPanel.add(upper);
        checkBoxPanel.add(lower);
        checkBoxPanel.add(numbers);
        checkBoxPanel.add(symbols);
        checkBoxPanel.add(date);


        passwordField = new JTextField();
        passwordField.setEditable(false);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        passwordField.setBounds(30,30,475,45);

        mainPanel.add(title);
        mainPanel.add(spinnerText);
        mainPanel.add(passwordLength);
        mainPanel.add(generate);
        mainPanel.add(copy);
        mainPanel.add(checkBoxPanel);
        mainWindow.add(passwordField);
        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == generate){
            GeneratePassword sendPass = new GeneratePassword();
            String passText = sendPass.GeneratePassword(passSettings, (Integer) passwordLength.getValue());
            passwordField.setText(passText);
        }

        if(e.getSource() == copy){
            StringSelection s = new StringSelection(passwordField.getText());
            Clipboard copy = Toolkit.getDefaultToolkit().getSystemClipboard();
            copy.setContents(s, null);
        }
    }

}
