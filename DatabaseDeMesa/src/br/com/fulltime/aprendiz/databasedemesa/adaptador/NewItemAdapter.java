package br.com.fulltime.aprendiz.databasedemesa.adaptador;

import java.util.ArrayList;
import java.util.List;

import br.com.fulltime.aprendiz.databasedemesa.R;
import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewItemAdapter extends BaseAdapter {
	private List<Item> itens;
	private LayoutInflater inflater;
	private Context context;
	
	public NewItemAdapter(Context context, List<Item> itens) {
		super();
		this.itens = itens;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itens.size();
	}

	@Override
	public Item getItem(int position) {
		// TODO Auto-generated method stub
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView  = inflater.inflate(R.layout.item_consulta, null);
		}
		TextView t = (TextView)convertView.findViewById(R.id.txtListItemConsulta);
		t.setText(getItem(position).getNome());
				
		return convertView;
	}

}
