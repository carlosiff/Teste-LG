package br.edu.iff.pooa20162.teste_lg.activity;

<<<<<<< HEAD

=======
>>>>>>> 8b0a34012fcd19862491bcb7e098cd79159ed175
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.iff.pooa20162.teste_lg.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(ListActivity.this,CadastroActivity.class);
=======
                Intent intent = new Intent(ListaActivity.this,CadastroActivity.class);
>>>>>>> 8b0a34012fcd19862491bcb7e098cd79159ed175
                intent.putExtra("id",0);
                intent.putExtra("nome","");
                intent.putExtra("endereco","");
                intent.putExtra("telefone","");
                intent.putExtra("dataNasc","");

<<<<<<< HEAD
=======

>>>>>>> 8b0a34012fcd19862491bcb7e098cd79159ed175
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
}
