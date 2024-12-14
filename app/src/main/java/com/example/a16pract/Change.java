package com.example.a16pract;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Change  extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText cel;
    private EditText tirazh;
    private EditText Id;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);
        String mode = getIntent().getStringExtra("mode");
        Users user = (Users) getIntent().getSerializableExtra("userBook");
        Id = findViewById(R.id.id);
        name = findViewById(R.id.nameauthor);
        email = findViewById(R.id.namebook);
        cel = findViewById(R.id.email_author);
        tirazh = findViewById(R.id.nuber_phone);
        button = findViewById(R.id.dobavit);
        if ("edit".equals(mode) && user != null) {
            Id.setText(user.getId());
            name.setText(user.getName());
            email.setText(user.getEmail());
            cel.setText(user.getCel());
            tirazh.setText(user.getTirazh());
        }
        button.setOnClickListener(v -> saveData(mode, user));
    }
    private void saveData(String mode, Users userBook) {
        String id = Id.getText().toString();
        String author = name.getText().toString();
        String book = email.getText().toString();
        String email = cel.getText().toString();
        String phone = tirazh.getText().toString();
        if ("edit".equals(mode) && userBook != null) {
            userBook.setNameAuthor(author);
            userBook.setNameBook(book);
            userBook.setEmailAuthor(email);
            userBook.setNumberPhone(phone);
            Intent intent = new Intent();
            intent.putExtra("userBook", userBook);
            setResult(RESULT_OK, intent);
        } else {
            Users newUserBook = new Users(id, author, book, email, phone);
            Intent intent = new Intent();
            intent.putExtra("userBook", newUserBook);
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}

