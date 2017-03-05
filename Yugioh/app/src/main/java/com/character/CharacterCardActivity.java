package com.character;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import com.model.CharacterMagicCard;
import com.model.CharacterMonsterCard;
import com.model.CharacterTrapCard;
import com.service.CharacterMagicCardService;
import com.service.CharacterMonsterCardService;
import com.service.CharacterTrapCardService;
import com.yugioh.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hpl on 2015/12/28.
 */
public class CharacterCardActivity extends TabActivity {

    private TabHost tabHost;
    private CharacterMonsterCardService service;
    private CharacterMagicCardService service2;
    private CharacterTrapCardService service3;

    public List<ImageView> imageList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charactercard);

        tabHost = getTabHost();

        addTab();// 添加标签
        // 设置TabHost背景颜色
        tabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
        // 设置TabHost背景图片资源
        tabHost.setBackgroundResource(R.drawable.transparbutton);
        // 设置当前显示哪一个标签 我的理解就是当你第一次启动程序默认显示那个标签 这里是指定的选项卡的ID从0开始
        tabHost.setCurrentTab(0);
        // 标签切换事件处理，setOnTabChangedListener 注意是标签切换事件不是点击事件，而是从一个标签切换到另外一个标签会触发的事件
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            // TODO Auto-generated method stub
            @Override
            public void onTabChanged(String tabId)
            {
                // 设置所有选项卡的图片为未选中图片
                imageList.get(0).setImageDrawable(getResources().getDrawable(R.drawable.monster01));
                imageList.get(1).setImageDrawable(getResources().getDrawable(R.drawable.magic01));
                imageList.get(2).setImageDrawable(getResources().getDrawable(R.drawable.trap01));

                if (tabId.equalsIgnoreCase("tab1")) {
                    imageList.get(0).setImageDrawable(getResources().getDrawable(R.drawable.monster));


                } else if (tabId.equalsIgnoreCase("tab2")) {
                    imageList.get(1).setImageDrawable(getResources().getDrawable(R.drawable.magic));


                } else if (tabId.equalsIgnoreCase("tab3")) {
                    imageList.get(2).setImageDrawable(getResources().getDrawable(R.drawable.trap));

                }

            }
        });
    }



    // 为TabHost添加标签 新建一个newTabSped(new TabSpec) 设置其标签和图标（setIndicator）、设置内容(setContent)
    // TabSpec是TabHost的内部类 TabHost对象的 newTabSpec()方法返回一个TabSpec对象

    private void addTab() {
        tabHost.addTab(tabHost
                .newTabSpec("tab1")
                .setIndicator(composeLayout("怪兽卡", R.drawable.monster))   // setIndicator()此方法用来设置标签和图表
                .setContent(R.id.monstercard));

        service = new CharacterMonsterCardService(this);

        ListView listView = (ListView) this.findViewById(R.id.listView);

        List<CharacterMonsterCard> charactermonstercards = service.getScrollData(0, 100);

        List<HashMap<String, Object>> data = new ArrayList<>();

        for(CharacterMonsterCard charactermonstercard : charactermonstercards){
            HashMap<String, Object> item = new HashMap<>();
            item.put("id", charactermonstercard.getId());
            item.put("attack",charactermonstercard.getAttack());
            item.put("defence",charactermonstercard.getDefence());
            item.put("title", charactermonstercard.getTitle());
            item.put("type", charactermonstercard.getType());
            item.put("level_rank", charactermonstercard.getLevel_rank());
            data.add(item);
        }


        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.charactermonstercard_item,
                new String[]{"title","type","attack", "defence","level_rank"}, new int[]{R.id.monstertitle, R.id.monstertype, R.id.attack,R.id.defence,R.id.level_rank});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.ourocg.cn/Cards/Lists-1-1"));
                startActivity(intent);
            }
        });



        // 指定内容为一个TextView --->public TabHost.TabSpec setContent(int viewId) 此方法需要一个 viewId 作为参数
        tabHost.addTab(tabHost
                .newTabSpec("tab2")
                .setIndicator(composeLayout("魔法卡", R.drawable.magic01))
                .setContent(R.id.magiccard));


        service2 = new CharacterMagicCardService(this);

        ListView listView2 = (ListView) this.findViewById(R.id.listView2);

        List<CharacterMagicCard> charactermagiccards = service2.getScrollData(0, 100);

        List<HashMap<String, Object>> data2 = new ArrayList<>();

        for(CharacterMagicCard charactermagiccard : charactermagiccards){
            HashMap<String, Object> item2 = new HashMap<>();
            item2.put("id", charactermagiccard.getId());
            item2.put("title", charactermagiccard.getTitle());
            item2.put("type", charactermagiccard.getType());
            data2.add(item2);
        }

        SimpleAdapter adapter2 = new SimpleAdapter(this, data2, R.layout.charactermagiccard_item,
                new String[]{"title","type"}, new int[]{R.id.magictitle, R.id.magictype});

        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.ourocg.cn/Cards/Lists-2-1"));
                startActivity(intent);
            }
        });


        tabHost.addTab(tabHost
                .newTabSpec("tab3")
                .setIndicator(composeLayout("陷阱卡", R.drawable.trap01))
                .setContent(R.id.trapcard));

        service3 = new CharacterTrapCardService(this);

        ListView listView3 = (ListView) this.findViewById(R.id.listView3);

        List<CharacterTrapCard> charactertrapcards = service3.getScrollData(0,100);

        List<HashMap<String, Object>> data3 = new ArrayList<>();

        for(CharacterTrapCard charactertrapcard : charactertrapcards){
            HashMap<String, Object> item3 = new HashMap<>();
            item3.put("id", charactertrapcard.getId());
            item3.put("title", charactertrapcard.getTitle());
            item3.put("type", charactertrapcard.getType());
            data3.add(item3);
        }

        SimpleAdapter adapter3 = new SimpleAdapter(this, data3, R.layout.charactertrapcard_item,
                new String[]{"title","type"}, new int[]{R.id.traptitle, R.id.traptype});

        listView3.setAdapter(adapter3);

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.ourocg.cn/Cards/Lists-2-1"));
                startActivity(intent);
            }
        });
    }



    public View composeLayout(String s, int i) {
        // 定义一个LinearLayout布局
        LinearLayout layout = new LinearLayout(this);
        // 设置布局垂直显示
        layout.setOrientation(LinearLayout.VERTICAL);
        ImageView iv = new ImageView(this);
        imageList.add(iv);
        iv.setImageResource(i);
        //设置图片布局
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 50);
        lp.setMargins(0, 0, 0, 0);
        layout.addView(iv, lp);
        // 定义TextView
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setSingleLine(true);
        tv.setText(s);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(15);
        //设置Text布局
        layout.addView(tv, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return layout;
    }

}

