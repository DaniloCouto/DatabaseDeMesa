package br.com.fulltime.aprendiz.databasedemesa.fragmentos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.fulltime.aprendiz.databasedemesa.MainActivity;
import br.com.fulltime.aprendiz.databasedemesa.R;
import br.com.fulltime.aprendiz.databasedemesa.callBackInterface;
import br.com.fulltime.aprendiz.databasedemesa.adaptador.NewItemAdapter;
import br.com.fulltime.aprendiz.databasedemesa.database.DaoItem;
import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;

public class ContainerFragmentConsulta extends ContainerFragment {
	private List<Item> query;
	private NewItemAdapter adapter;
	private ListView list;
	private callBackInterface callBack;
	private DaoItem dao;
	private EditText edt;
	private String s;
	
	public ContainerFragmentConsulta(callBackInterface callBack) {
		this.callBack = callBack;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		
		dao = new DaoItem(getActivity());
		query = dao.queryItem();
		View v = inflater.inflate(R.layout.fragment_consulta, container,false);
		list = (ListView)v.findViewById(R.id.Lista_Consulta);
		adapter =  new NewItemAdapter(getActivity(), query);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Bundle bundle = new Bundle();
				bundle.putLong("_id", query.get(position).getId());
				bundle.putString("NOME", query.get(position).getNome());
				callBack.onItemSelect(bundle);
			}
		});
		edt = (EditText)v.findViewById(R.id.edtConsultaNome);
		Button filtro = (Button)v.findViewById(R.id.btnConsulta);
		filtro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				query = dao.queryItem(edt.getText().toString());
				adapter = new NewItemAdapter(getActivity(), query);
				list.setAdapter(adapter);
			}
		});
		
		return v;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	private void preencherList(){
		
	}
}
