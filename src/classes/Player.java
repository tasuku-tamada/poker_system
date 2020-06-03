package classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import models.Role_m;

public class Player {
    private int coin;
    private int bet;
    private String status;
    private Card[] hand;
    private Role_m role;

    public Player(int coin) {
        this.coin = coin;
    }

    public void changeHand(int[] selects, Card[] cards) {
        for (int i = 0; i < selects.length; i++) {
            hand[selects[i]] = cards[i];
        }
    }

    //現在の手札の役をroleに格納
    public void checkRole() {
        //ストレートチェック
        boolean flag_straight = isStraight();
        //フラッシュチェック
        boolean flag_flush = isFlush();

        //数字ごとの出現回数取得
        Map<Integer, Integer> map = getCountOfNumber();

    }
    //数字ごとの出現回数のMapを返す
    public Map<Integer, Integer> getCountOfNumber() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int num = hand[i].getNum();
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }



    public boolean isFlush(){
        char c = hand[0].getMark();
        if(c == 'J') c = hand[1].getMark();

        for(int i = 1;i < 5;i++){
            if(hand[i].getMark() != c && hand[i].getMark() != 'J')
                return false;
        }
        return true;
    }

    public boolean isStraight(){

        //カードのnumをint配列に変換
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = hand[i].getNum();
        }

        //小さい順に並べる
        Arrays.sort(numbers);

        //数字が続いているか
        for (int i = 0; i < 5; i++) {
            if (numbers[i] != numbers[0] + i && numbers[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public int getCoin() {
        return coin;
    }

    public boolean validate() {
        return true;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public Role_m getRole() {
        return role;
    }

    public void setRole(Role_m role) {
        this.role = role;
    }

}
