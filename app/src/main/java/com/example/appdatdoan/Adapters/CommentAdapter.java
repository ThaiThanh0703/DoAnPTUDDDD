package com.example.appdatdoan.Adapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appdatdoan.Models.BinhLuan;
//import com.example.doanfood.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter  extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private ArrayList<BinhLuan> mlist;

    public CommentAdapter(Context context, ArrayList<BinhLuan> mlist) {
        this.context = context;
        this.mlist = mlist;
    }
}
