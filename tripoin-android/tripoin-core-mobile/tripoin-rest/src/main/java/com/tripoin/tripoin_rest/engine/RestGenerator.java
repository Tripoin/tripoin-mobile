package com.tripoin.tripoin_rest.engine;


import com.squareup.okhttp.OkHttpClient;
import com.tripoin.tripoin_common.constant.GeneralConstant;
import com.tripoin.tripoin_model.ModelDynamicConfiguration;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created on 5/24/2015 : 12:21 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RestGenerator<S> {

    public static RestAdapter.Builder builder = new RestAdapter.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass,  String username, String password) {
        ModelDynamicConfiguration modelDynamicConfiguration = TBManagerTestConfiguration.getInstance().getAllData().get(0);

        builder.setLogLevel(RestAdapter.LogLevel.FULL)
               .setEndpoint(modelDynamicTestConfiguration.getBaseUrl())
               .setClient(new OkClient(new OkHttpClient()));

        if (username != null && password != null) {
            builder.setRequestInterceptor(
                    new CustomRequestInterceptor(
                            username.concat(GeneralConstant.Punctuation.COLON).concat(password))
            );
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}