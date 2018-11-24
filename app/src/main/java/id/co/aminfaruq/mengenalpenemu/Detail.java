package id.co.aminfaruq.mengenalpenemu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detail extends AppCompatActivity {

    @BindView(R.id.imgInfoPenemu)
    ImageView imgInfoPenemu;
    @BindView(R.id.txtJudul)
    TextView txtJudul;
    @BindView(R.id.TxtDetail)
    TextView TxtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Glide.with(this).load(getIntent().getIntExtra("gambar",0)).into(imgInfoPenemu);
        txtJudul.setText(getIntent().getStringExtra("judul"));
        TxtDetail.setText(getIntent().getStringExtra("detail"));
    }
}
