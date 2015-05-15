package br.com.fulltime.aprendiz.databasedemesa.database;

import br.com.fulltime.aprendiz.databasedemesa.state.Constantes;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {
	
	public OpenHelper(Context context) {
		super(context,Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String comando = goCreateMainTable(Constantes.ITEM_TABELA, Constantes.ITEM_COLUNAS, Constantes.ITEM_COLUNAS_TIPOS);
		db.execSQL(comando);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	private String goCreateMainTable(String TABLE_NAME, String[] COLUM_NAMES, String[] COLUM_TYPES){
		String comando = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("
				+ "_ID INTEGER PRIMARY KEY AUTOINCREMENT, ";
		for(int i = 0; i < COLUM_NAMES.length ; i++){
			comando += COLUM_NAMES[i]+" "+COLUM_TYPES[i];
			if(i != (COLUM_NAMES.length)-1){
				comando += ", ";
			}
		}
		comando +=");";
		return comando;
	}

}
