package com.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.db.CharacterOpenHelper;
import com.model.CharacterTrapCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpl on 2015/12/27.
 */
public class CharacterTrapCardService {


    private CharacterOpenHelper dbOperateHelper;


    public CharacterTrapCardService(Context context) {

        this.dbOperateHelper = new CharacterOpenHelper(context, "Card.db", null, 1);
    }


    public List<CharacterTrapCard> getScrollData(int offset,int maxResult){

        SQLiteDatabase sqldb = dbOperateHelper.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery("select * from TrapCard order by id asc limit ?,?", new String[]{String.valueOf(offset), String.valueOf(maxResult)});
        int id;
        String title;
        String type;
        CharacterTrapCard charactertrapcard = null;
        List<CharacterTrapCard> charactertrapcards = new ArrayList<CharacterTrapCard>();
        while(cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex("id"));
            title = cursor.getString(cursor.getColumnIndex("title"));
            type = cursor.getString(cursor.getColumnIndex("type"));
            charactertrapcard = new CharacterTrapCard(id,title,type);
            charactertrapcards.add(charactertrapcard);
        }
        cursor.close();
        return charactertrapcards;
    }

}


