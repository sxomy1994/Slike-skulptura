package com.example.android.slikeskulptura;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    /**
     * Kreiramo konstruktor
     * @param fm menadzer fragmenata koji zadrzava stanje svakog fragmenta u adapteru
     *           prevlacenjem (swipe)
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Vraca {@link Fragment} koji treba biti prikazan na zadatoj strani
     */
    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new prvihPetnaestFragment();
        } else if(i==1){
            return  new _15Do30Fragment();
        } else  if(i == 2){
            return new _30do45Fragment();
        } else {
            return new _45do60Fragment();
        }
    }

    /**
     * @return ukupan broj strana
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.prvih_petnaest);
        } else if(position == 1){
            return mContext.getString(R.string.drugih_petanest);
        } else if(position == 2){
            return mContext.getString(R.string.trecih_petnaest);
        } else {
            return mContext.getString(R.string.cetvrtih_petnaest);
        }
    }
}
