package org.allecuona.deckofcards.services;

import org.allecuona.deckofcards.Card;
import org.allecuona.deckofcards.DeckOfCards;
import org.allecuona.deckofcards.DeckOfCardsListImpl;
import org.allecuona.deckofcards.DeckOfCardsStackImpl;
import org.allecuona.deckofcards.domain.TypeOfDeck;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by angel on 03/03/16.
 */
@Service
public class DeckServiceImpl implements DeckService{

    private long id = 1;

    private static Map<String, DeckOfCards> deckOfCardsMap = new HashMap<String,DeckOfCards>();

    /**
     * Create a deck and return his id.
     *
     * @param typeOfDeck For Specify the type of deck that you want.
     * @return The Id of the deck.
     */
    public long createDeck(TypeOfDeck typeOfDeck) {
        if(typeOfDeck.equals(TypeOfDeck.UsingList))
            deckOfCardsMap.put(String.valueOf(id),new DeckOfCardsListImpl());
        else{
            deckOfCardsMap.put(String.valueOf(id),new DeckOfCardsStackImpl());
        }
        return id++;
    }

    /**
     * Return a list of Deck of Cards.
     *
     * @return a list of Deck of Cards.
     */
    public List<DeckOfCards> getDecks() {
        return new ArrayList<DeckOfCards>(deckOfCardsMap.values());
    }

    /**
     * Return Deck of Cards with specific Id.
     *
     * @param deckId Id of Deck of Cards.
     * @return Deck of Cards with specific Id.
     */
    public DeckOfCards getDeckById(Long deckId) {
        return deckOfCardsMap.get(String.valueOf(deckId));
    }

    /**
     * Delete Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was remove else false.
     */
    public boolean deleteDeckById(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.remove(String.valueOf(deckId));
        return deckOfCards != null;
    }

    /**
     * Shuffle the Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was shuffle else false.
     */
    public boolean shuffle(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            deckOfCards.shuffle();
            return true;
        }
        return false;
    }

    /**
     * Reset the Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and was reset else false.
     */
    public boolean reset(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            deckOfCards.resetDeck();
            return true;
        }
        return false;
    }

    /**
     * Return the size of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the size of Deck of Cards
     */
    public long getDeckSize(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getTotalCards();
        }
        return 0;
    }

    /**
     * Return the fist card of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the first Card.
     */
    public Card getFirstCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getFirstCard();
        }
        return null;
    }

    /**
     * Return the last card of Deck of Cards with specific Id.
     *
     * @param deckId Id of Dek of Cards.
     * @return the last Card.
     */
    public Card getLastCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getLastCard();
        }
        return null;
    }

    /**
     * Return true if Deck of Card exist and has card else false.
     *
     * @param deckId Id of Dek of Cards.
     * @return true if Deck of Card exist and has card else false.
     */
    public boolean hasCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        return deckOfCards.hasCard();
    }
}
