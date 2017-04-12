package fr.unice.polytech.polynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

/**
 * @author Alexandre Clement
 *         Created the 12/04/2017.
 */

public class NewsGridFragment extends Fragment {

    private GridView gridView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NewsDBHelper newsDBHelper = new NewsDBHelper(getContext());
        try {
            newsDBHelper.createDataBase();
            newsDBHelper.openDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<News> NewsArrayAdapter = new NewsCustomAdapter(getActivity(), newsDBHelper.getAllArticles());
        gridView.setAdapter(NewsArrayAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_grid, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridView);
        return rootView;
    }
}
