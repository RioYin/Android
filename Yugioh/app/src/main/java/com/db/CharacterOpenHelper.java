
package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hpl on 2015/12/13.
 */

public class CharacterOpenHelper extends SQLiteOpenHelper {

    private Context mContext;

    public static final String CREATE_MONSTER_CARD = "create table MonsterCard ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "type text, "
            + "attack integer, "
            + "defence integer, "
            + "level_rank text)";


    public static final String CREATE_MAGIC_CARD = "create table MagicCard ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "type text)";

    public static final String CREATE_TRAP_CARD = "create table TrapCard ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "type text)";


    public CharacterOpenHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MONSTER_CARD);
        db.execSQL(CREATE_MAGIC_CARD);
        db.execSQL(CREATE_TRAP_CARD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists MonsterCard");
        db.execSQL("drop table if exists MagicCard");
        db.execSQL("drop table if exists TrapCard");
        onCreate(db);
    }
}
