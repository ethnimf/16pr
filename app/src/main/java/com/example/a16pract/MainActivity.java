package com.example.a16pract;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Users> userList;
    private String storageKey = "UserData";
    private TextView st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);

        st = findViewById(R.id.stroka);
        userList = new ArrayList<>();
        Button b = findViewById(R.id.edit_text_id);
        b.setOnClickListener(v -> startActivityForResult(
                new Intent(MainActivity.this, Add.class), 1));
        Button b1 = findViewById(R.id.delt_id);
        b1.setOnClickListener(v -> startActivityForResult(
                new Intent(MainActivity.this, Delete.class), 1));
        Button b2 = findViewById(R.id.update);
        b2.setOnClickListener(v -> startActivityForResult(
                new Intent(MainActivity.this, Change.class), 1));

        loadData();
        displayData();
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        displayData();
    }
    private void loadData() {
        userList = Paper.book().read(storageKey, new ArrayList<>());
    }
    private void displayData() {
        if (userList.isEmpty()) {
            st.setText(" ");
        } else {
            StringBuilder data = new StringBuilder();
            for (Users user : userList) {
                         data.append("ФИО: ").append(user.getName()).append("\n")

                        .append("Почта: ").append(user.getEmail()).append("\n")

                        .append("Название книги: ").append(user.getCel()).append("\n")

                        .append("Стоимость: ").append(user.getTirazh()).append("\n")

                        .append("ID: ").append(user.getId()).append("\n\n");
            }
            st.setText(data.toString());
        }
    }
    private void saveData() {
        Paper.book().write(storageKey, userList);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Users users = (Users) data.getSerializableExtra("userBook");
            if (users != null) {
                boolean userExists = false;
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getId().equals(users.getId())) {
                        userList.set(i, users);
                        userExists = true;
                        break;
                    }
                }

                if (!userExists) {
                    userList.add(users);
                }

                saveData();
                displayData();
            }
        }
    }
}