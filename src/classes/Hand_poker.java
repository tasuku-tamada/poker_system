package classes;

import models.Role_m;

public class Hand_poker {
    Card[] cards;
    Role_m role;
    public Card[] getCards() {
        return cards;
    }
    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    public Role_m getRole() {
        return role;
    }
    public void setRole(Role_m role) {
        this.role = role;
    }

}
