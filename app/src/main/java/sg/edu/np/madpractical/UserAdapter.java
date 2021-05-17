package sg.edu.np.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> data;
    Context context;

    public UserAdapter(ArrayList<User> userArrayList, Context c) {
        data = userArrayList;
        context = c;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = null;
        if(viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_userinfo_alt, parent, false);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_userinfo, parent, false);
        }
        UserViewHolder viewHolder = new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = data.get(position);
        holder.name.setText(u.getName());
        holder.desc.setText(u.getDescription());
        holder.imageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Profile")
                     .setMessage(u.getName())
                     .setPositiveButton("View", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Intent intent = new Intent(context, MainActivity.class);
                             intent.putExtra("Name", u.getName());
                             intent.putExtra("Description", u.getDescription());
                             intent.putExtra("Position", position);
                             intent.putExtra("FollowBoolean", u.isFollowed());
                             context.startActivity(intent);
                         }
                     })
                     .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.cancel();
                         }
                     }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        String name = data.get(position).getName();
        if (name.charAt(name.length() - 1) == '7'){
            return 0;
        }
        else{
            return 1;
        }
    }
}