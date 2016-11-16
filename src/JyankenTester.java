

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author c16318
 */

import java.util.Scanner;

public class JyankenTester {
    public static void main(String[] args){
        
        Scanner stdIn = new Scanner(System.in);
        String[] hands = {"グー","チョキ","パー"};
        
        
        HumanPlayer p1 = new HumanPlayer("yama");
        ComputerPlayer p2 = new ComputerPlayer("cpu1");
        ComputerPlayer p3 = new ComputerPlayer("cpu2");
        
        System.out.println("PlyaerName:" + p1.getName() + ",id:" + p1.getId());
        System.out.println("Computer1Name:" + p2.getName() + ",id:" + p2.getId());
        System.out.println("Couputer2Name:" + p3.getName() + ",id:" + p3.getId());
        
        int c,phund;    /**c:もう一度繰り返すか。  phund:自分のhundの値  */
        do{
            for(int i = 0;i < 3;i++){
                System.out.printf("(%d)%s ",i,hands[i]);
            }
            
            System.out.println();
            
            /**自分のhundの値を入力 */
            do{
                System.out.print("入力してください。:");
                phund = stdIn.nextInt();
                System.out.println();
            }while(phund < 0 || phund > 2);
            
            
            /**自分とコンンピュータのhundの値をセットする。*/
            p1.setHund(phund);
            p2.setHund(p2.Random());
            p3.setHund(p3.Random());
            
            System.out.println("あなたは"+ hands[p1.getHund()] + "で、cpu1は" + hands[p2.getHund()] + "で、cpu2は" + hands[p3.getHund()] + "です。");
            
            /**一回目のswitch文はアイコになるか、もしくは、どの人だけ手が違うかで分岐
               二回目のswitch文では、違う手の人とそれ以外のもう一人とジャンケンをし、結果を表示
             */
            switch(p1.judge2(p1, p2, p3)){
                case 0: System.out.println("引き分けです。"); break;
                    
                /**P1だけ手が違う場合の処理*/
                case 1:            /**p1とそれ以外のもう一人の手で勝敗を判断*/
                        switch(Player.judge(p1.getHund(),p2.getHund())){
                            
                            case 1:System.out.println(p2.getName() + "と" + p3.getName() + "が勝ちです。");
                                   System.out.println("あなたの負けです。");
                                   break;
                                
                            case 2:System.out.println("あなたの勝ちです。");
                                   System.out.println(p2.getName() + "と" + p3.getName() + "が負けです。");
                                   break;
                        }
                break;
                    
                /**P2だけ手が違う場合の処理*/
                case 2:                  /**p2とそれ以外のもう一人の手で勝敗を判断*/
                        switch(Player.judge(p2.getHund(),p3.getHund())){
                            
                            case 1:System.out.println("あなたと" + p3.getName() + "の勝ちです。");
                                   System.out.println(p2.getName() + "の負けです。");
                                   break;
                                
                            case 2:System.out.println(p2.getName() + "の勝ちです。");
                                   System.out.println("あなたと" + p3.getName() + "の負けです。");
                                   break;
                        }
                break;
                    
                /**P3だけ手が違う場合の処理*/
                case 3:                  /**p3とそれ以外のもう一人の手で勝敗を判断*/
                        switch(Player.judge(p3.getHund(),p1.getHund())){
                            
                            case 1:System.out.println("あなたと" + p2.getName() + "の勝ちです。");
                                   System.out.println(p3.getName() + "の負けです。");
                                   break;
                                
                            case 2:System.out.println(p2.getName() + "の勝ちです。");
                                   System.out.println("あなたと" + p2.getName() + "の勝ちです。");
                                   break;
                        }
                break;
                    
                
            }
            
            
            System.out.print("続ける/1  やめる/0  :");
            c = stdIn.nextInt();
            System.out.println();
            
        }while(c != 0);    /**0入力で終了*/
        
    }
}
