package org.allecuona.deckofcards.services;

import org.allecuona.deckofcards.Card;
import org.allecuona.deckofcards.DeckOfCards;
import org.allecuona.deckofcards.domain.TypeOfDeck;

import java.util.List;

/**
 * Interface that define the functionalities for the Rest Service.
 *
 * Created by angel on 03/03/16.
 */
public interface DeckService {

    /**
     * Create a deck and return his id.
     *
     * @param typeOfDeck For Specify the type of deck that you want.
     * @return The Id of the deck.
     */
    long createDeck(TypeOfDeck typeOfDeck);

    /**
     * Return a list of Deck of Cards.
     *
     * @return a list of Deck of Cards.
     */
    List<DeckOfCards> getDecks();

    /**
     * Return Deck of Cards with specific Id.
     *
     * @param deckId Id of Deck of Cards.
     * @return Deck of Cards with specific Id.
     */
    DeckOfCards getDeckById(Long deckId);

    /**
     * Delete Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was remove else false.
     */
    boolean deleteDeckById(Long deckId);

    /**
     * Shuffle the Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was shuffle else false.
     */
    boolean shuffle(Long deckId);

    /**
     * Reset the Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was reset else false.
     */
    boolean reset(Long deckId);

    /**
     * Return the size of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the size of Deck of Cards
     */
    long getDeckSize(Long deckId);

    /**
     * Return the fist card of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the first Card.
     */
    Card getFirstCard(Long deckId);

    /**
     * Return the last card of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the last Card.
     */
    Card getLastCard(Long deckId);

    /**
     * Return true if Deck of Card exist and has card else false.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and has card else false.
     */
    boolean hasCard(Long deckId);
}
