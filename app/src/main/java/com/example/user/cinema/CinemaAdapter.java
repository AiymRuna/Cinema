package com.example.user.cinema;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CinemaAdapter extends ArrayAdapter<Unmain> {

    private Context context;
    LayoutInflater layoutInflater;
    List<Unmain> list;

    CinemaAdapter (Context  context, List<Unmain> list) {
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
    public Unmain getItem(int position) {
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
            vh=ViewHolder.create((RelativeLayout)view);
            view.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        Unmain item=getItem(position);
        vh.textName.setText(item.getName());
        vh.textAdress.setText(item.getAddress());
        Picasso.with(context).load("https://kinoafisha.ua/"+list.get(position).getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.cinemaImage);
        return vh.view;
    }

    private static class ViewHolder{
        public final RelativeLayout view;
        public final TextView textName;
        public final ImageView cinemaImage;
        public final TextView textAdress;
        ViewHolder(RelativeLayout view,TextView textName,TextView textAdress,ImageView cinemaImage){
            this.view=view;
            this.textName=textName;
            this.textAdress=textAdress;
            this.cinemaImage=cinemaImage;
        }
        public static ViewHolder create(RelativeLayout view){
            TextView textName=(TextView)view.findViewById(R.id.textName);
            TextView textAdress=(TextView)view.findViewById(R.id.textAdress);
            ImageView cinemaImage=(ImageView) view.findViewById(R.id.imageView);
            return new ViewHolder(view,textName,textAdress,cinemaImage);
        }
    }
}
