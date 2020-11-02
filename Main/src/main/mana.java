/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Daniel Montoya
 */
public class mana{

    public int Mana1;

    public int getMana1() {
        return Mana1;
    }

    public void setMana1(int Mana1) {
        this.Mana1 = Mana1;
        if (this.Mana1 >= 1000){
            this.Mana1 = 1000;
        }else{
            this.Mana1 = Mana1;
        }
    }

}
