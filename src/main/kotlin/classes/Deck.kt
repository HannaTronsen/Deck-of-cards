package classes

import CARD_AMOUNT
import VALID_CARD_TYPES
import utils.DefaultCardTypes
import utils.SpecialCardTypes


/*
* A 'Deck' class that contains cards
* */
class Deck {

    private val cards: MutableList<Card> = mutableListOf()
    private val cardAmount: Int = CARD_AMOUNT



    fun createDeck(){
        for(value in 0..cardAmount / VALID_CARD_TYPES.size){
            val (cardLabel, cardDisplayValue) = setCardAndDisplayLabel(value = value)
            VALID_CARD_TYPES.forEach { cardType: DefaultCardTypes  ->
                cards.add(
                    Card(
                        type = cardType,
                        value = value,
                        label = "$cardLabel of ${cardType.label}",
                        displayValue = "$cardDisplayValue ${cardType.symbol}"
                    )
                )
            }
        }
    }

    private fun setCardAndDisplayLabel(value: Int): Pair<String, String>{
        return when(value){
            SpecialCardTypes.ACE.value -> Pair(SpecialCardTypes.ACE.label, SpecialCardTypes.ACE.symbol)
            SpecialCardTypes.KNIGHT.value -> Pair(SpecialCardTypes.KNIGHT.label, SpecialCardTypes.KNIGHT.symbol)
            SpecialCardTypes.QUEEN.value -> Pair(SpecialCardTypes.QUEEN.label, SpecialCardTypes.QUEEN.symbol)
            SpecialCardTypes.KING.value ->  Pair(SpecialCardTypes.KING.label, SpecialCardTypes.KING.symbol)
            else -> Pair(value.toString(), value.toString())
        }
    }
}