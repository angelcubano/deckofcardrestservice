package org.allecuona.deckofcards.domain;

import org.allecuona.deckofcards.Card;
import org.allecuona.deckofcards.Ranks;
import org.allecuona.deckofcards.Suits;

/**
 * Created by angel on 04/03/16.
 */
public class CardDto {

    private Suits suits;

    private Ranks ranks;

    public Suits getSuits() {
        return suits;
    }

    public void setSuits(Suits suits) {
        this.suits = suits;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public void convertToCardsDto(Card card) {
        this.suits = card.getSuit();
        this.ranks = card.getRank();
    }
}
