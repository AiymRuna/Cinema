package com.example.user.cinema;

import android.content.Context;
import android.view.*;
import android.widget.*;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieResult> {

    private Context context;
    LayoutInflater layoutInflater;
    List<MovieResult> list;

    MovieAdapter(Context  context, List<MovieResult> list) {
        super(context,0,list);
        this.context=context;
        this.list=list;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MovieResult getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder vh;
        if (convertView==null){
            View view=layoutInflater.inflate(R.layout.list_view,parent,false);
            vh= ViewHolder.create((RelativeLayout)view);
            view.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        MovieResult item=getItem(position);
        vh.textName.setText(item.getName());
        vh.textVote.setText(item.getVote());
        Picasso.with(context).load("https://kinoafisha.ua/"+list.get(position).getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.movieImage);
        return vh.view;
    }

    private static class ViewHolder{
        public final RelativeLayout view;
        public final TextView textName;
        public final TextView textVote;
        public final ImageView movieImage;
        ViewHolder(RelativeLayout view,TextView textName,TextView textVote,ImageView movieImage){
            this.view=view;
            this.textName=textName;
            this.textVote=textVote;
            this.movieImage=movieImage;
        }
        public static ViewHolder create(RelativeLayout view){
            TextView textName=(TextView)view.findViewById(R.id.textName);
            TextView textVote=(TextView)view.findViewById(R.id.textAdress);
            ImageView movieImage=(ImageView) view.findViewById(R.id.imageView);
            return new ViewHolder(view,textName,textVote,movieImage);
        }
    }
}
