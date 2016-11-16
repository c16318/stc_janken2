

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;


public class ComputerPlayer extends Player{
    
    Random rand = new Random();

    public ComputerPlayer(String name){
        super(name);

    }
    /**ランダム(0~2)な数を返す*/
    public int Random(){
            return rand.nextInt(3);
    }
    
    
    
}
