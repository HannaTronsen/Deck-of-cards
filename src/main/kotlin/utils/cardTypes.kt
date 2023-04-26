package utils

/***
* DefaultCardTypes defines the default types of cards we can see in a deck of cards.
* If we later wanted to introduce different graphics.getCard type, like for example "Circle", it
* would be easy to modify the code if we have the type defined in an enum like this.
* */
enum class DefaultCardTypes(val label: String, val symbol: String) {
    SPADE(label="Spade", symbol = "♠"),
    HEART(label="Heart", symbol = "♥"),
    DIAMOND(label="Diamond", symbol = "♦"),
    CLUB(label="Club", symbol = "♣"),
}


/***
 * SpecialCardTypes defines the special cards in a typical deck. These are different because
 * they have a deeper meaning and possibly also different rules that apply to them than the rest of the cards.
* If we later wanted to add different types of special cards, like for example the "Joker", it
* would be easy to modify the code if we have the types defined in an enum like this.
 * */
enum class SpecialCardTypes(val label: String, val initial: String, val value: Int){
    ACE(label = "Ace", initial = "A", value = 1),
    KNIGHT(label = "Jack", initial = "J", value = 11),
    QUEEN(label = "Queen", initial = "Q", value = 12),
    KING(label = "King", initial = "K", value = 13),
}