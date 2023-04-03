package example.application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import example.data.StaticUserDAO;
import example.data.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main view of the application.
 */
public class MainViewActivity extends AppCompatActivity {
    private StaticUserDAO staticUserDAO = new StaticUserDAO();
    // Declare class variables for the views
    private TextView currentUserTextView;
    private Button logoutButton;
    private ListView usersListView;
    private ArrayAdapter<User> usersAdapter;

    /**
     * Creates the main view.
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        // Initialize the views
        currentUserTextView = findViewById(R.id.current_user_textview);
        logoutButton = findViewById(R.id.logout_button);
        usersListView = findViewById(R.id.users_listview);

        // Retrieve the current logged in user from the Intent extras
        Intent intent = getIntent();
        String currentUser = intent.getStringExtra("CURRENT_USER");
        currentUserTextView.setText("Welcome, " + currentUser);

        // Create the user list view
        createUsersAdapter();

        // Set up the log out button click listener
        logoutButton.setOnClickListener(v -> logOutButtonClick());
    }

    /**
     * Event handler for the log out button click event.
     */
    private void logOutButtonClick() {
        // Transition back to the login view
        Intent intent = new Intent(MainViewActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Creates the users adapter, which populates the ListView with the users.
     */
    private void createUsersAdapter() {
        // Add some sample users
        List<User> users = new ArrayList<>(staticUserDAO.listUsers());

        // Initialize the ListView and the ArrayAdapter
        usersListView = findViewById(R.id.users_listview);
        usersAdapter = new UserListAdapter(this, users);

        // Set the ArrayAdapter on the ListView
        usersListView.setAdapter(usersAdapter);
    }

    /**
     * Represents the adapter for the user list view. This adapter is responsible for
     * populating the ListView with the users.
     */
    public class UserListAdapter extends ArrayAdapter<User> {

        /**
         * Creates a new UserListAdapter.
         * @param context the context
         * @param users the list of users to display
         */
        public UserListAdapter(Context context, List<User> users) {
            super(context, 0, users);
        }

        /**
         * Gets the view for the user at the specified position.
         * @param position the position
         * @param convertView the view to convert
         * @param parent the parent view
         * @return the view
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            User user = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            // This view use the item_user layout as the template
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }

            // Lookup views within item layout
            TextView emailTextView = convertView.findViewById(R.id.email_textview);
            TextView nameTextView = convertView.findViewById(R.id.name_textview);

            // Populate the data into the template view using the data object
            emailTextView.setText(user.getEmail());
            nameTextView.setText(user.getName());

            // Return the completed view to render on screen
            return convertView;
        }
    }
}
