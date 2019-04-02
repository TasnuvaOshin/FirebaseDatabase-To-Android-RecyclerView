package oshin.tasnuva.cwcreminder.OutPut;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import oshin.tasnuva.cwcreminder.DataSetFirebase;
import oshin.tasnuva.cwcreminder.DataViewHolder;
import oshin.tasnuva.cwcreminder.R;


/*
writter : Tasnuvaoshin
Youtube Channel : Lets Study
To Learn More go to my channel
to mail me : tasnuva.oshin12@gmail.com

 */
public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataSetFirebase> arrayList;

    private DatabaseReference databaseReference;
    private FirebaseRecyclerOptions<DataSetFirebase> options;
    private FirebaseRecyclerAdapter<DataSetFirebase,DataViewHolder> firebaseRecyclerAdapter;
    //initialize these variable



    @Override
    protected void onStart() {
         firebaseRecyclerAdapter.startListening();
        super.onStart();
    }

    @Override
    protected void onStop() {
        firebaseRecyclerAdapter.stopListening();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.Recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<DataSetFirebase>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("cwc");
        databaseReference.keepSynced(true);
 options = new FirebaseRecyclerOptions.Builder<DataSetFirebase>().setQuery(databaseReference,DataSetFirebase.class).build();


firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<DataSetFirebase, DataViewHolder>(options) {
    @Override
    protected void onBindViewHolder(@NonNull final DataViewHolder holder, int position, @NonNull final DataSetFirebase model) {
           //FirebaseRecyclerView main task where it fetching data from model
        holder.teamone.setText(model.getTeamone());
        holder.teamtwo.setText(model.getTeamtwo());



    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //we need to return a object of our modelviewholder and modelview needs 2 parameter value
        //(Layout Inflater ,inflate)
        //Layout Inflater is the View Which will be replace
        //inflate which will take place
        //viewgroup means the recyclerview rows which will be replace
        //attachroot false as we dont want to show root

        return new DataViewHolder(LayoutInflater.from(HomeActivity.this).inflate(R.layout.row,viewGroup,false));
    }
};



recyclerView.setAdapter(firebaseRecyclerAdapter);


    }
}
