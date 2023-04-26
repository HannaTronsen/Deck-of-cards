package interfaces

import utils.DefaultCardTypes

interface ICard {
    val type: DefaultCardTypes
    val value: Int
    val label: String
    val displayValue: String
}