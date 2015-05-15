package br.com.fulltime.aprendiz.databasedemesa.fragmentos;

import br.com.fulltime.aprendiz.databasedemesa.Container;
import android.app.Fragment;
import android.os.Bundle;

public class ContainerFragment extends Fragment {
	protected Container mContainer;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		  mContainer = (Container)getActivity();
	      mContainer.setCurrentContainerFragment(this);
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mContainer = null;
	}
	
    public void handleBackFromBackStack() {
        // Implementação original não faz nada
    }
	
}
