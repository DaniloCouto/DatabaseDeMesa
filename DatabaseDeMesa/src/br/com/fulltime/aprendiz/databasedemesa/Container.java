package br.com.fulltime.aprendiz.databasedemesa;

import android.os.Bundle;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragment;

public interface Container {
	public abstract void setCurrentContainerFragment(ContainerFragment f);
	public abstract ContainerFragment getCurrentContainerFragment();
}
