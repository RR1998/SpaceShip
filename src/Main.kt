import simulation.Simulation

fun main(args:Array<String>){
    val x = Simulation()
    //var y =  x.loadU1()
    val r1 = x.loadU1(1)
    val r = x.runSimulation(r1)
    println(r1.size)
    println(r)
}
