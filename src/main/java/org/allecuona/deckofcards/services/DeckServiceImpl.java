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

//    static{
//        deckOfCardsMap.put(String.valueOf(0),new DeckOfCardsListImpl());
//        deckOfCardsMap.put(String.valueOf(1),new DeckOfCardsListImpl());
//    }



    public long createDeck(TypeOfDeck typeOfDeck) {
        if(typeOfDeck.equals(TypeOfDeck.UsingList))
            deckOfCardsMap.put(String.valueOf(id),new DeckOfCardsListImpl());
        else{
            deckOfCardsMap.put(String.valueOf(id),new DeckOfCardsStackImpl());
        }
        return id++;
    }

    public List<DeckOfCards> getDecks() {
        return new ArrayList<DeckOfCards>(deckOfCardsMap.values());
    }

    public DeckOfCards getDeckById(Long deckId) {
        return deckOfCardsMap.get(String.valueOf(deckId));
    }

    public boolean deleteDeckById(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.remove(String.valueOf(deckId));
        return deckOfCards != null;
    }

    public boolean shuffle(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            deckOfCards.shuffle();
            return true;
        }
        return false;
    }

    public boolean reset(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            deckOfCards.resetDeck();
            return true;
        }
        return false;
    }

    public long getDeckSize(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getTotalCards();
        }
        return 0;
    }

    public Card getFirstCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getFirstCard();
        }
        return null;
    }

    public Card getLastCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        if (deckOfCards != null) {
            return deckOfCards.getLastCard();
        }
        return null;
    }

    public boolean hasCard(Long deckId) {
        DeckOfCards deckOfCards = deckOfCardsMap.get(String.valueOf(deckId));
        return deckOfCards.hasCard();
    }
}
