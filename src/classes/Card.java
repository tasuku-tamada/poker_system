package classes;

public class Card {
    //Aは14
    private int num;
    private char mark;
    private String path;

    public Card(int num, char mark) {
        this.path = "./images/" + mark + num + ".png";
        if(num == 1){
            num = 14;
        }
        this.num = num;
        this.mark = mark;
    }
    public static Card[] GetAllCards() {
        //スペード,ダイヤ, クローバー, ハート
        char[] marks = { 'S', 'D', 'C', 'H' };
        Card[] cards = new Card[53];
        for (int i = 0; i < 52; i++) {
            cards[i] = new Card((i % 13) + 1, marks[i / 13]);
        }
        cards[52] = new Card(0,'J');
        return cards;
    }

    public void putCard(){
        System.out.printf("%c %2d %s\n", mark, num, path);
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
