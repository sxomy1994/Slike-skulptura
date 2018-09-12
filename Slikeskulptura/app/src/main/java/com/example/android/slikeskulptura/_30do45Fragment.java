package com.example.android.slikeskulptura;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class _30do45Fragment extends Fragment {


    public _30do45Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_list, container, false);

        //kreiramo listu skulptura
        final ArrayList<Image> skulpture = new ArrayList<>();
        skulpture.add(new Image("Kordelija fon Den", "Putovanje (1974.)",
                R.drawable.putovanje));
        skulpture.add(new Image("Kosta Angeli Radovani", "Zena na kocki (1967.)"
                , R.drawable.zena_na_kocki));
        skulpture.add(new Image("Ksenija Ljubibratic", "Zena koja razmislja (1967.)"
                , R.drawable.zena_koja_razmislja));
        skulpture.add(new Image("Leo de Vris", "Kompozicija (1979.)",
                R.drawable.kompozicija_leo_de_vris));
        skulpture.add(new Image("Lidija Misic", "Priblizavanje (1971.)",
                R.drawable.priblizavanje));
        skulpture.add(new Image("Luka Tomanovic", "Govece (1976.)",
                R.drawable.govece));
        skulpture.add(new Image("Lynn Chadwick", "Par (1978.)",
                R.drawable.par));
        skulpture.add(new Image("Mahmud Musa", "Neznost (1979.)",
                R.drawable.neznost));
        skulpture.add(new Image("Marsel Gugujanu", "Dalila (1972.)",
                R.drawable.dalila));
        skulpture.add(new Image("Matija Vukovic", "Njegos (1966.)",
                R.drawable.njegos));
        skulpture.add(new Image("Metodi Sova", "Ljudi (1973.)",
                R.drawable.ljudi));
        skulpture.add(new Image("Milija Glisic", "Nabrekla Forma (1968.)",
                R.drawable.nabrekla_forma));
        skulpture.add(new Image("Milija Nesic", "Oblik za prostor (1973.)",
                R.drawable.oblik_za_prostor));
        skulpture.add(new Image("Mira Jurisic", "Prisutnost (1966.)",
                R.drawable.prisutnost));
        skulpture.add(new Image("Nagji Patel", "Nandi (1979.)",
                R.drawable.nandi));

        //kriera adapter
        ImageAdapter adapter = new ImageAdapter(getContext(), skulpture, R.color.category_30_45);

        /**
         * Pronalazi objekat {@link ListView} u hijerarhiji prikaza {@link Activity}. Treba da
         * posotji ListView koji sadrzi ID = list , koji je deklarisan u image_list.xml
         */
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        /**
         * Omogucimo da {@link ListView} koristi {@link ImageAdapter} koji smo kreirali iznad,
         * tako da {@link ListView} prikazuje listu stavki za svaki {@link Image} u listi.
         */
        listView.setAdapter(adapter);

        //Kreiramo click Listener za prikazivanje vece slike sa podacima
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ListDataActivity.class);
                Image skulptura = skulpture.get(i);

                intent.putExtra("image", skulptura.getSlikaSkulptureId());
                intent.putExtra("name", skulptura.getImeVajaraId());
                intent.putExtra("nazivIgodina", skulptura.getNazivIGodinaId());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
