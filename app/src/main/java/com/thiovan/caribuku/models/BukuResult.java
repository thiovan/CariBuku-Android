package com.thiovan.caribuku.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BukuResult {
    @SerializedName("buku")
    @Expose
    public List<Buku> buku = null;

    public List<Buku> getBuku() {
        return buku;
    }
}
