package classes

import utils.DefaultCardTypes

data class Card(
    val type: DefaultCardTypes,
    val value: Int,
    val label: String,
    val displayValue: String
)
