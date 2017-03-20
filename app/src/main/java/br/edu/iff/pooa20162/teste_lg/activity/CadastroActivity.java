package br.edu.iff.pooa20162.teste_lg.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.iff.pooa20162.teste_lg.R;

import br.edu.iff.pooa20162.teste_lg.model.Proprietario;

public class CadastroActivity extends Activity {

    EditText nome,endereco, telefone, dataNasc;
    Button btsalvar,btalterar;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);Intent intent    = getIntent();
        id = (Long) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");
        String enderecop = (String) intent.getSerializableExtra("endereco");
        String telefonep     = (String) intent.getSerializableExtra("telefone");
        String dataNascp     = (String) intent.getSerializableExtra("dataNasc");


        EditText nome = (EditText) findViewById(R.id.etNomeP);
        nome.setText(nomep);


        EditText endereco = (EditText) findViewById(R.id.etEnderecoP);
        endereco.setText(enderecop);

        EditText telefone = (EditText) findViewById(R.id.etTelefoneP);
        telefone.setText(telefonep);

        EditText data = (EditText) findViewById(R.id.etDataNascP);
        data.setText(dataNascp);


        btsalvar = (Button) findViewById(R.id.btSalvarP);
        btalterar = (Button) findViewById(R.id.btAlterarP);


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

        nome = (EditText) findViewById(R.id.etNomeP);
        endereco = (EditText) findViewById(R.id.etEnderecoP);
        telefone = (EditText) findViewById(R.id.etTelefoneP);
        dataNasc = (EditText) findViewById(R.id.etDataNascP);

        Proprietario proprietario = new Proprietario(nome.getText().toString(),endereco.getText().toString(),
                telefone.getText().toString(),dataNasc.getText().toString());

        proprietario.save();

        Toast.makeText(this,"Proprietário Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        nome = (EditText) findViewById(R.id.etNomeP);
        endereco = (EditText) findViewById(R.id.etEnderecoP);
        telefone = (EditText) findViewById(R.id.etTelefoneP);
        dataNasc = (EditText) findViewById(R.id.etDataNascP);


        Proprietario proprietario = Proprietario.findById(Proprietario.class, id);

        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setDataNasc(dataNasc.getText().toString());

        proprietario.save();

        Toast.makeText(this,"Proprietário Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
