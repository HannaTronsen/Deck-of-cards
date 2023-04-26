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
