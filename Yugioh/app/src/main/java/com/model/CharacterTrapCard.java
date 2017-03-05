package com.model;

/**
 * Created by hpl on 2015/12/27.
 */
public class CharacterTrapCard {
    private int id;
    private String title;
    private String type;

    public CharacterTrapCard(int id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;

    }


    public int getId() {   return id;  }
    public void setId(int id) {   this.id = id;  }
    public String getTitle() {   return title;  }
    public void setTitle(String monster) {   this.title = title;  }
    public String getType() {   return type;  }
    public void setType(String magic) {   this.type = type;  }
}
