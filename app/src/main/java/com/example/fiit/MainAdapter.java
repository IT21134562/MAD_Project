package com.example.fiit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());


        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.view_exercises))
                        .setExpanded(true, 1350)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText exe1 = view.findViewById(R.id.exe1);
                EditText exe2 = view.findViewById(R.id.exe2);
                EditText exe3 = view.findViewById(R.id.exe3);
                EditText exe4 = view.findViewById(R.id.exe4);
                EditText exe5 = view.findViewById(R.id.exe5);


               Button btnUpdate = view.findViewById(R.id.btnUpdate);


                exe1.setText(model.getExe1());
                exe2.setText(model.getExe2());
                exe3.setText(model.getExe3());
                exe4.setText(model.getExe4());
                exe5.setText(model.getExe5());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("exe1", exe1.getText().toString());
                        map.put("exe2", exe2.getText().toString());
                        map.put("exe3", exe3.getText().toString());
                        map.put("exe4", exe4.getText().toString());
                        map.put("exe5", exe5.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("exercises")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error While Updating", Toast.LENGTH_LONG).show();
                                        dialogPlus.dismiss();
                                    }
                                });

                    }
                });
            }
        });



        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you sure");
                builder.setMessage("Deleted data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            FirebaseDatabase.getInstance().getReference().child("exercises")
                                    .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(), "cancelled", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });




    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amin_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name, e1, e2, e3, e4, e5;

        Button btnDelete, btnView, btnFullBodyWView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            e1 = (TextView)itemView.findViewById(R.id.exe1);
            e2 = (TextView)itemView.findViewById(R.id.exe2);
            e3 = (TextView)itemView.findViewById(R.id.exe3);
            e4 = (TextView)itemView.findViewById(R.id.exe4);
            e5 = (TextView)itemView.findViewById(R.id.exe5);

            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
            btnView = (Button)itemView.findViewById(R.id.btnView);
            btnFullBodyWView = (Button)itemView.findViewById(R.id.fbw);
        }
    }
}
