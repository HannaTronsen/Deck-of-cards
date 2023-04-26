package classes

import CARD_AMOUNT
import CURRENT_CARD_ERROR_MESSAGE
import VALID_CARD_TYPES
import utils.DefaultCardTypes
import utils.SpecialCardTypes


/*
* A 'Deck' class that contains cards
* */
class Deck {

    private var currentCard: Card? = null
    private val cards: MutableList<Card> = mutableListOf()
    private val cardAmount: Int = CARD_AMOUNT

    private fun createDeck(){
        for(value in 0..cardAmount / VALID_CARD_TYPES.size){
            val (label, displayValue) = setCardLabelAndDisplayValue(value = value)
            VALID_CARD_TYPES.forEach { cardType: DefaultCardTypes  ->
                cards.add(
                    Card(
                        type = cardType,
                        value = value,
                        label = "$label of ${cardType.label}",
                        displayValue = "$displayValue ${cardType.symbol}"
                    )
                )
            }
        }
    }

    private fun resetDeck(){
        cards.clear()
        createDeck()
    }

    private fun shuffleDeck(){
        cards.shuffle()
    }

    private fun drawFirstCardInDeck(){
        if(cards.isNotEmpty()){
            currentCard = cards.first()
            cards.remove(currentCard)
        } else {
            println("There are no more cards left in this deck, you need to reset the deck")
        }
    }

    private fun getCurrentCardDisplayValue(): String {
        val card = currentCard ?: return CURRENT_CARD_ERROR_MESSAGE
        return card.displayValue
    }

    private fun getCurrentCardLabel(): String {
        val card = currentCard ?: return CURRENT_CARD_ERROR_MESSAGE
        return card.label
    }

    private fun setCardLabelAndDisplayValue(value: Int): Pair<String, String>{
        return when(value){
            SpecialCardTypes.ACE.value -> Pair(SpecialCardTypes.ACE.label, SpecialCardTypes.ACE.symbol)
            SpecialCardTypes.KNIGHT.value -> Pair(SpecialCardTypes.KNIGHT.label, SpecialCardTypes.KNIGHT.symbol)
            SpecialCardTypes.QUEEN.value -> Pair(SpecialCardTypes.QUEEN.label, SpecialCardTypes.QUEEN.symbol)
            SpecialCardTypes.KING.value ->  Pair(SpecialCardTypes.KING.label, SpecialCardTypes.KING.symbol)
            else -> Pair(value.toString(), value.toString())
        }
    }
}