package br.com.jungle.conexaobanco;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.jungle.conexaobanco.Class.User;

public class MainActivity extends AppCompatActivity {

    ListView lstView;
    Button btnAdd, btnEdit, btnDelete;
    EditText edtUser;
    User userSelected = null;
    List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView = (ListView) findViewById(R.id.listView);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        edtUser = (EditText) findViewById(R.id.edUsername);

        new GetData().execute(Common.getAddressAPI());

    }

    class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd.setTitle("Por Favor Aguarde...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String stream=null;
            String urlString = params[0];

            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.GetHTTPData(urlString);
            return stream;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>(){}.getType();
            users=gson.fromJson(s,listType);
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), users);
            lstView.setAdapter(adapter);

            pd.dismiss();
        }

    }
}
