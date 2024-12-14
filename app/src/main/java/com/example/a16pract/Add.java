package com.example.a16pract;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText cel;
    private EditText tirazh;
    private EditText Id;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        Id = findViewById(R.id.id);

        name = findViewById(R.id.nameauthor);
        email = findViewById(R.id.namebook);
        cel = findViewById(R.id.email_author);
        tirazh = findViewById(R.id.nuber_phone);
        button = findViewById(R.id.dobavit);

        button.setOnClickListener(v -> saveData());

    }

    private void saveData() {
        String id = Id.getText().toString() ;
        String author = name.getText().toString();
        String book = email.getText().toString();
        String email = cel.getText().toString();
        String phone = tirazh.getText().toString();
        Users userBook = new Users(id ,author, book, email, phone);
        Intent intent = new Intent();
        intent.putExtra("userBook", userBook);
        setResult(RESULT_OK, intent);
        finish();
    }
}
