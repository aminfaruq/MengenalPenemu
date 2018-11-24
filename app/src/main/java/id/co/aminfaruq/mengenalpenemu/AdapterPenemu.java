package id.co.aminfaruq.mengenalpenemu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterPenemu extends RecyclerView.Adapter<AdapterPenemu.ViewHolder> {
    Context context;
    String[] nama,isi;
    int[] gambar;

    public AdapterPenemu(Context context, String[] nama, String[] isi, int[] gambar) {
        this.context = context;
        this.nama = nama;
        this.isi = isi;
        this.gambar = gambar;
    }

    @NonNull
    @Override
    public AdapterPenemu.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPenemu.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(nama[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgGambar);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("gambar",gambar[i]);
                intent.putExtra("judul",nama[i]);
                intent.putExtra("detail",isi[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama;
        ImageView imgGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txtNama);
            imgGambar = itemView.findViewById(R.id.imgGambarPenemu);
        }
    }
}
