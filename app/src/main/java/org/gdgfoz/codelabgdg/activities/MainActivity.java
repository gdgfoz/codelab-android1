package org.gdgfoz.codelabgdg.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.gdgfoz.codelabgdg.R;
import org.gdgfoz.codelabgdg.adapters.CategoryAdapter;
import org.gdgfoz.codelabgdg.api.RestClient;
import org.gdgfoz.codelabgdg.models.CategoriesResponse;
import org.gdgfoz.codelabgdg.models.Category;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listData;
    CategoryAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listData = (RecyclerView) findViewById(R.id.list_data);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mAdapter = new CategoryAdapter(this, new ArrayList<Category>());

        setupRecyclerView();

        RestClient.get().listCategories(new Callback<CategoriesResponse>() {
            @Override
            public void success(CategoriesResponse categoriesResponse, Response response) {
                mProgressBar.setVisibility(View.GONE);
                mAdapter.setItems(categoriesResponse.getCategories());
                listData.setVisibility(View.VISIBLE);

            }
            @Override
            public void failure(RetrofitError error) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Erro na api", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView() {
        listData.setLayoutManager(new LinearLayoutManager(this));
        listData.setHasFixedSize(true);
        listData.setAdapter(mAdapter);
    }
}
