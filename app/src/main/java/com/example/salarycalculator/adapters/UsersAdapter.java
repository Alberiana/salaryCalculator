package com.example.salarycalculator.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.salarycalculator.R;
import com.example.salarycalculator.models.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends BaseAdapter {

    public List<UsersModel> dataset=new ArrayList<>();
    Context c;

    public UsersAdapter(Context c) {
        this.c = c;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return dataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return dataset.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view= LayoutInflater.from(c).inflate(R.layout.row_layout, viewGroup, false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.getTvNameSurname().setText(dataset.get(i).getName()+" "+dataset.get(i).getSurname());
        viewHolder.getTvpagatatus().setText("Paga e tatueshme eshte: "+dataset.get(i).getPagatat());
        viewHolder.getTvKontributiPensional().setText("Kontributi pensional: "+ dataset.get(i).getKonPensional());

        if(i%2==0)
        {
            viewHolder.getRelLayout().setBackgroundColor(Color.GRAY);
        }
        else
        {
            viewHolder.getRelLayout().setBackgroundColor(Color.TRANSPARENT);
        }
        return view;
    }
}


class ViewHolder{
    TextView tvNameSurname, tvpagatatus, tvKontributiPensional;
    RelativeLayout relLayout;

    public ViewHolder(View v) {
       tvNameSurname=v.findViewById(R.id.tvNameSurname);
       tvpagatatus=v.findViewById(R.id.tvPagaTatueshme);
       tvKontributiPensional=v.findViewById(R.id.tvKontributiPensional);
       relLayout=v.findViewById(R.id.relLayout);

    }

    public TextView getTvNameSurname() {
        return tvNameSurname;
    }

    public TextView getTvpagatatus() {
        return tvpagatatus;
    }

    public TextView getTvKontributiPensional() {
        return tvKontributiPensional;
    }

    public RelativeLayout getRelLayout() {
        return relLayout;
    }
}