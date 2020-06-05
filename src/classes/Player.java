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
    public int[] getChangeHandArray(boolean[] selects_b){
        //いくつtrueがあるか
        int true_cnt = 0;
        for(int i = 0;i < selects_b.length;i++){
            if(selects_b[i])true_cnt++;
        }

        //返り値となる配列
        int[] changes = new int[true_cnt];

        //trueのインデックスを格納
        int next = 0;
        for(int i = 0;i < selects_b.length;i++){
            if(selects_b[i]){
                changes[next] = i;
                next++;
            }
        }

        return changes;
    }

    //現在の手札の役をroleに格納
    public void updateRole() {

        //数字ごとの出現回数取得
        Map<Integer, Integer> map = getCountOfNumber();

        int role_id = 0;
        //ジョーカーなしの役

        if(isTwoPair(map)) role_id = 1;
        else if(isThreeCard(map)) role_id = 2;
        else if(isFullHouse(map)) role_id = 5;
        else if(isFourCard(map)) role_id = 6;

        //ジョーカーありの場合
        if (map.containsKey(0)) {
            switch(role_id){
            case 1:
                role_id = 5;
                break;
            case 2:
                role_id = 6;
                break;
            case 6:
                role_id = 8;
                break;
            }
        }
        boolean flag_straight = isStraight();
        boolean flag_flush = isFlush();

        if(flag_straight && flag_flush){
            if(map.containsKey(14)){
                if(isAllSpade()){
                    role_id = 10;
                } else {
                    role_id = 9;
                }
            }else{
                role_id = 7;
            }
        }else if(flag_straight){
            role_id = 3;
        }else if(flag_flush && role_id < 4){
            role_id = 4;
        }
        if(1 <= role_id)
            role = Role_m.getRole(role_id);
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
    private boolean isAllSpade(){
        for(int i = 0;i < 5;i++){
            if(hand[i].getMark() != 'S' && hand[i].getMark() != 'J'){
                return false;
            }
        }
        return true;
    }
    private boolean isTwoPair(Map<Integer, Integer> map) {
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                count++;
            }
        }
        if (count == 2)
            return true;
        else
            return false;
    }
    private boolean isThreeCard(Map<Integer, Integer> map) {
        if (map.containsValue(3))
            return true;
        else
            return false;
    }
    private boolean isFullHouse(Map<Integer, Integer> map){
        if(map.containsValue(2) && map.containsValue(3)){
            return true;
        }else{
            return false;
        }
    }
    private boolean isFourCard(Map<Integer, Integer> map) {
        if (map.containsValue(4))
            return true;
        else
            return false;
    }
    public boolean isFlush() {
        char c = hand[0].getMark();
        if (c == 'J')
            c = hand[1].getMark();

        for (int i = 1; i < 5; i++) {
            if (hand[i].getMark() != c && hand[i].getMark() != 'J')
                return false;
        }
        return true;
    }
    public boolean isStraight() {

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
