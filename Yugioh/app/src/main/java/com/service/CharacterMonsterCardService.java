package com.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.db.CharacterOpenHelper;
import com.model.CharacterMonsterCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpl on 2015/12/27.
 */
public class CharacterMonsterCardService {


    private CharacterOpenHelper dbOperateHelper;


    public CharacterMonsterCardService(Context context) {

        this.dbOperateHelper = new CharacterOpenHelper(context, "Card.db", null, 1);
    }


    public List<CharacterMonsterCard> getScrollData(int offset,int maxResult){

        SQLiteDatabase sqldb = dbOperateHelper.getReadableDatabase();
        Cursor cursor = sqldb.rawQuery("select * from MonsterCard order by id asc limit ?,?", new String[]{String.valueOf(offset), String.valueOf(maxResult)});
        int id;
        int attack;
        int defence;
        String title;
        String type;
        String level_rank;
        CharacterMonsterCard charactermonstercard = null;
        List<CharacterMonsterCard> charactermonstercards = new ArrayList<CharacterMonsterCard>();
        while(cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex("id"));
            attack = cursor.getInt(cursor.getColumnIndex("attack"));
            defence = cursor.getInt(cursor.getColumnIndex("defence"));
            title = cursor.getString(cursor.getColumnIndex("title"));
            type = cursor.getString(cursor.getColumnIndex("type"));
            level_rank = cursor.getString(cursor.getColumnIndex("level_rank"));
            charactermonstercard = new CharacterMonsterCard(id,attack,defence,title,type,level_rank);
            charactermonstercards.add(charactermonstercard);
        }
        cursor.close();
        return charactermonstercards;
    }



}


