package sg.edu.np.madpractical;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView desc;
    public ImageView imageIcon;
    public Button followBtn;
    public UserViewHolder(View itemView) {
        super(itemView);
        followBtn = itemView.findViewById(R.id.followBtn);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.description);
        imageIcon = itemView.findViewById(R.id.smallIcon);
    }
}