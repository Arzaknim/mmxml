package com.example.domxml;

import android.widget.TextView;

import java.util.ArrayList;

public class Podniky {
    private ArrayList<Podnik> list;

    public Podniky(){
        list = new ArrayList<>();
    }

    public ArrayList<Podnik> getList() {
        return list;
    }

    public void setList(ArrayList<Podnik> list) {
        this.list = list;
    }
    public boolean addPodnik(Podnik p){
      return list.add(p);
    }

    public Podnik getPodnik(int index){
       return list.get(index);
    }

    public void printPodnikyByName(String str, TextView textview){
        boolean x = true;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getObchodne_Meno().toLowerCase().contains(str.toLowerCase())  || list.get(i).getPrevadzka().toLowerCase().contains(str.toLowerCase())){
                textview.setText(textview.getText() + list.get(i).getObchodne_Meno() + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzka() + "\n");
                textview.setText(textview.getText() + list.get(i).getCinnost() + "\n");
                textview.setText(textview.getText() + list.get(i).getUlica() + "\n");
                textview.setText(textview.getText() + list.get(i).getSup_C() + "\n");
                textview.setText(textview.getText() + list.get(i).getOr_C() + "\n");
                textview.setText(textview.getText() + list.get(i).getObec() + "\n");
                textview.setText(textview.getText() + list.get(i).getAdresa_Prevadzky() + "\n");
                textview.setText(textview.getText() + list.get(i).getICO() + "\n");
                textview.setText(textview.getText() + list.get(i).getDatum_Zacatia_Prevadzky() + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(0) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(1) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(2) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(3) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(4) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(5) + "\n");
                textview.setText(textview.getText() + list.get(i).getPrevadzkova_Doba(6) + "\n\n\n");
                x = false;
            }

        }
        if (x) {
            textview.setText("Nic sa nenaslo.");
        }
    }

}
