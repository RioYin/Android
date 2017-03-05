package com.model;

/**
 * Created by hpl on 2015/12/27.
 */
public class CharacterMonsterCard {
    private int id;
    private int attack;
    private int defence;
    private String title;
    private String type;
    private String level_rank;

    public CharacterMonsterCard(int id, int attack, int defence, String title,String type,String lever_rank) {
        this.id = id;
        this.attack = attack;
        this.defence = defence;
        this.title = title;
        this.type = type;
        this.level_rank = lever_rank;
    }


    public int getId() {   return id;  }
    public void setId(int id) {   this.id = id;  }
    public int getAttack() {   return attack;   }
    public void setAttack(int attack) {   this.attack = attack;   }
    public int getDefence()   {   return defence;   }
    public void setDefence(int defence) {   this.defence = defence;   }
    public String getTitle() {   return title;  }
    public void setTitle(String monster) {   this.title = title;  }
    public String getType() {   return type;  }
    public void setType(String magic) {   this.type = type;  }
    public String getLevel_rank() {   return level_rank;  }
    public void setLever_rank(String trap) {   this.level_rank = level_rank;  }
}
