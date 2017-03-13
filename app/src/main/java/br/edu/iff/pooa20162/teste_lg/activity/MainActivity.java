package br.edu.iff.pooa20162.teste_lg.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.Intent;



import br.edu.iff.pooa20162.teste_lg.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaCadastrop(View v){
        Intent intentp = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intentp);
    }

    public void chamaTelaCadastrov(View v){
        Intent intentv = new Intent(MainActivity.this, ListVActivity.class);
        startActivity(intentv);
    }

    private Context getContext(){
        return this;
    }
}
