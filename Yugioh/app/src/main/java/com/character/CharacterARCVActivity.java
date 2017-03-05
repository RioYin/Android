package com.character;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adapter.CharacterAdapter;
import com.db.CharacterOpenHelper;
import com.model.DM;
import com.yugioh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hpl on 2015/12/10.
 */
public class CharacterARCVActivity extends Activity {

    private List<DM> dmList = new ArrayList<DM>();
    private CharacterOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arcv_character_layout);
        dbHelper = new CharacterOpenHelper(this, "Card.db", null, 1);

        initDM();
        CharacterAdapter adapter = new CharacterAdapter(CharacterARCVActivity.this, R.layout.dm_item, dmList);

        ListView listView = (ListView) findViewById(R.id.list_view_arcv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                showInfo(position);
                Intent intent = new Intent(CharacterARCVActivity.this, CharacterCardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initDM() {
        DM dm1 = new DM("榊游矢（Sakaki Yuya）", R.drawable.sakakiyuya);
        dmList.add(dm1);
        DM dm2 = new DM("柊柚子（Hiragi Yuzu）", R.drawable.hiragiyuzu);
        dmList.add(dm2);
        DM dm3 = new DM("赤马零儿（Akaba Reiji）", R.drawable.akabareiji);
        dmList.add(dm3);
        DM dm4 = new DM("权现坂升（Gongenzaka Noboru）", R.drawable.gongenzakanoboru);
        dmList.add(dm4);
        DM dm5 = new DM("泽渡慎吾（Sawatari Shingo）", R.drawable.sawatarishingo);
        dmList.add(dm5);
        DM dm6 = new DM("赤马零罗（Akaba Reira）", R.drawable.akabareira);
        dmList.add(dm6);
        DM dm7 = new DM("月影（Tsukikage）", R.drawable.tsukikage);
        dmList.add(dm7);
        DM dm8 = new DM("志岛北斗（Shijima Hokuto）", R.drawable.shijimahokuto);
        dmList.add(dm8);
        DM dm9 = new DM("刀堂刃（Todo Yaiba）", R.drawable.todoyaiba);
        dmList.add(dm9);
        DM dm10 = new DM("光津真澄（Kotsu Masumi）", R.drawable.kotsumasumi);
        dmList.add(dm10);
        DM dm11 = new DM("游里（Yuri）", R.drawable.yuri);
        dmList.add(dm11);
        DM dm12 = new DM("塞瑞娜（Serena）", R.drawable.serena);
        dmList.add(dm12);
        DM dm13 = new DM("紫云院素良（Shiunin Sora）", R.drawable.shiuninsora);
        dmList.add(dm13);
        DM dm14 = new DM("丹尼斯·麦克菲德（Denisu Makkufirudo）", R.drawable.denisumakkufirudo);
        dmList.add(dm14);
        DM dm15 = new DM("赤马零王（Akaba Reo）", R.drawable.akabareo);
        dmList.add(dm15);
        DM dm16 = new DM("游斗（Yuto）", R.drawable.yuto);
        dmList.add(dm16);
        DM dm17 = new DM("黑咲瑠璃（Kurosaki Ruri）", R.drawable.kurosakiruri);
        dmList.add(dm17);
        DM dm18 = new DM("黑咲隼（Kurosaki Shun）", R.drawable.kurosakishun);
        dmList.add(dm18);
        DM dm19 = new DM("游吾（Yugo）", R.drawable.yugo);
        dmList.add(dm19);
        DM dm20 = new DM("凛（Rin）", R.drawable.rin);
        dmList.add(dm20);
        DM dm21 = new DM("克罗·霍根（Crow Hogan）", R.drawable.arckurohogan);
        dmList.add(dm21);
        DM dm22 = new DM("真嗣·韦伯（Shinji Weba）", R.drawable.shinjiweba);
        dmList.add(dm22);
        DM dm23 = new DM("杰克·阿特拉斯（Jakku Atorasu）", R.drawable.jakkuatorasu);
        dmList.add(dm23);
        DM dm24 = new DM("让·米歇尔·罗杰（Jan Misheru Roje）", R.drawable.janmisheruroje);
        dmList.add(dm24);
        DM dm25 = new DM("德松长次郎（Tokumatsu Chojiro）", R.drawable.tokumatsuchojiro);
        dmList.add(dm25);
    }

    public void showInfo(int position) {
        DM dm = dmList.get(position);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (position) {
            case 0:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "白骨", "通常怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "蘑菇人", "通常怪兽", "800","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑之龙王", "通常怪兽", "1500","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔龙", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "守城翼龙", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔召唤", "通常怪兽", "2500","1200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "精灵剑士", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑暗骑士盖亚", "通常怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诅咒之龙", "通常怪兽", "2000","1500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩石巨兵", "通常怪兽", "1300","2000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "大白鲨", "通常怪兽", "1600","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小精怪", "通常怪兽", "1300","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小鬼", "通常怪兽", "1300","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "猛犸的墓场", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "狮鹫兽卫", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "犀牛", "通常怪兽", "1200","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "银牙狼", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "路易斯", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻兽王加泽尔", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士α", "通常怪兽", "1400","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士β", "通常怪兽", "1700","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士γ", "通常怪兽", "1500","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "王后骑士", "通常怪兽", "1500","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "卫兵骑士", "通常怪兽", "1900","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧西里斯的天空龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧贝里斯克的巨神兵", "效果怪兽", "4000","4000","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "太阳神的翼神龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "栗子球", "效果怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "弹射龟", "效果怪兽", "1000","2000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巴风特", "效果怪兽", "1400","1800","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巨盾守卫者", "效果怪兽", "100","2600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印的艾克佐迪亚", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破龙剑士", "效果怪兽", "2600","2300","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔族基路法恶魔", "效果怪兽", "2200","2500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士磁体战神", "效果怪兽", "3500","3850","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "国王骑士", "效果怪兽", "1600","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "三眼怪", "效果怪兽", "1000","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诡术师", "效果怪兽", "2000","1200","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "固执的老魔术师", "效果怪兽", "450","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "翻弄敌人的精灵剑士", "效果怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "疾风的暗黑骑士盖亚", "效果怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花球", "效果怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "神圣魔术师", "效果怪兽", "300","400","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "盗贼栗子", "效果怪兽", "1000","700","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超电磁龟", "效果怪兽", "0","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑衣大贤者", "效果怪兽", "2800","3200","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻影之骑士", "效果怪兽", "2800","2000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩之精灵泰坦", "效果怪兽", "1700","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "死亡魔导龙", "效果怪兽", "2200","1700","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导战士破坏者", "效果怪兽", "1600","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "熟练的黑魔术师", "效果怪兽", "1900","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 蒂迈欧", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 克里底亚", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 赫谟", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导女武神", "效果怪兽", "1600","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔法神官", "效果怪兽", "3200","2800","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗红之魔导师", "效果怪兽", "1700","2200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥府之使者格斯", "效果怪兽", "2700","2500","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥王龙断罪神", "效果怪兽", "2800","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士-开辟的使者", "效果怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌之黑魔术师", "效果怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑混沌之魔术师", "仪式怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士", "仪式怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "不死战士", "融合怪兽", "1200","900","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士盖亚", "融合怪兽", "2600","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔龙", "融合怪兽", "3200","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "有翼幻兽奇美拉", "融合怪兽", "2100","1800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超魔导剑士-黑暗帕拉丁", "融合怪兽", "2900","2400","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "究极龙骑士", "融合怪兽", "5000","5000","等级12"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑炎之骑士", "融合怪兽", "2200","800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士黑魔导女孩", "融合怪兽", "2600","1700","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "咒符龙", "融合怪兽", "2900","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "天位骑士", "融合怪兽", "3800","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "合神龙 蒂迈欧", "融合怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破坏龙甘多拉", "效果怪兽", "0","0","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花糖", "效果怪兽", "300","500","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV3", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV5", "效果怪兽", "2300","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV7", "效果怪兽", "2800","1000","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV4", "效果怪兽", "1000","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV8", "效果怪兽", "3500","1000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "积木人", "效果怪兽", "1000","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "绿齿轮", "效果怪兽", "1400","600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "红齿轮", "效果怪兽", "1300","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黄齿轮", "效果怪兽", "1300","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "玩具魔法师", "效果怪兽", "1600","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "柠檬魔术少女", "效果怪兽", "800","600","等级2"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔雾雨", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死之魔术箱", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "洗脑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札抹杀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札交换", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法除去", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "陷阱解除", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "二重魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "扩散波动", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天降的宝札", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "强欲之壶", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天使的施舍", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "恶魔的圣域", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "灵魂捕获者", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "交叉魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑·魔·导", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "千把刀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑魔术的幕帘", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "虫洞", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "蒂迈欧之眼", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "赫谟之爪", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "传说之心", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "贤者的宝石", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "所有者之刻印", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同盟攻击", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者转生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "古之规则", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "燃烧的大地", "永续魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔性之月", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "秘术之书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔术咒文书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "过早的埋葬", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔导师之力", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "闪电之剑", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "一角兽之角", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "增殖", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "怪兽回收", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法效果之矢", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合解除", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "次元魔法", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "诡术师的魔术4", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "非常食", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "狂战士之魂", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光与暗的洗礼", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌-黑魔术的仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "封印之黄金柜", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同胞的牵绊", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "棉花糖的眼镜", "永续魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法筒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣防护罩-反射镜力-", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "连锁破坏", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "精灵之镜", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "换位", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "沙尘之大龙卷", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔术礼帽", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔族复活之棺", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔导幻影", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之接力", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "六芒星之咒缚", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "真实之眼", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣光辉", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "一族之规", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"升天的角笛", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"盗贼的七道具", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"攻击的无力化", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"魔法阵", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"机动堡垒·坚固守垒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"逐渐罅裂之斧", "通常陷阱"});

                break;

            case 1:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "青眼白龙", "通常怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "白骨", "通常怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "蘑菇人", "通常怪兽", "800","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑之龙王", "通常怪兽", "1500","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔龙", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "守城翼龙", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔召唤", "通常怪兽", "2500","1200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "精灵剑士", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑暗骑士盖亚", "通常怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诅咒之龙", "通常怪兽", "2000","1500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩石巨兵", "通常怪兽", "1300","2000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "大白鲨", "通常怪兽", "1600","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小精怪", "通常怪兽", "1300","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小鬼", "通常怪兽", "1300","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "猛犸的墓场", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "狮鹫兽卫", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "犀牛", "通常怪兽", "1200","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "银牙狼", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "路易斯", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻兽王加泽尔", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士α", "通常怪兽", "1400","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士β", "通常怪兽", "1700","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士γ", "通常怪兽", "1500","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "王后骑士", "通常怪兽", "1500","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "卫兵骑士", "通常怪兽", "1900","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧西里斯的天空龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧贝里斯克的巨神兵", "效果怪兽", "4000","4000","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "太阳神的翼神龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "栗子球", "效果怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "弹射龟", "效果怪兽", "1000","2000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巴风特", "效果怪兽", "1400","1800","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巨盾守卫者", "效果怪兽", "100","2600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印的艾克佐迪亚", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破龙剑士", "效果怪兽", "2600","2300","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔族基路法恶魔", "效果怪兽", "2200","2500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士磁体战神", "效果怪兽", "3500","3850","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "国王骑士", "效果怪兽", "1600","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "三眼怪", "效果怪兽", "1000","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诡术师", "效果怪兽", "2000","1200","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "固执的老魔术师", "效果怪兽", "450","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "翻弄敌人的精灵剑士", "效果怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "疾风的暗黑骑士盖亚", "效果怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花球", "效果怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "神圣魔术师", "效果怪兽", "300","400","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "盗贼栗子", "效果怪兽", "1000","700","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超电磁龟", "效果怪兽", "0","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑衣大贤者", "效果怪兽", "2800","3200","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻影之骑士", "效果怪兽", "2800","2000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩之精灵泰坦", "效果怪兽", "1700","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "死亡魔导龙", "效果怪兽", "2200","1700","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导战士破坏者", "效果怪兽", "1600","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "熟练的黑魔术师", "效果怪兽", "1900","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 蒂迈欧", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 克里底亚", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 赫谟", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导女武神", "效果怪兽", "1600","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔法神官", "效果怪兽", "3200","2800","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗红之魔导师", "效果怪兽", "1700","2200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥府之使者格斯", "效果怪兽", "2700","2500","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥王龙断罪神", "效果怪兽", "2800","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士-开辟的使者", "效果怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌之黑魔术师", "效果怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑混沌之魔术师", "仪式怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士", "仪式怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "不死战士", "融合怪兽", "1200","900","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士盖亚", "融合怪兽", "2600","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔龙", "融合怪兽", "3200","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "有翼幻兽奇美拉", "融合怪兽", "2100","1800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超魔导剑士-黑暗帕拉丁", "融合怪兽", "2900","2400","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "究极龙骑士", "融合怪兽", "5000","5000","等级12"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑炎之骑士", "融合怪兽", "2200","800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士黑魔导女孩", "融合怪兽", "2600","1700","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "咒符龙", "融合怪兽", "2900","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "天位骑士", "融合怪兽", "3800","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "合神龙 蒂迈欧", "融合怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破坏龙甘多拉", "效果怪兽", "0","0","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花糖", "效果怪兽", "300","500","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV3", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV5", "效果怪兽", "2300","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV7", "效果怪兽", "2800","1000","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV4", "效果怪兽", "1000","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV8", "效果怪兽", "3500","1000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "积木人", "效果怪兽", "1000","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "绿齿轮", "效果怪兽", "1400","600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "红齿轮", "效果怪兽", "1300","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黄齿轮", "效果怪兽", "1300","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "玩具魔法师", "效果怪兽", "1600","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "柠檬魔术少女", "效果怪兽", "800","600","等级2"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔雾雨", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死之魔术箱", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "洗脑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札抹杀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札交换", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法除去", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "陷阱解除", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "二重魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "扩散波动", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天降的宝札", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "强欲之壶", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天使的施舍", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "恶魔的圣域", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "灵魂捕获者", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "交叉魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑·魔·导", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "千把刀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑魔术的幕帘", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "虫洞", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "蒂迈欧之眼", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "赫谟之爪", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "传说之心", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "贤者的宝石", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "所有者之刻印", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同盟攻击", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者转生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "古之规则", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "燃烧的大地", "永续魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔性之月", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "秘术之书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔术咒文书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "过早的埋葬", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔导师之力", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "闪电之剑", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "一角兽之角", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "增殖", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "怪兽回收", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法效果之矢", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合解除", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "次元魔法", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "诡术师的魔术4", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "非常食", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "狂战士之魂", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光与暗的洗礼", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌-黑魔术的仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "封印之黄金柜", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同胞的牵绊", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "棉花糖的眼镜", "永续魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法筒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣防护罩-反射镜力-", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "连锁破坏", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "精灵之镜", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "换位", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "沙尘之大龙卷", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔术礼帽", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔族复活之棺", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔导幻影", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之接力", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "六芒星之咒缚", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "真实之眼", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣光辉", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "一族之规", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "升天的角笛", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "盗贼的七道具", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "攻击的无力化", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法阵", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "机动堡垒·坚固守垒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"逐渐罅裂之斧", "通常陷阱"});

                break;
            case 2:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "白骨", "通常怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "蘑菇人", "通常怪兽", "800","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑之龙王", "通常怪兽", "1500","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔龙", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "守城翼龙", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔召唤", "通常怪兽", "2500","1200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "精灵剑士", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑暗骑士盖亚", "通常怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诅咒之龙", "通常怪兽", "2000","1500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩石巨兵", "通常怪兽", "1300","2000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "大白鲨", "通常怪兽", "1600","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小精怪", "通常怪兽", "1300","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小鬼", "通常怪兽", "1300","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "猛犸的墓场", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "狮鹫兽卫", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "犀牛", "通常怪兽", "1200","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "银牙狼", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "路易斯", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻兽王加泽尔", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士α", "通常怪兽", "1400","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士β", "通常怪兽", "1700","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士γ", "通常怪兽", "1500","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "王后骑士", "通常怪兽", "1500","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "卫兵骑士", "通常怪兽", "1900","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧西里斯的天空龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧贝里斯克的巨神兵", "效果怪兽", "4000","4000","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "太阳神的翼神龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士", "仪式怪兽", "3000","2500","等级8"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔雾雨", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死之魔术箱", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "洗脑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札抹杀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札交换", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法除去", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "陷阱解除", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "二重魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "扩散波动", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天降的宝札", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "强欲之壶", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天使的施舍", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "恶魔的圣域", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "灵魂捕获者", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "交叉魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑·魔·导", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "千把刀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑魔术的幕帘", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "虫洞", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "蒂迈欧之眼", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "赫谟之爪", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "传说之心", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "贤者的宝石", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "所有者之刻印", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同盟攻击", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者转生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "古之规则", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "燃烧的大地", "永续魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "一角兽之角", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "增殖", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌仪式", "仪式魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法筒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣防护罩-反射镜力-", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "连锁破坏", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "精灵之镜", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "换位", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "沙尘之大龙卷", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔术礼帽", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔族复活之棺", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔导幻影", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之接力", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "六芒星之咒缚", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "真实之眼", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣光辉", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "一族之规", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "升天的角笛", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "盗贼的七道具", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "攻击的无力化", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法阵", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "机动堡垒·坚固守垒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "逐渐罅裂之斧", "通常陷阱"});
                break;
            case 3:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 4:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 5:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 6:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 7:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 8:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 9:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 10:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
            case 11:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 12:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 13:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 14:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 15:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 16:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 17:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "急袭猛禽-究极猎鹰", "超量怪兽", "3500","2000","阶级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右腕", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "白骨", "通常怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "蘑菇人", "通常怪兽", "800","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑之龙王", "通常怪兽", "1500","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔龙", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "守城翼龙", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "恶魔召唤", "通常怪兽", "2500","1200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "精灵剑士", "通常怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑暗骑士盖亚", "通常怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诅咒之龙", "通常怪兽", "2000","1500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩石巨兵", "通常怪兽", "1300","2000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "大白鲨", "通常怪兽", "1600","800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小精怪", "通常怪兽", "1300","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "小鬼", "通常怪兽", "1300","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "猛犸的墓场", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "狮鹫兽卫", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "犀牛", "通常怪兽", "1200","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "银牙狼", "通常怪兽", "1200","800","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "路易斯", "通常怪兽", "1200","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻兽王加泽尔", "通常怪兽", "1500","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士α", "通常怪兽", "1400","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士β", "通常怪兽", "1700","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士γ", "通常怪兽", "1500","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "王后骑士", "通常怪兽", "1500","1600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "卫兵骑士", "通常怪兽", "1900","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧西里斯的天空龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "欧贝里斯克的巨神兵", "效果怪兽", "4000","4000","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "太阳神的翼神龙", "效果怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "栗子球", "效果怪兽", "300","200","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "弹射龟", "效果怪兽", "1000","2000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巴风特", "效果怪兽", "1400","1800","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "巨盾守卫者", "效果怪兽", "100","2600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印的艾克佐迪亚", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破龙剑士", "效果怪兽", "2600","2300","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔族基路法恶魔", "效果怪兽", "2200","2500","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "磁石战士磁体战神", "效果怪兽", "3500","3850","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "国王骑士", "效果怪兽", "1600","1400","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "三眼怪", "效果怪兽", "1000","600","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "诡术师", "效果怪兽", "2000","1200","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "固执的老魔术师", "效果怪兽", "450","600","等级2"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "翻弄敌人的精灵剑士", "效果怪兽", "1400","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "疾风的暗黑骑士盖亚", "效果怪兽", "2300","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花球", "效果怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "神圣魔术师", "效果怪兽", "300","400","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "盗贼栗子", "效果怪兽", "1000","700","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超电磁龟", "效果怪兽", "0","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑衣大贤者", "效果怪兽", "2800","3200","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "幻影之骑士", "效果怪兽", "2800","2000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "岩之精灵泰坦", "效果怪兽", "1700","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "死亡魔导龙", "效果怪兽", "2200","1700","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导战士破坏者", "效果怪兽", "1600","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "熟练的黑魔术师", "效果怪兽", "1900","1700","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 蒂迈欧", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 克里底亚", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "传说的骑士 赫谟", "效果怪兽", "2800","1800","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "魔导女武神", "效果怪兽", "1600","1800","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔法神官", "效果怪兽", "3200","2800","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗红之魔导师", "效果怪兽", "1700","2200","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥府之使者格斯", "效果怪兽", "2700","2500","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "冥王龙断罪神", "效果怪兽", "2800","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士-开辟的使者", "效果怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌之黑魔术师", "效果怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑混沌之魔术师", "仪式怪兽", "2800","2600","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "混沌战士", "仪式怪兽", "3000","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "不死战士", "融合怪兽", "1200","900","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士盖亚", "融合怪兽", "2600","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "暗黑魔龙", "融合怪兽", "3200","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "有翼幻兽奇美拉", "融合怪兽", "2100","1800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "超魔导剑士-黑暗帕拉丁", "融合怪兽", "2900","2400","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "究极龙骑士", "融合怪兽", "5000","5000","等级12"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑炎之骑士", "融合怪兽", "2200","800","等级6"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "龙骑士黑魔导女孩", "融合怪兽", "2600","1700","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "咒符龙", "融合怪兽", "2900","2500","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "天位骑士", "融合怪兽", "3800","2500","等级9"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "合神龙 蒂迈欧", "融合怪兽", "？","？","等级10"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "破坏龙甘多拉", "效果怪兽", "0","0","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "棉花糖", "效果怪兽", "300","500","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV3", "效果怪兽", "1000","1000","等级3"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV5", "效果怪兽", "2300","1000","等级5"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默剑士LV7", "效果怪兽", "2800","1000","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV4", "效果怪兽", "1000","1000","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "沉默魔术师LV8", "效果怪兽", "3500","1000","等级8"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "积木人", "效果怪兽", "1000","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "绿齿轮", "效果怪兽", "1400","600","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "红齿轮", "效果怪兽", "1300","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黄齿轮", "效果怪兽", "1300","1200","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "玩具魔法师", "效果怪兽", "1600","1500","等级4"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "柠檬魔术少女", "效果怪兽", "800","600","等级2"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔雾雨", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死之魔术箱", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "洗脑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札抹杀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "手札交换", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法除去", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "陷阱解除", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "二重魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "扩散波动", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天降的宝札", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "强欲之壶", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "天使的施舍", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "恶魔的圣域", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "灵魂捕获者", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "交叉魔法", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑·魔·导", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "千把刀", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "黑魔术的幕帘", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "虫洞", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "蒂迈欧之眼", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "赫谟之爪", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "传说之心", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "贤者的宝石", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "所有者之刻印", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同盟攻击", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者转生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "古之规则", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "燃烧的大地", "永续魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔性之月", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "秘术之书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔术咒文书", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "过早的埋葬", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔导师之力", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "闪电之剑", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "一角兽之角", "装备魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "增殖", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "怪兽回收", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "魔法效果之矢", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合解除", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "次元魔法", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "诡术师的魔术4", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "非常食", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "狂战士之魂", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光与暗的洗礼", "速攻魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "混沌-黑魔术的仪式", "仪式魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "封印之黄金柜", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "同胞的牵绊", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "棉花糖的眼镜", "永续魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔法筒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣防护罩-反射镜力-", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "连锁破坏", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "精灵之镜", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "换位", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "沙尘之大龙卷", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魔术礼帽", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔族复活之棺", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "黑魔导幻影", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之接力", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "六芒星之咒缚", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "真实之眼", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "神圣光辉", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "一族之规", "永续陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"升天的角笛", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"盗贼的七道具", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"攻击的无力化", "反击陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"魔法阵", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"机动堡垒·坚固守垒", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)", new String[]{"逐渐罅裂之斧", "通常陷阱"});

                break;
            case 18:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 19:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 20:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 21:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 22:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 23:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            case 24:
                db.execSQL("delete from MonsterCard");
                db.execSQL("delete from MagicCard");
                db.execSQL("delete from TrapCard");

                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "黑魔术师", "通常怪兽", "2500","2100","等级7"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的左足", "通常怪兽", "200","300","等级1"});
                db.execSQL("insert into MonsterCard (title, type, attack,defence,level_rank) values(?, ?, ?, ?, ?)",    new String[] { "被封印者的右足", "通常怪兽", "200","300","等级1"});

                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "死者苏生", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "光之护封剑", "通常魔法"});
                db.execSQL("insert into MagicCard (title, type) values(?, ?)",    new String[] { "融合", "通常魔法"});

                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "魂之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "命之纲", "通常陷阱"});
                db.execSQL("insert into TrapCard (title, type) values(?, ?)",    new String[] { "光之封札剑", "通常陷阱"});
                break;
            default:
                break;


        }

    }
}
