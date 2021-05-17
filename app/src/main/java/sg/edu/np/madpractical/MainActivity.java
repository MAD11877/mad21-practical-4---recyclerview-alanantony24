package sg.edu.np.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int position;
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting values
        position = getIntent().getIntExtra("Position", 0);
        user.followed = getIntent().getBooleanExtra("FollowBoolean", false); //initially the value is false
        setValues();
        followToggler();
    }
    public void followToggler(){
        Button btn = findViewById(R.id.btnFollow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn.getText().toString().compareTo("Follow") == 0){
                    btn.setText("Unfollow");
                    ListActivity.data.get(position).setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else{
                    btn.setText("Follow");
                    ListActivity.data.get(position).setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void setValues(){
        TextView textView = findViewById(R.id.helloText);
        TextView description = findViewById(R.id.loremText);
        Intent intent = getIntent();
        textView.setText(intent.getExtras().get("Name").toString());
        description.setText(intent.getExtras().get("Description").toString());
        Button btn = findViewById(R.id.btnFollow);
        if(!user.followed){
            btn.setText("Follow");
        }
        else{
            btn.setText("Unfollow");
        }
    }
}