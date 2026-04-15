import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel uLabel = new JLabel("Username:");
        uLabel.setBounds(20, 20, 80, 25);
        add(uLabel);

        userField = new JTextField();
        userField.setBounds(100, 20, 150, 25);
        add(userField);

        JLabel pLabel = new JLabel("Password:");
        pLabel.setBounds(20, 60, 80, 25);
        add(pLabel);

        passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);
        add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 100, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                new QuizApp(username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}