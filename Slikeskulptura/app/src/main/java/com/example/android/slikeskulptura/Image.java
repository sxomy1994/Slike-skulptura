package com.example.android.slikeskulptura;

public class Image {

    /**String za ime vajara*/
    private String mImeVajaraId;

    /**String za naziv skulpture i godinom nastanka*/
    private String mNazivIGodinaId;

    /**ID slike skulpture */
    private int mSlikaSkulptureId;


    /**
     * Kreiramo novi Image objekt
     * @param imeVajaraId ID Stringa za ime i prezime vajara koji je izradio skulpturu
     * @param nazivIGodinaId ID Stringa za Naziv skulpture i godina kada je nastala
     * @param slikaSkulptureId ID Slike koja predstavlja skulpturu
     */
    public Image(String imeVajaraId, String nazivIGodinaId, int slikaSkulptureId){
        mImeVajaraId = imeVajaraId;
        mNazivIGodinaId = nazivIGodinaId;
        mSlikaSkulptureId = slikaSkulptureId;
    }


    /**
     * Get metoda za dobijanje ID za  imena vajara
     */
    public String getImeVajaraId(){
        return mImeVajaraId;
    }

    /**
     * Get metoda za dobijanje ID za naziva skuplture i godinu
     */
    public String getNazivIGodinaId(){
        return mNazivIGodinaId;
    }

    /**
     * Get metoda za dobijanje ID slike skulpture
     */
    public int getSlikaSkulptureId(){
        return mSlikaSkulptureId;
    }

}
