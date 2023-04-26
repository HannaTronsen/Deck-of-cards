package classes

import CARD_AMOUNT
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
        currentCard = cards.first()
        cards.remove(currentCard)
    }

    private fun getCurrentCardLabelAndDisplaylValue(): Pair<String, String>? {
        val card = currentCard ?: return null //handle this when implementing error handling
        return Pair(card.label, card.displayValue)
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