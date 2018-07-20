package com.thiovan.caribuku.network;

import com.thiovan.caribuku.models.BukuResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BukuService {
    @GET("buku")
    Call<BukuResult> getBuku();

    @GET("buku/search/{pengarang}")
    Call<BukuResult> searchBuku(@Path("pengarang") String pengarang);
}
