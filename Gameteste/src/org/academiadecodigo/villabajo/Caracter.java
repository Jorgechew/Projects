package org.academiadecodigo.villabajo;

public class Caracter {
    public String name;
    public String Type;
    public int attack;
    public int hp;

    public Caracter(String name, String Type, int hp, int attack){
        this.name = name;
        this.Type = Type;
        this.hp = hp;
        this.attack =attack;
    }
}
