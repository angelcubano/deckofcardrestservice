package org.allecuona.deckofcards.domain;

import org.allecuona.deckofcards.AbstractCard;

import java.util.List;

/**
 * Created by angel on 04/03/16.
 */
public class DeckOfCardsDto {

    private List<AbstractCard> cards;

    public List<AbstractCard> getCards() {
        return cards;
    }

    public void setCards(List<AbstractCard> cards) {
        this.cards = cards;
    }
}
