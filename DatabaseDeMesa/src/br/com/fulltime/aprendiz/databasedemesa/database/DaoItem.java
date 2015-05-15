package br.com.fulltime.aprendiz.databasedemesa.database;

import java.util.ArrayList;
import java.util.List;

import br.com.fulltime.aprendiz.databasedemesa.objetos.Item;
import br.com.fulltime.aprendiz.databasedemesa.state.Constantes;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DaoItem {
	private static final String TAG_LOG = "Banco_de_Dados";
	private SQLiteDatabase db;
	private OpenHelper openHelper;
	private Cursor cursor = null;
	
	public DaoItem(Context context) {
		openHelper = new OpenHelper(context);
	}
	
	public void open(){
		try{
		db = openHelper.getWritableDatabase();
		}catch(SQLiteException e){
			Log.i(TAG_LOG, "SQlite Error: Impossivel de Abrir \n"+ e.getMessage());
		}
	}
	
	public void close(){
		if(openHelper != null && db.isOpen()){
            openHelper.close();
        }
	}
	
	public long insertItem(Item item){
		long lastId = -1;
		if(item != null){
			open();
			try{
				lastId = db.insert(Constantes.ITEM_TABELA, null, getValuesItem(item));
			}catch(SQLiteException e){
				Log.i(TAG_LOG, "SQLite Error: Erro ao Inserir \n"+e.getMessage());
			}
			close();
		}
		
		return lastId;
	}
	
	public boolean deleteItem(long l){
		if(!"".equals(l)){
			int itensDeletados = 0;
			open();
			try{
				 itensDeletados = db.delete(Constantes.ITEM_TABELA, "_id = ?", new String[]{String.valueOf(l)});
			}catch(SQLException e){
				Log.i(TAG_LOG, "SQLite Erro: Falha ao deletar \n"+e.getMessage());
			}
			close();
			if(itensDeletados > 0){
				return true;
			}
		}
		return false;
	}
	
	public boolean updateItem(Item item){
		if(item != null){
			int update = 0;
			open();
			try{
				update = db.update(Constantes.ITEM_TABELA, getValuesItem(item), "_id = ?", new String[]{String.valueOf(item.getId())} );
			}catch(SQLiteException e){
				Log.i(TAG_LOG, "SQLite Error: Erro ao Inserir \n"+e.getMessage());
			}
			close();
			if(update > 0){
				return true;
			}
		}
		return false;
	}
	
	public List<Item> queryItem(String s){
		List<Item> resultado =  new ArrayList<Item>();
		open();
			try{
				cursor = db.query(Constantes.ITEM_TABELA, null, Constantes.ITEM_COLUNAS[0]+" LIKE ?", new String[]{"%"+s+"%"}, null, null, null);
			}catch(SQLiteException e){
				Log.i(TAG_LOG, "SQLite Error: Erro ao Consultar \n"+e.getMessage());
			}
		while(cursor.moveToNext()){
			Item item = new Item(cursor.getLong(0),cursor.getString(1));
			resultado.add(item);
		}
		close();
		return resultado;
	}
	
	public List<Item> queryItem(long id){
		List<Item> resultado =  new ArrayList<Item>();
		open();
			try{
				cursor = db.query(Constantes.ITEM_TABELA, null, "_id = ?", new String[]{String.valueOf(id)}, null, null, null);
			}catch(SQLiteException e){
				Log.i(TAG_LOG, "SQLite Error: Erro ao Consultar \n"+e.getMessage());
			}
		while(cursor.moveToNext()){
			Item item = new Item(cursor.getLong(0),cursor.getString(1));
			resultado.add(item);
		}
		close();
		return resultado;
	}
	
	public List<Item> queryItem(){
		List<Item> resultado =  new ArrayList<Item>();
		open();
			try{
				cursor = db.query(Constantes.ITEM_TABELA, null, null , null, null, null, null);
			}catch(SQLiteException e){
					Log.i(TAG_LOG, "SQLite Error: Erro ao Consultar \n"+e.getMessage());
			}
		if(cursor != null && cursor.getCount() >0)	
			while(cursor.moveToNext()){
				Item item = new Item(cursor.getLong(0),cursor.getString(1));
				resultado.add(item);
			}
		close();
		return resultado;
	}
	private ContentValues getValuesItem(Item item){
		ContentValues content = new ContentValues();
		content.put(Constantes.ITEM_COLUNAS[0], item.getNome());
		return content;
	}
	
}
