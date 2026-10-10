import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLoginPreferences extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeCheckbox, recieveNotificationsCheckbox;
    private JButton loginButton;

    public UserLoginPreferences() {
        setTitle("User Login System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        rememberMeCheckbox = new JCheckBox("Remember Me");
        recieveNotificationsCheckbox = new JCheckBox("Receive Notifications");
        loginButton = new JButton("Login");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(rememberMeCheckbox);
        add(recieveNotificationsCheckbox);
        add(new JLabel("")); add(loginButton); // Empty label for spacing
        add(new JLabel("")); add(new JLabel("")); // Empty labels for spacing

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean rememberMe = rememberMeCheckbox.isSelected();
                boolean recieveNotifications = recieveNotificationsCheckbox.isSelected();

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(UserLoginPreferences.this,
                     "Login successful!\n\nWelcome, %s\nRemember Me: %s\nReceive Notifications: %s".formatted(
                         username, rememberMe, recieveNotifications),
                        "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(UserLoginPreferences.this, "Invalid username or password."
                    , "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
                // Handle login logic here
                JOptionPane.showMessageDialog(UserLoginPreferences.this, "Login attempted for user: " + username);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserLoginPreferences frame = new UserLoginPreferences();
            frame.setVisible(true);
        });
    }
}