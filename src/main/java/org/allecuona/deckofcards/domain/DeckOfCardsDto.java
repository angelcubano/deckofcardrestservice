package org.allecuona.deckofcards.domain;

import org.allecuona.deckofcards.AbstractCard;
import org.allecuona.deckofcards.DeckOfCards;
import org.allecuona.deckofcards.DeckOfCardsListImpl;
import org.allecuona.deckofcards.DeckOfCardsStackImpl;

import java.util.List;

/**
 * Dto for DeckOfCards
 *
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

    public DeckOfCardsDto convertToDeckOfCardsDto(DeckOfCards deckOfCards) {
        DeckOfCardsDto deckOfCardsDto = new DeckOfCardsDto();
        if(deckOfCards instanceof DeckOfCardsListImpl)
            deckOfCardsDto.setCards(((DeckOfCardsListImpl) deckOfCards).getCards());
        else
            deckOfCardsDto.setCards(((DeckOfCardsStackImpl)deckOfCards).getCardsList());
        return deckOfCardsDto;
    }
}
