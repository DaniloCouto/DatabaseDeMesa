package br.com.fulltime.aprendiz.databasedemesa.fragmentos;

import br.com.fulltime.aprendiz.databasedemesa.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContainerFragmentInicio extends ContainerFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_inicio, container, false);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}	
	
	
}
