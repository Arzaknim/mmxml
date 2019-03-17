package com.example.domxml;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Declare variables
    public String search  = "tip";
    public TextView textview;
    NodeList nodelist;
    ProgressDialog pDialog;
    //ArrayList<Podnik> podniky = new ArrayList<>();
    Podniky podniky = new Podniky();
    String[] tmp = new String[7];
    int count = 0;
    // Insert image URL
    String URL = "https://egov.presov.sk/Default.aspx?NavigationState=163:0::plac580:_144026_5_1";//"https://www.androidbegin.com/tutorial/XMLParseTutorial.xml"
    //"https://egov.presov.sk/Default.aspx?NavigationState=163:0::plac580:_144026_5_1"
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);
        // Locate a TextView in your activity_main.xml layout
        textview = (TextView) findViewById(R.id.text);
        // Execute DownloadXML AsyncTask
        Intent intent = getIntent();
        search = intent.getStringExtra(IntroActivity.EXTRA_SEARCH);
        new DownloadXML().execute(URL);
    }

    // DownloadXML AsyncTask
    private class DownloadXML extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressbar
            pDialog = new ProgressDialog(MainActivity.this);
            // Set progressbar title
            pDialog.setTitle("Parsujem");
            // Set progressbar message
            pDialog.setMessage("Nacitava sa...");
            pDialog.setIndeterminate(false);
            // Show progressbar
            pDialog.show();
        }

        @Override
        protected Void doInBackground(String... Url) {
            try {
                URL url = new URL(Url[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                // Download the XML file
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
                // Locate the Tag Name
                nodelist = doc.getElementsByTagName("row");

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void args) {

            for (int temp = 0; temp < nodelist.getLength(); temp++) {
                Node nNode = nodelist.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // Set the texts into TextViews from item nodes
                    // Get the title
                        podniky.addPodnik(new Podnik());
                        podniky.getPodnik(temp).setObchodne_Meno(eElement.getAttribute("col_0"));
                        podniky.getPodnik(temp).setPrevadzka(eElement.getAttribute("col_1"));
                        podniky.getPodnik(temp).setCinnost(eElement.getAttribute("col_2"));
                        podniky.getPodnik(temp).setUlica(eElement.getAttribute("col_3"));
                        podniky.getPodnik(temp).setSup_C(eElement.getAttribute("col_4"));
                        podniky.getPodnik(temp).setOr_C(eElement.getAttribute("col_5"));
                        podniky.getPodnik(temp).setObec(eElement.getAttribute("col_6"));
                        podniky.getPodnik(temp).setAdresa_Prevadzky(eElement.getAttribute("col_7"));
                        podniky.getPodnik(temp).setICO(eElement.getAttribute("col_8"));
                        podniky.getPodnik(temp).setDatum_Zacatia_Prevadzky(eElement.getAttribute("col_9"));
                        for (int i = 0; i < 7; i++) {
                            tmp[i] = eElement.getAttribute("col_" + 1 + i);
                        }
                        podniky.getPodnik(temp).setPrevadzkova_Doba(tmp);
                        /*textview.setText(textview.getText() + podniky.get(temp).getObchodne_Meno() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getPrevadzka() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getCinnost() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getUlica() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getSup_C() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getOr_C() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getObec() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getAdresa_Prevadzky() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getICO() + "\n");
                        textview.setText(textview.getText() + podniky.get(temp).getDatum_Zacatia_Prevadzky() + "\n\n\n");*/


                }
            }
            podniky.printPodnikyByName(search, textview);
            // Close progressbar
            pDialog.dismiss();
        }
    }

    // getNode function
    private static String getNode(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
                .getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}