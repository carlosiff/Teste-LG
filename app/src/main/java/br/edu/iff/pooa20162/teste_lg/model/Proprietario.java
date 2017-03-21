package br.edu.iff.pooa20162.teste_lg.model;

/**
 * Created by aluno on 06/03/17.
 */

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Proprietario  extends SugarRecord implements Parcelable {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String dataNasc;

    public Proprietario(String nome, String endereco, String telefone, String dataNasc) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    List<Veiculo> getVeiculos() {
        return Veiculo.find(Veiculo.class, "proprietario = ?", new String(getId().toString()));
    }


    public Proprietario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeLong(id);

    }

    public Long getId() {
        return id;
    }

    private Proprietario(Parcel from){

        id = from.readLong();
        endereco = from.readString();
        nome = from.readString();
    }

    public static final Parcelable.Creator<Proprietario>
            CREATOR = new Parcelable.Creator<Proprietario>() {

        public Proprietario createFromParcel(Parcel in) {
            return new Proprietario(in);
        }

        public Proprietario[] newArray(int size) {
            return new Proprietario[size];
        }
    };

    @Override
    public String toString()
    {
        return nome;
    }
}

