package org.allecuona.deckofcards.services;

import org.allecuona.deckofcards.Card;
import org.allecuona.deckofcards.DeckOfCards;
import org.allecuona.deckofcards.domain.TypeOfDeck;

import java.util.List;

/**
 * Created by angel on 03/03/16.
 */
public interface DeckService {

    long createDeck(TypeOfDeck typeOfDeck);

    List<DeckOfCards> getDecks();

    DeckOfCards getDeckById(Long deckId);

    boolean deleteDeckById(Long deckId);

    boolean shuffle(Long deckId);

    boolean reset(Long deckId);

    long getDeckSize(Long deckId);

    Card getFirstCard(Long deckId);

    Card getLastCard(Long deckId);

    boolean hasCard(Long deckId);
}
