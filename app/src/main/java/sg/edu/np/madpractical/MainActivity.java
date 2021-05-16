package sg.edu.np.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = user.name;
        String description = user.description;
        user.followed = false; //initially the value is false
        setValues();
    }

    public void followToggler(View view) {
        Button btn = findViewById(R.id.followBtn);
        if(btn.getText().toString().compareTo("Follow") == 0){
            user.followed = true;
            btn.setText("Unfollow");
            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
        }
        else{
            user.followed = false;
            btn.setText("Follow");
            Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
        }
    }
    public void setValues(){
        TextView textView = findViewById(R.id.helloText);
        TextView description = findViewById(R.id.loremText);
        Intent intent = getIntent();
        textView.setText(intent.getExtras().get("Name").toString());
        description.setText(intent.getExtras().get("Description").toString());
    }
}