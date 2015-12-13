package org.gdgfoz.codelabgdg.api;

import org.gdgfoz.codelabgdg.models.CategoriesResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by hussan on 12/3/15.
 */
public interface TodoApi {

    @GET("/categories")
    void listCategories(Callback<CategoriesResponse> callback);


//    @GET("/tasks/category/{category}")
//    @Headers({"Authorization: " + Constants.TOKEN_API})
//    void listTasks(@Path("category") int category, Callback<TasksResponse> callback);

//    @GET("/categories")
//    @Headers({"Authorization: "+ Config.TOKEN_API})
//    void listCategorias(Callback<Category> callback);
//
//    @GET("/tasks/category/{category}")
//    void detailPerson(@Path("category") String category, Callback<List<Person>> callback);
}
