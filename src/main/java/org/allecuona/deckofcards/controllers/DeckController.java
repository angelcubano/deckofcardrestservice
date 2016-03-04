package org.allecuona.deckofcards.controllers;

import org.allecuona.deckofcards.Card;
import org.allecuona.deckofcards.DeckOfCards;
import org.allecuona.deckofcards.DeckOfCardsListImpl;
import org.allecuona.deckofcards.DeckOfCardsStackImpl;
import org.allecuona.deckofcards.domain.CardDto;
import org.allecuona.deckofcards.domain.DeckOfCardsDto;
import org.allecuona.deckofcards.domain.TypeOfDeck;
import org.allecuona.deckofcards.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by angel on 03/03/16.
 */
@RestController
public class DeckController {

    @Autowired
    private DeckService deckService;

    @RequestMapping(value = "/deck", method = RequestMethod.POST, consumes={"application/json"})
    public long createDeck(@RequestBody String typeDeck){
        if(typeDeck.equals(TypeOfDeck.UsingList.name()))
        return deckService.createDeck(TypeOfDeck.UsingList);
        else if(typeDeck.equals(TypeOfDeck.UsingStack.name()))
            return deckService.createDeck(TypeOfDeck.UsingStack);
        return -1;
    }

    @RequestMapping(value = "/deck", method = RequestMethod.GET)
    public List<DeckOfCardsDto> getDecks(){

        List<DeckOfCards> deckOfCardses = deckService.getDecks();

        return deckOfCardses.stream()
                .map(deckOfCards -> convertToDeckOfCardsDto(deckOfCards)).collect(Collectors.toList());

    }

    @RequestMapping(value = "/deck/{deckId}", method = RequestMethod.GET)
    public DeckOfCardsDto getDeckById(@PathVariable Long deckId){
        DeckOfCards deckOfCards = deckService.getDeckById(deckId);
        return deckOfCards!=null ? this.convertToDeckOfCardsDto(deckOfCards) : null;
    }

    @RequestMapping(value = "/deck/{deckId}", method = RequestMethod.DELETE)
    public boolean deleteDeckById(@PathVariable Long deckId){
        return deckService.deleteDeckById(deckId);

    }

    @RequestMapping(value = "/deck/{deckId}/shuffle")
    public boolean shuffle(@PathVariable Long deckId){
        return deckService.shuffle(deckId);
    }

    @RequestMapping(value = "/deck/{deckId}/reset")
    public boolean reset(@PathVariable Long deckId){
        return deckService.reset(deckId);
    }

    @RequestMapping(value = "/deck/{deckId}/cards")
    public long getDeckSize(@PathVariable Long deckId){
        return deckService.getDeckSize(deckId);
    }

    @RequestMapping(value = "/deck/{deckId}/firstcards")
    public CardDto getFirstCard(@PathVariable Long deckId){
        Card card = deckService.getFirstCard(deckId);
        CardDto cardDto = new CardDto();
        if (card != null) {
            cardDto.convertToCardsDto(card);
            return cardDto;
        }
        return null;
    }

    @RequestMapping(value = "/deck/{deckId}/lastcards")
    public CardDto getLastCard(@PathVariable Long deckId){
        Card card = deckService.getLastCard(deckId);
        CardDto cardDto = new CardDto();
        if (card != null) {
            cardDto.convertToCardsDto(card);
            return cardDto;
        }
        return null;
    }

    @RequestMapping(value = "/deck/{deckId}/card")
    public boolean hasCard(@PathVariable Long deckId){
        return deckService.hasCard(deckId);
    }



    private DeckOfCardsDto convertToDeckOfCardsDto(DeckOfCards deckOfCards) {
        DeckOfCardsDto deckOfCardsDto = new DeckOfCardsDto();
        if(deckOfCards instanceof DeckOfCardsListImpl)
            deckOfCardsDto.setCards(((DeckOfCardsListImpl) deckOfCards).getCards());
        else
            deckOfCardsDto.setCards(((DeckOfCardsStackImpl)deckOfCards).getCardsList());
        return deckOfCardsDto;
    }
}
