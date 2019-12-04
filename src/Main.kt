import design.space.Rocket
import simulation.Simulation
import src.design.RocketType

fun main() {
    for (l in 1..100) {
        val simulationVariable = Simulation()
        var rocketList: ArrayList<Rocket>
        var budget: Int
        RocketType.values().forEach { rocketType ->
            val loadingString = "Loading fleet of ${rocketType.type} ships.."
            println(loadingString)
            if (rocketType == RocketType.IDENTIFIER_ROCKET_TYPE_ONE) {
                rocketList = simulationVariable.loadU1()
                budget = simulationVariable.runSimulation(rocketList)
                loadProcess(rocketList, budget)
            }
            if (rocketType == RocketType.IDENTIFIER_ROCKET_TYPE_TWO) {
                rocketList = simulationVariable.loadU2()
                budget = simulationVariable.runSimulation(rocketList)
                loadProcess(rocketList, budget)
            }
        }
    }
}

fun loadProcess(rocketList: ArrayList<Rocket>, budget: Int) {
    val totalString: String
    val rocketValue = rocketList[0].rocketCost
    val numberOfRockets = budget / rocketValue
    totalString = "the total budget is $budget and the number of rockets to send is $numberOfRockets"
    println(totalString)
}
