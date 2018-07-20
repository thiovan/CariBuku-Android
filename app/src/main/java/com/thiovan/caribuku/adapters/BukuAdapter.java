package com.thiovan.caribuku.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thiovan.caribuku.R;
import com.thiovan.caribuku.models.Buku;

import java.util.List;

public class BukuAdapter extends ArrayAdapter<Buku> {

    public BukuAdapter(@NonNull Context context, int resource, @NonNull List<Buku> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_buku, parent, false);
        }

        Buku buku = getItem(position);

        ImageView sampul = convertView.findViewById(R.id.iv_foto);
        Picasso.get().load("http://192.168.137.1:8080/web/LaraSort/" + buku.getSampul()).into(sampul);
        TextView judul = convertView.findViewById(R.id.tv_judul);
        TextView pengarang = convertView.findViewById(R.id.tv_pengarang);
        TextView tahun = convertView.findViewById(R.id.tv_tahun);
        TextView isbn = convertView.findViewById(R.id.tv_isbn);
        judul.setText(buku.getNama());
        pengarang.setText(buku.getPengarang());
        tahun.setText(String.valueOf(buku.getTahunTerbit()));
        isbn.setText(buku.getIsbn());
        return convertView;
    }
}
