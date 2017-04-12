package fr.unice.polytech.polynews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.layout.simple_list_item_1;


/**
 * @author Alexandre Clement
 *         Created the 12/04/2017.
 */

public class NewsCustomAdapter extends ArrayAdapter<News> {


    public NewsCustomAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.news, null);
        CardView cardView = (CardView) convertView;
        cardView.findViewById(R.id.playButton).setVisibility(View.INVISIBLE);
        if (getItem(position).getType() == News.Type.IMAGE)
            new CustomAsyncTask((ImageView) cardView.findViewById(R.id.imageView)).execute(getItem(position).getUrl());
        else
        {
            String format = "http://img.youtube.com/vi/%s/default.jpg";
            Pattern pattern = Pattern.compile("watch\\?v=(.*)");
            Matcher matcher = pattern.matcher(getItem(position).getUrl());
            if (matcher.find())
                new CustomAsyncTask((ImageView) cardView.findViewById(R.id.imageView)).execute(String.format(format, matcher.group(1)));
            cardView.findViewById(R.id.playButton).setVisibility(View.VISIBLE);
            cardView.findViewById(R.id.playButton).bringToFront();
        }
        ((TextView) cardView.findViewById(R.id.dateView)).setText(getItem(position).getDate().toString());
        ((TextView) cardView.findViewById(R.id.categoryView)).setText(getItem(position).getCategory().toString());
        ((TextView) cardView.findViewById(R.id.titleView)).setText(getItem(position).getTitle());
        return convertView;
    }
}
