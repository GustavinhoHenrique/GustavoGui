package com.example.gui.tp;

/**
 * Created by Guilherme Assis on 22/04/2018.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView Nome = (TextView) convertView.findViewById(R.id.textNome);
            TextView Genero = (TextView) convertView.findViewById(R.id.textGenero);
            TextView Diretor = (TextView) convertView.findViewById(R.id.textDiretor);
            TextView Ano = (TextView) convertView.findViewById(R.id.textAno);
            TextView Faixa = (TextView) convertView.findViewById(R.id.textFaixa);
            if (Nome != null) {
                Nome.setText(user.getNOME());
            }
            if (Genero != null) {
                Genero.setText((user.getGENERO()));
            }
            if (Diretor != null) {
                Diretor.setText((user.getDIRETOR()));
            }
            if (Ano != null) {
                Ano.setText((user.getANO()));
            }
            if (Faixa != null) {
                Faixa.setText((user.getFAIXA()));
            }
        }

        return convertView;
    }
}
