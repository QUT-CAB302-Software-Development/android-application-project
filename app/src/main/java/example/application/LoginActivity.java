package example.application;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import example.data.StaticUserDAO;
import example.data.User;

/**
 * Represents the login view of the application.
 */
public class LoginActivity extends AppCompatActivity {
    // Declare class variables for the views
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;
    private EditText nameEditText;

    // Declare class variables for the DAO and current user
    private final StaticUserDAO staticUserDAO = new StaticUserDAO();
    private User currentUser;
    private boolean isRegistering = false;

    /**
     * Creates the login view.
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the views
        emailEditText = findViewById(R.id.email_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        nameEditText = findViewById(R.id.name_edittext);

        // Set up a click listener for the login button
        loginButton.setOnClickListener(v -> onLoginButtonClick());
        // Set up a click listener for the register button
        registerButton.setOnClickListener(v -> onRegisterButtonClick());
    }

    /**
     * Event handler for the register button click event.
     */
    private void onRegisterButtonClick() {
        // Disable the register button
        registerButton.setEnabled(false);

        // Show the name EditText
        nameEditText.setVisibility(View.VISIBLE);

        // Set the focus to the name EditText
        nameEditText.requestFocus();

        // Disable the email and password EditTexts
        emailEditText.setEnabled(false);
        passwordEditText.setEnabled(false);

        // Get the email and password from the EditTexts
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Add the user to the database
        staticUserDAO.addUser(new User("", password, email));

        // Set the isRegistering flag to true
        isRegistering = true;

        // Show the soft keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(nameEditText, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * Event handler for the login button click event.
     */
    private void onLoginButtonClick(){
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        boolean success = isRegistering ? logIn(email, password, nameEditText.getText().toString()) : logIn(email, password);

        if (success) {
            // Transition to the main view
            launchMainView();
            finish();
        } else {
            // Show an error message
            Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Logs the newly registered user in.
     * @param email the email
     * @param password the password
     * @param name the name
     * @return true if the user was logged in, false otherwise
     */
    private boolean logIn(String email, String password, String name){
        // Check if the email and password match a registered user.
        for (User user : staticUserDAO.listUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
            }
        }
        // If so, if the name is not empty, update the user's name and log the user in.
        if (currentUser != null) {
            if (!name.isEmpty()) {
                currentUser.setName(name);
                staticUserDAO.updateUser(currentUser);
            }
            // Always log the user in.
            return true;
        }
        return false;
    }

    /**
     * Logs the user in.
     * @param email the email
     * @param password the password
     * @return true if the user was logged in, false otherwise
     */
    private boolean logIn(String email, String password) {
        for (User user : staticUserDAO.listUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * Launches the main view.
     */
    private void launchMainView() {
        Intent intent = new Intent(this, MainViewActivity.class);
        intent.putExtra("CURRENT_USER", currentUser.getName());
        startActivity(intent);
    }
}