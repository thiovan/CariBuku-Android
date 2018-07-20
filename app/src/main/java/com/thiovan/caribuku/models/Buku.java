package com.thiovan.caribuku.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Buku {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("sampul")
    @Expose
    public String sampul;
    @SerializedName("nama")
    @Expose
    public String nama;
    @SerializedName("pengarang")
    @Expose
    public String pengarang;
    @SerializedName("tahun_terbit")
    @Expose
    public Integer tahunTerbit;
    @SerializedName("isbn")
    @Expose
    public String isbn;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    public Integer getId() {
        return id;
    }

    public String getSampul() {
        return sampul;
    }

    public String getNama() {
        return nama;
    }

    public String getPengarang() {
        return pengarang;
    }

    public Integer getTahunTerbit() {
        return tahunTerbit;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
