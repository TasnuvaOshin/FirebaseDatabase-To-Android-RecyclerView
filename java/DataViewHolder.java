package oshin.tasnuva.cwcreminder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DataViewHolder extends RecyclerView.ViewHolder {
   public TextView teamone,teamtwo;

   public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        teamone = itemView.findViewById(R.id.teamone);
        teamtwo = itemView.findViewById(R.id.teamtwo);

    }
}
