package br.com.fulltime.aprendiz.databasedemesa.adaptador;

import java.util.ArrayList;

import br.com.fulltime.aprendiz.databasedemesa.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewListAdapter extends BaseAdapter {
	private ArrayList<ItemMenuLateral> itemMenu;
	private LayoutInflater inflater;
	private Context context;
	
	
	public NewListAdapter(ArrayList<ItemMenuLateral> itemMenu, Context context) {
		this.itemMenu = itemMenu;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return itemMenu.size();
	}

	@Override
	public ItemMenuLateral getItem(int position) {
		// TODO Auto-generated method stub
		return itemMenu.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_menu_lateral, null);	
		}
		TextView txt1 = newText(convertView, R.id.txtItemMenuLateral, getItem(position).getTexto());
		TextView txt2 = newText(convertView, R.id.txtItemMenuLateral2,getItem(position).getDescricao());
		ImageView img = newImage(convertView,R.id.imgItemMenuLateral, getItem(position).getIco());
		
		return convertView;
	}
	
	private TextView newText(View v, int resId, String text){
		TextView retorno = (TextView)v.findViewById(resId);
		retorno.setText(text);
		return retorno;
	}
	
	private ImageView newImage(View v, int resId, int ico){
		ImageView retorno = (ImageView)v.findViewById(resId);
		retorno.setImageResource(ico);
		retorno.setColorFilter(Color.BLACK);
		return retorno;
	}
	
	
		
}
