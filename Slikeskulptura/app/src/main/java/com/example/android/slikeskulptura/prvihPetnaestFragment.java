package com.example.android.slikeskulptura;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class prvihPetnaestFragment extends Fragment {



    public prvihPetnaestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.image_list, container, false);

        //Kreira listu skulptura
        final ArrayList<Image> skulpture = new ArrayList<Image>();
        skulpture.add(new Image("Aleksandar Burganov", "Nika (1981.)"
                ,R.drawable.nika));
        skulpture.add(new Image("Ana Vidjen", "Suhodoba (1967.)",
                R.drawable.suhodoba));
        skulpture.add(new Image("Angel Miguel Gonzales",
                "Kompozicija (1982.)", R.drawable.kompozicija));
        skulpture.add(new Image("Angelina Gatalica", "Materinstvo (1966.)",
                R.drawable.materinstvo));
        skulpture.add(new Image("Ante Jakic", "Tron (1981.)",
                R.drawable.tron));
        skulpture.add(new Image("Antonio Paradiso", "Cvet (1972.)",
                R.drawable.cvet));
        skulpture.add(new Image("Bai Lan Sheng", "Izvor (1981.)",
                R.drawable.izvor));
        skulpture.add(new Image("Bosko Kucanski", "Izvor (1975.)",
                R.drawable.izvor_bosko_kucanski));
        skulpture.add(new Image("Branko Ruzic", "Susret (1968.)",
                R.drawable.susret));
        skulpture.add(new Image("Claude Lhoste", "Pelikan (1968.)",
                R.drawable.pelikan));
        skulpture.add(new Image("David Marshal", "Pogled kroz svet (1986.)",
                R.drawable.pogled_kroz_svet));
        skulpture.add(new Image("Dragan Mojovic", "Dokaz centra sveta (1992.)",
                R.drawable.dokaz_centra_sveta));
        skulpture.add(new Image("Drago Djurovic", "Torzo (1977.)",
                R.drawable.torzo));
        skulpture.add(new Image("Drago Trsar", "Krug zivota (1967.)",
                R.drawable.kruz_zivota));
        skulpture.add(new Image("Dusan Dzamonja", "Cvet (1970.)",
                R.drawable.cvet_dusan_dzamonja));

        //kreira ImageAdapter objekat ciji je izvor podataka lista iz Image klase, adapter
        //kreira stavke liste
        ImageAdapter adapter = new ImageAdapter(getActivity(), skulpture, R.color.category_1_15);

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

                // Trazi {@link Word} object za poziciji prilikom klika korisnika
                Image skulptura = skulpture.get(i);
                skulptura.getSlikaSkulptureId();


                intent.putExtra("image", skulptura.getSlikaSkulptureId());
                intent.putExtra("name", skulptura.getImeVajaraId());
                intent.putExtra("nazivIgodina", skulptura.getNazivIGodinaId());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
