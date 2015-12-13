package org.gdgfoz.codelabgdg.api;


import org.gdgfoz.codelabgdg.Constants;

import retrofit.RestAdapter;

public class RestClient {

    private static TodoApi REST_CLIENT;

    private static RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.FULL;
    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(Constants.BASE_API)
            .setLogLevel(logLevel);

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public static TodoApi get() {
        REST_CLIENT = builder.build().create(TodoApi.class);
        return REST_CLIENT;
    }

//    private static TodoApi REST_CLIENT;
//
//    static {
//
//
//        builder = new RestAdapter.Builder();
//        builder.setEndpoint(Config.PERSON_API)
//                .setConverter(new GsonConverter(gson))
//                .setLogLevel(logLevel);
//        RestAdapter restAdapter = builder.build();
//        REST_CLIENT = restAdapter.create(TodoApi.class);
//    }
//
//    public static TodoApi get() {
//        return REST_CLIENT;
//    }
}

