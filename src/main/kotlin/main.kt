import classes.Deck
import utils.showCard

/***
 * The main program
 */
fun main(){
    //Display simple value and symbol of cards
    val deck = Deck()

    while (deck.drawFirstCardInDeck()){
        println("----------------------------")
        println("displayValue: ${deck.getCurrentCardDisplayValue()}")
        println("label: ${deck.getCurrentCardLabel()}")
        println("----------------------------")
    }

    deck.resetDeck()


    //Display advanced graphical visualization of cards
    deck.getCards().forEach { card ->
        println(showCard(card))
    }
}