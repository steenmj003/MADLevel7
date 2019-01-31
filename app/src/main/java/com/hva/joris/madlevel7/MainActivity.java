package com.hva.joris.madlevel7;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "c1d166f2d2bb3c711b87469e6c3e5b38";
    private final int COUNT = 3;

    public static List<Recipe> recipes;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestData(COUNT);
    }

    private void updateUI() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
    }

    private void requestData(int count) {
        RecipeApiService service = RecipeApiService.retrofit.create(RecipeApiService.class);

        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<RecipeList> call = service.getRecipes(API_KEY, count);
        call.enqueue(new Callback<RecipeList>() {

            @Override
            public void onResponse(Call<RecipeList> call, Response<RecipeList> response) {
                RecipeList recipeList = response.body();
                recipes = recipeList.getRecipes();
                updateUI();
            }

            @Override
            public void onFailure(Call<RecipeList> call, Throwable t) {
            }
        });
    }
}
