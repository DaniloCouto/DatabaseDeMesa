package br.com.fulltime.aprendiz.databasedemesa;

import java.util.ArrayList;

import br.com.fulltime.aprendiz.databasedemesa.adaptador.ItemMenuLateral;
import br.com.fulltime.aprendiz.databasedemesa.adaptador.NewListAdapter;
import br.com.fulltime.aprendiz.databasedemesa.database.DaoItem;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragment;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragmentAlterar;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragmentCadastro;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragmentConsulta;
import br.com.fulltime.aprendiz.databasedemesa.fragmentos.ContainerFragmentInicio;
import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Container,callBackInterface{
	
	private ActionBarDrawerToggle mActionBarDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private ListView mListView;
	private ArrayList<ItemMenuLateral> itens; 
	private ContainerFragment mCurrentContainerFragment;
	private FragmentTransaction mFragmentTransaction;
	private ActionBar mActionBar;	
	private callBackInterface callBack = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		preencherMenu();
		NewListAdapter adapter = new NewListAdapter(itens, MainActivity.this);
		mActionBar = getSupportActionBar();
		mListView = (ListView)findViewById(R.id.ListaDeFuncionalidades);
		mListView.setBackgroundColor(Color.WHITE);
		mListView.setAdapter(adapter);
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
		mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name, R.string.app_name);
		mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
		mFragmentTransaction = getFragmentManager().beginTransaction();
		mFragmentTransaction.add(R.id.container, new ContainerFragmentInicio());
		mFragmentTransaction.commit();
		getFragmentManager().executePendingTransactions();
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch(position){
					case 0:
						if (mCurrentContainerFragment instanceof ContainerFragmentInicio) {}else{
							addContainerFragment(new ContainerFragmentInicio(), false, false);
							mActionBar.setTitle(R.string.app_name);
						}
					break;
					case 1:
						if (mCurrentContainerFragment instanceof ContainerFragmentCadastro) {}else{
							addContainerFragment(new ContainerFragmentCadastro(callBack), false, false);
							mActionBar.setTitle("Cadastro");
						}
					break;
					case 2:
						if (mCurrentContainerFragment instanceof ContainerFragmentConsulta) {}else{
							addContainerFragment(new ContainerFragmentConsulta(callBack), false, false);
							mActionBar.setTitle("Pesquisa");
						}
					break;
					
				}
				mDrawerLayout.closeDrawers();
			}
		});
	}

	
	private void preencherMenu(){
		Resources r = getResources();
		String[] texto = r.getStringArray(R.array.menu_lateral_nome);
		String[] desc = r.getStringArray(R.array.menu_lateral_desc);
		int[] ico = new int[]{R.drawable.ic_home,R.drawable.ic_edit,R.drawable.ic_person};
		itens = new ArrayList<ItemMenuLateral>();
		for(int i = 0 ; i < texto.length; i++){
			itens.add(new ItemMenuLateral(ico[i],texto[i],desc[i]));
		}
		
	}
	
	private void addContainerFragment(ContainerFragment f, boolean addBackStack,boolean limparBackStack){
		if(limparBackStack){
			limparBackStack();
		}
		mFragmentTransaction = getFragmentManager().beginTransaction();
		mFragmentTransaction.replace(R.id.container, f);
		if(addBackStack){
			mFragmentTransaction.addToBackStack(null);
		}
		mFragmentTransaction.commit();
		getFragmentManager().executePendingTransactions();
	}
	
	private void limparBackStack(){
		FragmentManager fm = getFragmentManager();
		while(fm.getBackStackEntryCount() > 0){
			fm.popBackStack();
		}
		fm.executePendingTransactions();
	}
	
	@Override
	public void setCurrentContainerFragment(ContainerFragment f) {
		mCurrentContainerFragment = f;
	}

	@Override
	public ContainerFragment getCurrentContainerFragment() {
		return mCurrentContainerFragment;
	}

	public void onItemSelect(Bundle b){
		addContainerFragment(new ContainerFragmentAlterar(b,callBack), false, false);
		
	}
	
	public void openDrawers(String s){
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
		addContainerFragment(new ContainerFragmentInicio(),false,false);
		mDrawerLayout.openDrawer(Gravity.LEFT);
	}
}
