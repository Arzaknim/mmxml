package com.example.domxml;

import android.widget.TextView;

public class Podnik {
    private String Obchodne_Meno;
    private String Prevadzka;
    private String Cinnost;
    private String Ulica;
    private String Sup_C;
    private String Or_C;
    private String Obec;
    private String Adresa_Prevadzky;
    private String ICO;
    private String Datum_Zacatia_Prevadzky;
    private String[] Prevadzkova_Doba = new String[7];

    public String getObchodne_Meno() {
        return Obchodne_Meno;
    }

    public void setObchodne_Meno(String obchodne_Meno) {
        Obchodne_Meno = obchodne_Meno;
    }

    public String getPrevadzka() {
        return Prevadzka;
    }

    public void setPrevadzka(String prevadzka) {
        Prevadzka = prevadzka;
    }

    public String getCinnost() {
        return Cinnost;
    }

    public void setCinnost(String cinnost) {
        Cinnost = cinnost;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public String getSup_C() {
        return Sup_C;
    }

    public void setSup_C(String sup_C) {
        Sup_C = sup_C;
    }

    public String getOr_C() {
        return Or_C;
    }

    public void setOr_C(String or_C) {
        Or_C = or_C;
    }

    public String getObec() {
        return Obec;
    }

    public void setObec(String obec) {
        Obec = obec;
    }

    public String getAdresa_Prevadzky() {
        return Adresa_Prevadzky;
    }

    public void setAdresa_Prevadzky(String adresa_Prevadzky) {
        Adresa_Prevadzky = adresa_Prevadzky;
    }

    public String getICO() {
        return ICO;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public String getDatum_Zacatia_Prevadzky() {
        return Datum_Zacatia_Prevadzky;
    }

    public void setDatum_Zacatia_Prevadzky(String datum_Zacatia_Prevadzky) {
        Datum_Zacatia_Prevadzky = datum_Zacatia_Prevadzky;
    }

    public String getPrevadzkova_Doba(int index) {
        return Prevadzkova_Doba[index];
    }

    public void setPrevadzkova_Doba(String[] prevadzkova_Doba) {
        Prevadzkova_Doba = prevadzkova_Doba;
    }
    /*public void printAllByName(String str, TextView textview){
        if (this.getObchodne_Meno().contains(str)){
            textview.setText(textview.getText() + podniky.get(temp).getObchodne_Meno() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getPrevadzka() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getCinnost() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getUlica() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getSup_C() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getOr_C() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getObec() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getAdresa_Prevadzky() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getICO() + "\n");
            textview.setText(textview.getText() + podniky.get(temp).getDatum_Zacatia_Prevadzky() + "\n\n\n");
        }
    }*/
}
