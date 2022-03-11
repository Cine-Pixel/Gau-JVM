import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.WindowConstants;

public class  MainForm extends JFrame {
    JTextField tfName;
    JLabel lbHello;

    public void init() {
        JLabel lbName = new JLabel("Name");
        tfName = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 5, 5));
        formPanel.add(lbName);
        formPanel.add(tfName);

        lbHello = new JLabel();

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = tfName.getText();                
                lbHello.setText("Hello " + Name);
            }

        });

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.add(btnOk);
        buttonsPanel.add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(lbHello, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Hello world");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        MainForm myForm = new MainForm();
        myForm.init();
    }
}
