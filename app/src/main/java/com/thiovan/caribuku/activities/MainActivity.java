package com.thiovan.caribuku.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.thiovan.caribuku.R;
import com.thiovan.caribuku.adapters.BukuAdapter;
import com.thiovan.caribuku.models.Buku;
import com.thiovan.caribuku.models.BukuResult;
import com.thiovan.caribuku.network.APIClient;
import com.thiovan.caribuku.network.BukuService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView lvBuku;
    Button mBtnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBuku = (ListView) findViewById(R.id.lv_buku);

        loadSemua();

        mBtnCari = (Button) findViewById(R.id.btn_cari);
        final EditText mEtSearch = (EditText) findViewById(R.id.et_search);

        mBtnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mEtSearch.getText().toString().equals("")) {
                    cariMovie(mEtSearch.getText().toString());
                } else {
                    mBtnCari.setEnabled(false);
                    mBtnCari.setText(" Sedang Mencari... ");
                    loadSemua();
                }
            }
        });
    }

    //Tampilkan semua buku
    private void loadSemua() {
        BukuService mService = APIClient.getClient().create(BukuService.class);
        Call<BukuResult> mahasiswas = mService.getBuku();
        mahasiswas.enqueue(new Callback<BukuResult>() {
            @Override
            public void onResponse(Call<BukuResult> call, Response<BukuResult> response) {
                mBtnCari.setEnabled(true);
                mBtnCari.setText("Cari");
                List<Buku> user = response.body().getBuku();
                BukuAdapter userAdapter = new BukuAdapter(getApplicationContext(), 0, user);
                lvBuku.setAdapter(userAdapter);
                Toast.makeText(MainActivity.this, "Jumlah buku: " + response.body().getBuku().size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BukuResult> call, Throwable t) {
                mBtnCari.setEnabled(true);
                mBtnCari.setText("Cari");
                Toast.makeText(MainActivity.this, "Gagal Terhubung", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Tampilkan buku sesuai pencarian
    private void cariMovie(String query) {
        mBtnCari.setEnabled(false);
        mBtnCari.setText(" Sedang Mencari... ");
        BukuService mService = APIClient.getClient().create(BukuService.class);
        Call<BukuResult> searchBuku = mService.searchBuku(query);
        searchBuku.enqueue(new Callback<BukuResult>() {
            @Override
            public void onResponse(Call<BukuResult> call, Response<BukuResult> response) {
                mBtnCari.setEnabled(true);
                mBtnCari.setText("Cari");
                List<Buku> user = response.body().getBuku();
                BukuAdapter userAdapter = new BukuAdapter(getApplicationContext(), 0, user);
                lvBuku.setAdapter(userAdapter);
                Toast.makeText(MainActivity.this, "Jumlah buku: " + response.body().getBuku().size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<BukuResult> call, Throwable t) {
                mBtnCari.setEnabled(true);
                mBtnCari.setText("Cari");
                Toast.makeText(MainActivity.this, "Gagal Terhubung", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
