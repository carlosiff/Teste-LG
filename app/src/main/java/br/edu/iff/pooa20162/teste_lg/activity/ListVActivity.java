package br.edu.iff.pooa20162.teste_lg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.teste_lg.R;
import br.edu.iff.pooa20162.teste_lg.adapter.VeiculoAdapter;
import br.edu.iff.pooa20162.teste_lg.model.Veiculo;

public class ListVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListVActivity.this,CadastroVActivity.class);
                intent.putExtra("id",Long.valueOf(0));
                intent.putExtra("marca","");
                intent.putExtra("modelo","");
                intent.putExtra("ano","");
                intent.putExtra("placa","");
                intent.putExtra("proprietario","");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Veiculo>  veiculos  = (ArrayList) Veiculo.listAll(Veiculo.class);

        ListView lista = (ListView) findViewById(R.id.lvVeiculos);
        ArrayAdapter adapter = new VeiculoAdapter(this,veiculos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListVActivity.this,CadastroVActivity.class);

                intent.putExtra("id",veiculos.get(i).getId());
                intent.putExtra("marca",veiculos.get(i).getMarca());
                intent.putExtra("modelo",veiculos.get(i).getModelo());
                intent.putExtra("ano",veiculos.get(i).getAno());
                intent.putExtra("placa",veiculos.get(i).getPlaca());
                //intent.putExtra("proprietario",veiculos.get(i).getProprietario().getId());

                startActivity(intent);

            }
        });
    }
}
