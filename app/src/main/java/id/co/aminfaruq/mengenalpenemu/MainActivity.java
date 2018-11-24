package id.co.aminfaruq.mengenalpenemu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myRecycleview)
    RecyclerView myRecycleview;

    String[] nama,isi;
    int[] gambar = {R.drawable.penemusatu,R.drawable.penemudua,R.drawable.penemutiga,R.drawable.penemuempat,R.drawable.penemulima,R.drawable.penemuenam,R.drawable.penemutujuh,R.drawable.penemudelapan,R.drawable.penemusembilan,R.drawable.penemusepuluh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        nama = getResources().getStringArray(R.array.nama);
        isi = getResources().getStringArray(R.array.info);

        AdapterPenemu adapterPenemu = new AdapterPenemu(this,nama,isi,gambar);

        myRecycleview.setHasFixedSize(true);
        myRecycleview.setLayoutManager(new LinearLayoutManager(this));
        myRecycleview.setAdapter(adapterPenemu);
    }
}
