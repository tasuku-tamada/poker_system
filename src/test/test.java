package test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import classes.Dealer;
import classes.Player;

public class test {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ

        Player p = new Player(100);

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("bet:");
            p.setBet(sc.nextInt());
        } while (p.getCoin() < p.getBet());

        Dealer dealer = new Dealer();
        dealer.shuffle();

        System.out.println("\n山札");
        dealer.putCards();

        p.setHand(dealer.getCards(5));

        System.out.println("\n手札");
        for (int i = 0; i < p.getHand().length; i++) {
            p.getHand()[i].putCard();
        }

        /******標準入力するための処理******/
        System.out.print("changes:");
        ArrayList<Integer> selectList = new ArrayList<Integer>();
        while (true) {
            int num = sc.nextInt();

            if (num < 0)
                break;
            selectList.add(num);
        }
        sc.close();
        int[] selects = new int[selectList.size()];
        for (int i = 0; i < selectList.size(); i++) {
            selects[i] = selectList.get(i);
        }
        /***********************************/

        p.changeHand(selects, dealer.getCards(selects.length));

        /***テスト用 ストレート***/
        p.getHand()[0].setNum(1);
        p.getHand()[1].setNum(1);
        p.getHand()[2].setNum(2);
        p.getHand()[3].setNum(1);
        p.getHand()[4].setNum(1);
        /*************************/
        System.out.println("\n交換後");
        for (int i = 0; i < p.getHand().length; i++) {
            p.getHand()[i].putCard();
        }
        System.out.println(p.isStraight());

        //数字のカウント
        Map<Integer, Integer> map = p.getCountOfNumber();
        //全ての要素を出力
        for (int key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }

}
