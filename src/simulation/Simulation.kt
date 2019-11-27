package simulation
import desing.space.Rocket
import desing.space.U1
import desing.space.U2
import desing.supplies.Items
import java.io.File
class Simulation {
    init {

    }
    private fun loadItems(numberPhase: Int): ArrayList<Items> {
        var aux: Array<String>
        val itemsList = ArrayList<Items>()
        val pathAux: String = System.getProperty("user.dir").toString()
        File("$pathAux\\src\\Simulation\\Phases\\Phase-$numberPhase.txt").forEachLine {
            aux = it.split("=").toTypedArray()
            itemsList.add(Items(aux[0], aux[1].toInt()))
        }
        return itemsList
    }
    fun loadU1(): ArrayList<U1> {
        val itemsList = loadItems(1)
        val rocketList: ArrayList<U1> = ArrayList()
        var flag = true
        var count = 0
        while (flag) {
            val r1 = U1()//Rocket variable
            r1.createRocket()//Generate a rocket
            println(r1.rocketWeight)
            itemsList.forEach { item ->
                //For that fills the rockets
                if (r1.canCarry(item) && item.status) {
                    item.status = false
                    r1.carry(item)
                    println(r1.rocketWeight)
                    println(item.Name)
                    count++
                }
            }
            rocketList.add(r1)
            if (count == itemsList.size) {
                flag = false
            }
        }
        return rocketList
    }

    fun loadU2(): ArrayList<U2> {
        val itemsList = loadItems(2)
        val rocketList: ArrayList<U2> = ArrayList()
        var flag = true
        var count = 0
        while (flag) {
            val r2 = U2()//Rocket variable
            r2.createRocket()//Generate a rocket
            println(r2.rocketWeight)
            itemsList.forEach { item ->
                //For that fills the rockets
                if (r2.canCarry(item) && item.status) {
                    item.status = false
                    r2.carry(item)
                    println(r2.rocketWeight)
                    println(item.Name)
                    count++
                }
            }
            rocketList.add(r2)
            if (count == itemsList.size) {
                flag = false
            }
        }
        return rocketList
    }
    fun runSimulation(ArrayRockets: ArrayList<Rocket>): Int{

        return 0
    }
}