package pl.javakurselo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame{

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 400;
    private final Color LOGIN_FAILURE = Color.RED;
    private final Color LOGIN_SUCCESSFUL = Color.GREEN;
    private final Color DEFAULT_COLOR = Color.WHITE;
    private ImageIcon imageIcon = new ImageIcon("F:\\JDK\\lab3_\\src\\pl\\javakurselo\\wiit.jpg");
    private ImageIcon imageA = new ImageIcon("F:\\JDK\\lab3_\\src\\pl\\javakurselo\\approved.jpg");
    private ImageIcon imageD = new ImageIcon("F:\\JDK\\lab3_\\src\\pl\\javakurselo\\denied.jpg");
    private ImageIcon graphicIcon = new ImageIcon("F:\\JDK\\lab3_\\src\\pl\\javakurselo\\poziomo_pwr.jpg");
    private JLabel graphic;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private DataBase usersDataBase = new DataBase();

    LoginFrame() {
        //graphic
        graphic = new JLabel();
        graphic.setIcon(graphicIcon);
        graphic.setBounds(113,18,274,64);

        //login
        loginLabel = new JLabel("ID:");
        loginLabel.setBounds(90,120,75,25);
        loginLabel.setHorizontalAlignment(JLabel.RIGHT);

        loginField = new JTextField();
        loginField.setBounds(180,120,150,25);
        loginField.setBorder(BorderFactory.createLineBorder(Color.black,1));

        //password
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(90,170,75,25);
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);

        passwordField = new JPasswordField();
        passwordField.setBounds(180,170,150,25);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black,1));

        //buttons
        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.addActionListener(e -> loginStatus(e));
        loginButton.setBounds(260,230,100,30);

        cancelButton = new JButton("Cancel");
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(e -> cancelLogin());
        cancelButton.setBounds(140,230,100,30);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Login System");
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(imageIcon.getImage());

        this.getRootPane().setDefaultButton(loginButton);

        this.add(loginLabel);
        this.add(passwordLabel);
        this.add(loginField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(cancelButton);
        this.add(graphic);

        this.setVisible(true);

        initializeDateBase();
    }

    private void initializeDateBase() {
        usersDataBase.usersDataBase();
    }

    private void loginStatus(ActionEvent e) {
        String loginInput = loginField.getText();
        String passwordInput = String.valueOf(passwordField.getPassword());

        if(usersDataBase.getAllUsers().containsKey(loginInput)) {
            if(usersDataBase.getAllUsers().get(loginInput).equals(passwordInput)) {
                loginSuccessful();
            }
            else loginFailure();
        }
        else loginFailure();
    }

    private void loginSuccessful() {
        getContentPane().setBackground(LOGIN_SUCCESSFUL);
        JOptionPane.showMessageDialog(this, "Correct login and password", "Access approved", JOptionPane.INFORMATION_MESSAGE, imageA);
        getContentPane().setBackground(DEFAULT_COLOR);
        clearFields();
    }

    private void loginFailure() {
        getContentPane().setBackground(LOGIN_FAILURE);
        JOptionPane.showMessageDialog(this, "Incorrect login or password", "Access denied", JOptionPane.WARNING_MESSAGE, imageD);
        getContentPane().setBackground(DEFAULT_COLOR);
        clearFields();
    }

    private void clearFields() {
        loginField.setText("");
        passwordField.setText("");
    }

    private void cancelLogin() {
        System.exit(0);
    }
}

