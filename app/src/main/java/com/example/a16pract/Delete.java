package com.example.a16pract;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;
import io.paperdb.Paper;

public class Delete extends AppCompatActivity {
    private EditText ID;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);
        ID = findViewById(R.id.Id);
        button = findViewById(R.id.DeleteDelete);
        button.setOnClickListener(v -> DeleteDel());




    }
    public void DeleteDel() {
        String idToDelete = ID.getText().toString();
        ArrayList<Users> userList = Paper.book().read(
                "UserData", new ArrayList<>());
        boolean found = false;
        Iterator<Users> iterator = userList.iterator();
        while (iterator.hasNext()) {
            Users user = iterator.next();
            if (user.getId().equals(idToDelete)) {
                iterator.remove();
                found = true;
                break;
            }



        }
        if (found) {
            Paper.book().write("UserData", userList);
            finish();
        } else {
            Toast.makeText(this, "ID не найден", Toast.LENGTH_SHORT).show();
        }
    }
}