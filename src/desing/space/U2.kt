package desing.space

import kotlin.random.Random
//Model of rocket
class U2 : Rocket() {
    override fun launch(): Boolean {
        return successOrFailure()
    }

    override fun land(): Boolean {
        return successOrFailure()
    }

    /**
     * succesOrFailure executes a process to know if the rocket complete its launch and if its reach the planet
     */
    private fun successOrFailure(): Boolean {
        val launchedRocket: Double = Random.nextDouble(0.00, 1.00)
        return chanceLaunchExplosion >= launchedRocket
    }
}