package Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBHelper(Context context) {

        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(email TEXT primary key, senha TEXT, nome TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
    }
    public Boolean insertData(String nome, String senha, String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("senha",senha);
        values.put("nome",nome);
        values.put("email",email);

        long result=db.insert("usuarios", null, values);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkemail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios where email=?", new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    public Boolean checksenha(String email,String senha){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios where email=? and senha=?",new String[]{email,senha});

        if(cursor.getCount()>0)
            return true;
        else return false;
    }
 }
