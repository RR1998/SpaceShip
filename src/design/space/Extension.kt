package design.space

/**
 * Rocket.shield function sets up a shield in every three rocket sended to it
 */

fun Rocket.shield(count: Int) {
    if (count.rem(3) == 0 && count != 0) {
        this.chanceLaunchExplosion = 0.0
        this.chanceLandingCrash = 0.0
    }
}
