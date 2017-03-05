package com.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.db.CharacterOpenHelper;
import com.model.CharacterMagicCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpl on 2015/12/27.
 */
public class CharacterMagicCardService {


    private CharacterOpenHelper dbOperateHelper;


    public CharacterMagicCardService(Context context) {

        this.dbOperateHelper = new CharacterOpenHelper(context, "Card.db", null, 1);
    }


    public List<CharacterMagicCard> getScrollData(int offset,int maxResult){

        SQLiteDatabase sqldb = dbOperateHelper.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery("select * from MagicCard order by id asc limit ?,?", new String[]{String.valueOf(offset), String.valueOf(maxResult)});
        int id;
        String title;
        String type;
        CharacterMagicCard charactermagiccard = null;
        List<CharacterMagicCard> charactermagiccards = new ArrayList<CharacterMagicCard>();
        while(cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex("id"));
            title = cursor.getString(cursor.getColumnIndex("title"));
            type = cursor.getString(cursor.getColumnIndex("type"));
            charactermagiccard = new CharacterMagicCard(id,title,type);
            charactermagiccards.add(charactermagiccard);
        }
        cursor.close();
        return charactermagiccards;
    }

}


