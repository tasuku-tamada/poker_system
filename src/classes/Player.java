package classes;

public class Player {
    int coin;
    int bet;
    String status;
    Hand_poker hand_p;
    Hand_double_up hand_d;

    public Player(int coin){
        this.coin = coin;
    }
    public int getCoin() {
        return coin;
    }

    public boolean validate(){
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
    public Hand_poker getHand_p() {
        return hand_p;
    }
    public void setHand_p(Hand_poker hand_p) {
        this.hand_p = hand_p;
    }
    public Hand_double_up getHand_d() {
        return hand_d;
    }
    public void setHand_d(Hand_double_up hand_d) {
        this.hand_d = hand_d;
    }


}
