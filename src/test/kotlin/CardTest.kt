import classes.Deck
import com.karumi.kotlinsnapshot.matchWithSnapshot
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec
import io.kotest.extensions.system.captureStandardOut
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class CardTest: FreeSpec ({

    val testDeck = Deck()

    afterEach {
        testDeck.resetDeck()
    }

    "initializingOfNewDeckShouldContainCorrectAmountOfCards" {
        testDeck.getCardCountInActiveDeck() shouldBe CARD_AMOUNT
    }

    "noSelectedCurrentCardInDeckShouldNotThrow" {
        shouldNotThrowAny {
            testDeck.getCurrentCardLabel()
        }
    }

    "allCardsShouldBePresent" {
        testDeck.createDeckSnapshot().matchWithSnapshot(snapshotName = this.testCase.name.testName)
    }

    "shouldBeAbleToShuffleDeck" {
        val snapshotBeforeDeckShuffle = testDeck.getCards().toMutableList()
        testDeck.shuffleDeck()
        snapshotBeforeDeckShuffle shouldNotBeSameInstanceAs testDeck.getCards()
    }

    "shouldBeAbleToResetDeck" {
        testDeck.drawFirstCardInDeck()
        testDeck.getCardCountInActiveDeck() shouldNotBe CARD_AMOUNT
        testDeck.resetDeck()
        testDeck.getCardCountInActiveDeck() shouldBe  CARD_AMOUNT
    }

    "drawingACardShouldDecreaseTheDeckByOne" {
        testDeck.drawFirstCardInDeck()
        testDeck.getCardCountInActiveDeck() shouldBe CARD_AMOUNT - 1
    }

    "tryingToDrawTooManyCardsFromDeckShouldNotThrow" {
        for (n in 1..CARD_AMOUNT + 1){
            if(n > CARD_AMOUNT) {
                captureStandardOut {
                    NO_MORE_CARDS_IN_DECK_ERROR_MESSAGE
                }
            }
            shouldNotThrowAny {
                testDeck.drawFirstCardInDeck()
            }
        }
    }

})