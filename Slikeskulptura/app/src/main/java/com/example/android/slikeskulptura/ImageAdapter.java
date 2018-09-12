package com.example.android.slikeskulptura;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Image> {

    /**ID boje pozadine za listu skulptura*/
    private int mBojaId;

    /**
     * * Kreiramo novi {@link ImageAdapter} objekt
     * @param context je trenutni kontekst na kom se adapter kreira
     * @param images je lista {@link Image} koja treba biti prikazana
     * @param bojaId je ID boje pozadine za listu skulptura
     */
    public ImageAdapter(@NonNull Context context, ArrayList<Image> images, int bojaId) {
        super(context,0, images);
        mBojaId = bojaId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Proveravamo da li se postojeci prikaz ponovo koristi, inace ubacujemo novi prikaz
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        //pronalazi {@link Image} obejkat koji se nalazi na ovoj poziciji u listi
        Image trenutnaSkulptura = getItem(position);

        //pronalazi TextView u list_item.xml koji ima ID ime_vajara
        TextView imeVajara = (TextView) listItemView.findViewById(R.id.ime_vajara);

        //Pronalazi ime vajara iz trenutnaSkulptura objekta i postavlja taj tekst u TextView koji se
        //odnosi na ime vajara
        imeVajara.setText(trenutnaSkulptura.getImeVajaraId());

        //pronalazi TextView u list_item.xml koji ima ID naziv_i_godina
        TextView nazivIGodina = (TextView) listItemView.findViewById(R.id.naziv_i_godina);

        //Pronalazi naziv skulpture i godinu i postavlja taj tekst u TextView sa ID naziv_i_godina
        nazivIGodina.setText(trenutnaSkulptura.getNazivIGodinaId());

        //Pronalazi sliku u list_item.xml sa ID image;
        ImageView slikaSkulpture = (ImageView) listItemView.findViewById(R.id.image);

        /**
         * ISPROBAVANJE SA FULLSCREEN SLIKOM
         */
//        ImageView vecaSlika = (ImageView) listItemView.findViewById(R.id.image_full);
//        vecaSlika.setImageResource(trenutnaSkulptura.getSlikaSkulptureId());

        //Pronalazi sliku i postavlja je u ImageView sa ID image
        slikaSkulpture.setImageResource(trenutnaSkulptura.getSlikaSkulptureId());

        //postavlja boju teme za list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        //pronalazi boju pomocu ID
        int boja = ContextCompat.getColor(getContext(), mBojaId);

        //postavlja boju pozadine text_container
        textContainer.setBackgroundColor(boja);

        return listItemView;
    }
}
