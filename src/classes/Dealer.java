package classes;

import java.util.Random;

public class Dealer {
    Card[] cards;
    int next;
    public Dealer(){
        cards = Card.GetAllCards();
        next = 0;
    }
    //指定された枚数カードを渡す
    public Card[] getCards(int num){
        Card[] cards = new Card[num];
        for(int i = 0;i < num;i++){
            cards[i] = this.cards[next++];
        }
        return cards;
    }

    public void putCards(){
        for(int i = 0;i < cards.length;i++){
            cards[i].putCard();
        }
    }
    public void shuffle(){
        Random rand = new Random();

        for(int a = 0;a < cards.length;a++){
            int b = rand.nextInt(cards.length);
            Card tmp = cards[a];
            cards[a] = cards[b];
            cards[b] = tmp;
        }
    }
    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
