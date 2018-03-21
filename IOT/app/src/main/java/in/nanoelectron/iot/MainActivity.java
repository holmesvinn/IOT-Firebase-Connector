package in.nanoelectron.iot;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MainActivity extends AppCompatActivity {
    private Button submit, reset;
    private EditText message;
    private String msg;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit =(Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);
        message = (EditText) findViewById(R.id.message);



        databaseReference = FirebaseDatabase.getInstance().getReference("message");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = message.getText().toString();
                    databaseReference.setValue(msg);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText(" ");
            }
        });

    }
}
