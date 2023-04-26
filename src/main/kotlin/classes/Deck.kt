package classes

import CARD_AMOUNT
import CURRENT_CARD_ERROR_MESSAGE
import NO_MORE_CARDS_IN_DECK_ERROR_MESSAGE
import VALID_CARD_TYPES
import interfaces.ICard
import utils.DefaultCardTypes
import utils.SpecialCardTypes


/*
* A 'Deck' class that contains cards
* */
class Deck {

    private var currentCard: ICard? = null
    private val cards: MutableList<ICard> = mutableListOf()

    init {
        createDeck()
    }

    private fun createDeck() {
        for (value in 1..CARD_AMOUNT / VALID_CARD_TYPES.size) {
            val (label, valueSymbol) = setCardLabelAndDisplayValue(value = value)
            VALID_CARD_TYPES.forEach { cardType: DefaultCardTypes ->
                cards.add(
                    when (value) {
                        SpecialCardTypes.ACE.value,
                        SpecialCardTypes.KNIGHT.value,
                        SpecialCardTypes.QUEEN.value,
                        SpecialCardTypes.KING.value -> SpecialCard(
                            type = cardType,
                            value = value,
                            label = "$label of ${cardType.label}",
                            displayValue = "$valueSymbol ${cardType.symbol}",
                            initial = valueSymbol
                        )

                        else -> NormalCard(
                            type = cardType,
                            value = value,
                            label = "$label of ${cardType.label}",
                            displayValue = "$valueSymbol ${cardType.symbol}"
                        )
                    }
                )
            }
        }
    }

    internal fun resetDeck() {
        cards.clear()
        createDeck()
    }

    internal fun shuffleDeck() {
        cards.shuffle()
    }

    internal fun drawFirstCardInDeck(): Boolean {
        return if (cards.isNotEmpty()) {
            currentCard = cards.first()
            cards.remove(currentCard)
            true
        } else {
            println(NO_MORE_CARDS_IN_DECK_ERROR_MESSAGE)
            false
        }
    }

    internal fun getCurrentCardDisplayValue(): String {
        val card = currentCard ?: return CURRENT_CARD_ERROR_MESSAGE
        return card.displayValue
    }

    internal fun getCurrentCardLabel(): String {
        val card = currentCard ?: return CURRENT_CARD_ERROR_MESSAGE
        return card.label
    }

    internal fun createDeckSnapshot(): String {
        return cards.joinToString(separator = "\n") { it.label }
    }

    internal fun getCardCountInActiveDeck(): Int {
        return cards.size
    }

    internal fun getCards(): MutableList<ICard> = cards

    private fun setCardLabelAndDisplayValue(value: Int): Pair<String, String> {
        return when (value) {
            SpecialCardTypes.ACE.value -> Pair(SpecialCardTypes.ACE.label, SpecialCardTypes.ACE.initial)
            SpecialCardTypes.KNIGHT.value -> Pair(SpecialCardTypes.KNIGHT.label, SpecialCardTypes.KNIGHT.initial)
            SpecialCardTypes.QUEEN.value -> Pair(SpecialCardTypes.QUEEN.label, SpecialCardTypes.QUEEN.initial)
            SpecialCardTypes.KING.value -> Pair(SpecialCardTypes.KING.label, SpecialCardTypes.KING.initial)
            else -> Pair(value.toString(), value.toString())
        }
    }
}