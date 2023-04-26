package classes

import interfaces.ICard
import utils.DefaultCardTypes

data class SpecialCard(
    override val type: DefaultCardTypes,
    override val value: Int,
    override val label: String,
    override val displayValue: String,
    val initial: String,
): ICard
