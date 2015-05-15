package br.com.fulltime.aprendiz.databasedemesa.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fulltime.aprendiz.databasedemesa.R;
import br.com.fulltime.aprendiz.databasedemesa.callBackInterface;
import br.com.fulltime.aprendiz.databasedemesa.database.DaoItem;
import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;

public class ContainerFragmentAlterar extends ContainerFragment {
	Bundle bundle;
	callBackInterface callback;
	DaoItem dao;
	String s;
	EditText edtNome;
	
	public ContainerFragmentAlterar(Bundle b,callBackInterface c) {
		bundle =  b;
		callback = c;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_cadastro, container, false);
		Button b = (Button)v.findViewById(R.id.btnCadastro);
		b.setText("Alterar");
		edtNome =  (EditText)v.findViewById(R.id.edtCadastroNome);
		edtNome.setText(bundle.getString("NOME"));
		dao = new DaoItem(getActivity());
		
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				s =  edtNome.getText().toString();
				final Item item =  new Item(bundle.getLong("_id"),s);
				dao.updateItem(item);
				callback.openDrawers("Item "+bundle.getString("NOME")+" foi alterado");
			}
		});
		Button b2 = (Button)v.findViewById(R.id.btnDeletar);
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dao.deleteItem(bundle.getLong("_id"));
				callback.openDrawers("Item "+bundle.getString("NOME")+" foi deletado");
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
