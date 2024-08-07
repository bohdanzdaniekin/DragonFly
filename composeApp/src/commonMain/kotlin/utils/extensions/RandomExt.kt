package utils.extensions

import kotlin.random.Random

fun Random.nextFloat(min: Float, max: Float): Float {
    require(min < max) { "Invalid range [$min, $max]" }
    return min + nextFloat() * (max - min)
}
