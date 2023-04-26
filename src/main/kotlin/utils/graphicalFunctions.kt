package utils

import classes.SpecialCard
import interfaces.ICard

fun showCard(card: ICard): String {
    return when (card.value) {
        SpecialCardTypes.ACE.value,
        SpecialCardTypes.KNIGHT.value,
        SpecialCardTypes.QUEEN.value,
        SpecialCardTypes.KING.value -> showSpecialCard(card = card as SpecialCard)

        else -> showNormalCard(card = card)
    }
}

private fun showNormalCard(card: ICard): String {
    val v = if(card.value < 10) "${card.value} " else card.value
    val s = card.type.symbol
    return """
     ------------------------
     | $v                $v |
     |                      |
     |                      |
     |                      |
     |          $s           |
     |                      |
     |                      |
     |                      |
     |                      |
     | $v                $v |
     ------------------------
  """.trimIndent()
}

private fun showSpecialCard(card: SpecialCard): String {
    val i = card.initial
    val s = card.type.symbol
    return """
     ------------------------
     | $i                    |
     |                      |
     |                      |
     |                      |
     |         $s            |
     |                      |
     |                      |
     |                      |
     |                      |
     |                   $i  |
     ------------------------
  """.trimIndent()
}