package sg.edu.np.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    static ArrayList<User> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Generating user information
        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            final int min = 1000000000;
            final int max = 2000000000;
            final int randomName = new Random().nextInt((max - min) + 1) + min;
            final int randomDesc = new Random().nextInt((max - min) + 1) + min;
            User u = new User();
            u.setName("Name" + randomName);
            u.setDescription("Description" + randomDesc);
            u.setFollowed(r.nextBoolean());
            data.add(u);
        }
        //Populate RV
        RecyclerView rv = findViewById(R.id.recyclerView);
        UserAdapter adapter = new UserAdapter(data, this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}