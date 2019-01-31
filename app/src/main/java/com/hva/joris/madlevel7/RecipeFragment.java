package com.hva.joris.madlevel7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class RecipeFragment extends Fragment {

    static final String SECTION_NUMBER = "number";

    private View view;
    private TextView title;
    private TextView url;
    private ImageView imageView;


    public static RecipeFragment newInstance(int sectionNumber) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();

        args.putInt(SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recipe_fragment, container, false);

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.titleText);
        url = view.findViewById(R.id.urlText);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        if (MainActivity.recipes.size() != 0) {
            Recipe recipe = MainActivity.recipes.get(getArguments().getInt(SECTION_NUMBER));
            Glide.with(this).load(recipe.getImageUrl()).apply(options).into(imageView);

            title.setText(recipe.getTitle());
            url.setText(recipe.getSourceUrl());
        }

        return view;
    }
}
