import utils.DefaultCardTypes

/* Default deck constants
*
* These constants are related to what properties a deck should have and how the whole system logic should
* take these constants into considerations when executing system logic.
*
* */

const val CARD_AMOUNT: Int = 52
val VALID_CARD_TYPES: Set<DefaultCardTypes> = setOf(
    DefaultCardTypes.SPADE,
    DefaultCardTypes.HEART,
    DefaultCardTypes.DIAMOND,
    DefaultCardTypes.CLUB,
)
const val CURRENT_CARD_ERROR_MESSAGE = "You haven't drawn a card yet"
const val NO_MORE_CARDS_IN_DECK_ERROR_MESSAGE = "There are no more cards left in this deck, you need to reset the deck"
