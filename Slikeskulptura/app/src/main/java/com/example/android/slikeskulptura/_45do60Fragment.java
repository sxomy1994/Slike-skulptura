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
public class _45do60Fragment extends Fragment {


    public _45do60Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_list, container, false);

        //kreiramo listu skulptura
        final ArrayList<Image> skulpture = new ArrayList<Image>();
        skulpture.add(new Image("Olga Jevric", "Radjanje ruze (1970.)",
                R.drawable.radjanje_ruze));
        skulpture.add(new Image("Oto Logo","Skoljka (1966.)",
                R.drawable.skoljka));
        skulpture.add(new Image("Petar Hadziboskov","Jutro, podne, suton ,vece (1969.)",
                R.drawable.jutro_podne_suton_vece));
        skulpture.add(new Image("Raja Nikolic","Obelisk (1966.)",
                R.drawable.obelisk));
        skulpture.add(new Image("Robert Kutirije","Pasulj (1968.)",
                R.drawable.pasulj));
        skulpture.add(new Image("Sengregorio Giancarlo","Geneza (1967.)",
                R.drawable.geneza));
        skulpture.add(new Image("Shelomo Selinger","Pobeda svetlosti (1969.)",
                R.drawable.pobeda_svetlosti));
        skulpture.add(new Image("Shoshana Heiman","Zena koja sedi (1966.)",
                R.drawable.zena_koja_sedi));
        skulpture.add(new Image("Sime Vulas","Jedra (1967.)",
                R.drawable.jedra));
        skulpture.add(new Image("Sindji Sakai","Polja u cetiri godisnja doba (1996.)",
                R.drawable.polja_u_cetiri_godisnja_doba));
        skulpture.add(new Image("Stanislav Hanzik","Pesnik i devojka (1969.)",
                R.drawable.pesnik_i_devojka));
        skulpture.add(new Image("Stevan Manevski","Radjanje cveta (1970.)",
                R.drawable.radjanje_cveta));
        skulpture.add(new Image("Vida Jocic","Ptica II (1968.)",
                R.drawable.ptica_ii));
        skulpture.add(new Image("Vojin Bakic","Medaljon (1971.)",
                R.drawable.medaljon));
        skulpture.add(new Image("Dragan Poposki","Astronauti (1969.)",
                R.drawable.astronauti));

        //Kreiranje adaptera
        ImageAdapter adapter = new ImageAdapter(getContext(),skulpture,R.color.category_45_60);

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
