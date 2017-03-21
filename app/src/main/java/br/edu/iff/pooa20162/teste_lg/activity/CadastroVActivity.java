package br.edu.iff.pooa20162.teste_lg.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.Spinner;

import br.edu.iff.pooa20162.teste_lg.R;

import br.edu.iff.pooa20162.teste_lg.adapter.ProprietarioAdapter;
import br.edu.iff.pooa20162.teste_lg.model.Veiculo;
import br.edu.iff.pooa20162.teste_lg.model.Proprietario;


public class CadastroVActivity extends Activity {

    EditText marca,modelo,ano,placa;
    Spinner spProprietario;
    Button btsalvar,btalterar;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_v);Intent intent    = getIntent();
        id = (Long) intent.getSerializableExtra("id");

        String marcav     = (String) intent.getSerializableExtra("marca");
        String modelov = (String) intent.getSerializableExtra("modelo");
        String anov     = (String) intent.getSerializableExtra("ano");
        String placav     = (String) intent.getSerializableExtra("placa");

        EditText marca = (EditText) findViewById(R.id.etMarcaV);
        marca.setText(marcav);

        EditText modelo = (EditText) findViewById(R.id.etModeloV);
        modelo.setText(modelov);

        EditText ano = (EditText) findViewById(R.id.etAnoV);
        ano.setText(anov);

        EditText placa = (EditText) findViewById(R.id.etPlacaV);
        placa.setText(placav);

        final ArrayList<Proprietario> proprietarios  = (ArrayList) Proprietario.listAll(Proprietario.class);

        ArrayAdapter<Proprietario> adapter = new ArrayAdapter<Proprietario>(this, android.R.layout.simple_spinner_item, proprietarios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spProprietario = (Spinner) findViewById(R.id.spProprietarioinVeiculo);
        spProprietario.setAdapter(adapter);

        btsalvar = (Button) findViewById(R.id.btSalvarV);
        btalterar = (Button) findViewById(R.id.btAlterarV);


        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar() {

        marca = (EditText) findViewById(R.id.etMarcaV);
        modelo = (EditText) findViewById(R.id.etModeloV);
        ano = (EditText) findViewById(R.id.etAnoV);
        placa = (EditText) findViewById(R.id.etPlacaV);
        Proprietario proprietario  = ((Proprietario) spProprietario.getSelectedItem());


        Veiculo veiculo = new Veiculo(marca.getText().toString(),modelo.getText().toString(),
                ano.getText().toString(),placa.getText().toString(),proprietario);

        veiculo.save();

        Toast.makeText(this,"Veículo Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        marca = (EditText) findViewById(R.id.etMarcaV);
        modelo = (EditText) findViewById(R.id.etModeloV);
        ano = (EditText) findViewById(R.id.etAnoV);
        placa = (EditText) findViewById(R.id.etPlacaV);
        Proprietario proprietario  = ((Proprietario) spProprietario.getSelectedItem());


        Veiculo veiculo = Veiculo.findById(Veiculo.class, id);

        veiculo.setMarca(marca.getText().toString());
        veiculo.setModelo(modelo.getText().toString());
        veiculo.setAno(ano.getText().toString());
        veiculo.setPlaca(placa.getText().toString());
        veiculo.setProprietario(proprietario);

        veiculo.save();

        Toast.makeText(this,"Veículo Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
