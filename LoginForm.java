import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LoginForm.java
 *
 * A simple login form UI built with Swing, following the described design:
 * - Title label "Login Page"
 * - Username label and text field (usernameField)
 * - Password label and password field (passwordField)
 * - Login button (loginButton)
 * - Proper alignment and spacing using GroupLayout
 * - Window size 400x300 and centered on screen
 */
public class LoginForm extends JFrame {

    // Components declaration
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        initComponents();
        setTitle("Login Application");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the form on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // Initialize components
        titleLabel = new JLabel("Login Page", SwingConstants.CENTER);
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Set fonts and tooltips
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameField.setToolTipText("Enter your username");
        passwordField.setToolTipText("Enter your password");

        // Set preferred sizes for text fields (~200px width)
        Dimension textFieldDim = new Dimension(200, usernameField.getPreferredSize().height);
        usernameField.setPreferredSize(textFieldDim);
        passwordField.setPreferredSize(textFieldDim);

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });

        // Use GroupLayout as the layout manager for the content pane
        Container contentPane = getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        layout.setAutoCreateGaps(true);    // Enable automatic gaps
        layout.setAutoCreateContainerGaps(true); // gaps between container edges and components

        // Create horizontal group
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(
                    layout.createSequentialGroup()
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel)
                        )
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                )
                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );

        // Create vertical group
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(24)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(16)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(32)
                .addComponent(loginButton)
        );
    }

    private void loginButtonActionPerformed(ActionEvent e) {
        // Placeholder for login logic
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        JOptionPane.showMessageDialog(this,
                "Login button clicked.\nUsername: " + username + "\nPassword length: " + password.length,
                "Login Action",
                JOptionPane.INFORMATION_MESSAGE);
        // Clear password for security
        java.util.Arrays.fill(password, '0');
    }

    public static void main(String[] args) {
        // Launch the application on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm form = new LoginForm();
                form.setVisible(true);
            }
        });
    }
}

