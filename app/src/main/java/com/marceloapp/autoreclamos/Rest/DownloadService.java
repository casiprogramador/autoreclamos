package com.marceloapp.autoreclamos.Rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Marcelo on 23/5/2016.
 */
public interface DownloadService {
    @GET
    @Streaming
    Call<ResponseBody> getFile(@Url String url);
}
