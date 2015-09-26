package com.tripoin.tripoin_rest.engine;


import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.tripoin.tripoin_common.component.ITRIPOINComponent;
import com.tripoin.tripoin_common.constant.GeneralConstant;
import com.tripoin.tripoin_dao.impl.DAODynamicConfiguration;
import com.tripoin.tripoin_model.ModelDynamicConfiguration;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created on 5/24/2015 : 12:21 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RestGenerator<S> implements ITRIPOINComponent<RestParameter> {

    public RestAdapter.Builder builder = new RestAdapter.Builder();

    private RestParameter restParameter;

    public S createService(Class<S> serviceClass) {
        return createService(
                serviceClass,
                getParameter().getUserName(),
                getParameter().getPassword(),
                getParameter().getContext()
        );
    }

    public S createService(Class<S> serviceClass,  String username, String password, Context context) {
        ModelDynamicConfiguration modelDynamicConfiguration = (ModelDynamicConfiguration)
                new DAODynamicConfiguration(context).getAllData().get(0);

        builder.setLogLevel(RestAdapter.LogLevel.FULL)
               .setEndpoint(modelDynamicConfiguration.getBasicUrl())
               .setClient(new OkClient(new OkHttpClient()));

        if (username != null && password != null) {
            builder.setRequestInterceptor(
                    new CustomRequestInterceptor(
                            username.concat(GeneralConstant.Punctuation.COLON)
                                    .concat(password))
            );
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    @Override
    public void setParameter(RestParameter _param) {
        this.restParameter = _param;
    }

    @Override
    public RestParameter getParameter() {
        return restParameter;
    }
}