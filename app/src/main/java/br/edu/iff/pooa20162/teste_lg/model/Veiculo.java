package br.edu.iff.pooa20162.teste_lg.model;

/**
 * Created by rodri on 18/03/2017.
 */

import com.orm.SugarRecord;

public class Veiculo  extends SugarRecord {
    private String marca;
    private String modelo;
    private String ano;
    private String placa;

    public Veiculo(String marca, String modelo, String ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public Veiculo(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

