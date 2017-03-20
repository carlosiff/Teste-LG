package br.edu.iff.pooa20162.teste_lg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.teste_lg.R;
import br.edu.iff.pooa20162.teste_lg.model.Veiculo;

/**
 * Created by rodri on 18/03/2017.
 */

public class VeiculoAdapter extends ArrayAdapter<Veiculo> {

    private Context context = null;
    private ArrayList<Veiculo> veiculos = null;


    public VeiculoAdapter(Context context, ArrayList<Veiculo> veiculos) {
        super(context, R.layout.linhaveiculo,veiculos);
        this.context = context;
        this.veiculos = veiculos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaveiculo, parent, false);

        TextView marca = (TextView) rowView.findViewById(R.id.tvllvMarca);
        TextView modelo = (TextView) rowView.findViewById(R.id.tvllvModelo);
        TextView ano = (TextView) rowView.findViewById(R.id.tvllvAno);
        TextView placa = (TextView) rowView.findViewById(R.id.tvllvPlaca);

        marca.setText(veiculos.get(position).getMarca());
        modelo.setText(veiculos.get(position).getModelo());
        ano.setText(veiculos.get(position).getAno());
        placa.setText(veiculos.get(position).getPlaca());
        return rowView;
    }


}