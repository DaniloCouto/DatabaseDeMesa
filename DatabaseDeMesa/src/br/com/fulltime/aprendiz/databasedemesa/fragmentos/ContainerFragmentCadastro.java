package br.com.fulltime.aprendiz.databasedemesa.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fulltime.aprendiz.databasedemesa.R;
import br.com.fulltime.aprendiz.databasedemesa.callBackInterface;
import br.com.fulltime.aprendiz.databasedemesa.database.DaoItem;
import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;
import android.view.View.OnClickListener;

public class ContainerFragmentCadastro extends ContainerFragment {
	private callBackInterface callback;
	DaoItem dao;
	String temp;
	EditText edtnome;
	
	public ContainerFragmentCadastro(callBackInterface c) {
		callback = c;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
		Button b = (Button)v.findViewById(R.id.btnDeletar);
		b.setVisibility(View.GONE);
		edtnome = (EditText)v.findViewById(R.id.edtCadastroNome);
		temp = edtnome.getText().toString();
		Button b2 = (Button)v.findViewById(R.id.btnCadastro);
		dao = new DaoItem(getActivity());
		
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				temp = edtnome.getText().toString();
				dao.insertItem(new Item(0,temp));
				callback.openDrawers("Item "+temp+" cadastrado com sucesso!");
			}
		});
		return v;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
}
