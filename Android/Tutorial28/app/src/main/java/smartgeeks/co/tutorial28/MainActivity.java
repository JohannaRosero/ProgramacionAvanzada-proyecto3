package smartgeeks.co.tutorial28;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnconsultar, btnGuardar;
    TextView textito;
    EditText etId;
    protected Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;
    protected Button[] ArrButton;
    int posiciones[]=new int[25];

    Object[] matriz;

    public void init(){

        matriz = new Object[25];
        for(int i =0 ; i < 25 ; i++){
            matriz[i]= R.drawable.x;
        }
        for(int i =0 ; i < 25 ; i++){
            posiciones[i]=0;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnconsultar = (Button)findViewById(R.id.btnConsultar);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        etId= (EditText)findViewById(R.id.etId);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn13 = (Button)findViewById(R.id.btn13);
        btn14 = (Button)findViewById(R.id.btn14);
        btn15 = (Button)findViewById(R.id.btn15);
        btn16 = (Button)findViewById(R.id.btn16);
        btn17 = (Button)findViewById(R.id.btn17);
        btn18 = (Button)findViewById(R.id.btn18);
        btn19 = (Button)findViewById(R.id.btn19);
        btn20 = (Button)findViewById(R.id.btn20);
        btn21 = (Button)findViewById(R.id.btn21);
        btn22 = (Button)findViewById(R.id.btn22);
        btn23 = (Button)findViewById(R.id.btn23);
        btn24 = (Button)findViewById(R.id.btn24);
        btn25 = (Button)findViewById(R.id.btn25);
        textito= (TextView)findViewById(R.id.textito);
        this.init();
        ArrButton = new Button[]{btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25};
        for(Button b : ArrButton){
            b.setOnClickListener(this);
        }
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ConsultarDatos().execute("http://10.0.2.2/CursoAndroid/consulta.php?id=1");

            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;
                new CargarDatos().execute("http://10.0.2.2/CursoAndroid/registro.php?id=1&nombres=1");

            }
        });



    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;
        new CargarDatos().execute("http://10.0.2.2/CursoAndroid/registro.php?id="+b.getText().toString()+"&nombres=1");
        this.click(b);
    }

    public void click(Button b){

        int a = Integer.parseInt(b.getText().toString());
        int x = 0;
        x=R.drawable.x;
        ArrButton[a-1].setBackgroundResource(x);
    }

    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();

        }
    }


    private class ConsultarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            JSONArray ja = null;
            int x = 0;
            x=R.drawable.x;
            try {
                ja = new JSONArray(result);
                etId.setText(ja.getString(0));

                 for(int i=0 ; i<result.length();i ++){
                    //posiciones[i]= Integer.parseInt(ja.getString(0));

                    //ArrButton[Integer.parseInt(ja.getString(0))].setBackgroundResource(x);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
    public void actualizar(){

    }
}
