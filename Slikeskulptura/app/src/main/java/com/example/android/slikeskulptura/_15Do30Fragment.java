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
public class _15Do30Fragment extends Fragment {


    public _15Do30Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_list, container, false);

        //Kreiranje liste skulptura
        final ArrayList<Image> skulpture = new ArrayList<Image>();
        skulpture.add(new Image("Edi Selmi", "Gibanje u prostoru (1973.)",
                R.drawable.gibanje_u_prostoru));
        skulpture.add(new Image("Enriko Koti","Kontinuitet i transformacija (1986.)",
                R.drawable.kontinuitet_i_transformacija));
        skulpture.add(new Image("Frenk Vilson", "Covek i pas (1972.)",
                R.drawable.covek_i_pas));
        skulpture.add(new Image("Gio Pomodoro", "U cast pokreta otpora Jugoslavije (1970.)",
                R.drawable.u_cast_pokreta_otpora_jugoslavije));
        skulpture.add(new Image("Ivan Kozaric", "Oblik prostora (1967.)",
                R.drawable.oblik_prostora));
        skulpture.add(new Image("Olga Jancic", "Jezgro oblika IV (1972.)",
                R.drawable.jezgro_oblika_iv));
        skulpture.add(new Image("Janez Lenasi", "Iz tri dela (1981.)",
                R.drawable.iz_tri_dela));
        skulpture.add(new Image("Jelisaveta Sober Popovic", "Bit (1971.)",
                R.drawable.bit));
        skulpture.add(new Image("Jo Sefer", "Kompozicija (1981.)",
                R.drawable.kompozicija_jo_sefer));
        skulpture.add(new Image("Josef Schagerl", "Homoment (1968.)",
                R.drawable.homoment));
        skulpture.add(new Image("Josip Diminic", "Drvo-kuca-covek (1984.)",
                R.drawable.drvo_kuca_covek));
        skulpture.add(new Image("Jovan Kratohvil", "Plod (1969.)",
                R.drawable.plod));
        skulpture.add(new Image("Karlo Ramu", "Idol (1970.)",
                R.drawable.idol_ramu));
        skulpture.add(new Image("Kengiro Azuma", "Mu (1976.)",
                R.drawable.mu));
        skulpture.add(new Image("Kolja Milunovic", "Konjanik (1967.)",
                R.drawable.konjanik));

        //kreira ImageAdapter objekat ciji je izvor podataka lista iz Image klase, adapter
        //kreira stavke liste
        ImageAdapter adapter = new ImageAdapter(getActivity(), skulpture, R.color.category_15_30);

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
