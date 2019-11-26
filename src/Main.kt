import desing.supplies.Items
import java.io.File

fun main(){
    var aux: Array<String>
    val itemsList = ArrayList<Items>()
    val pathAux: String = System.getProperty("user.dir").toString()
    File("$pathAux\\src\\Simulation\\Phases\\Phase-1.txt").forEachLine {
        aux = it.split("=").toTypedArray()
        itemsList.add(Items(aux[0],aux[1].toInt()))
    }
    File("$pathAux\\src\\Simulation\\Phases\\Phase-2.txt").forEachLine {
        aux = it.split("=").toTypedArray()
        itemsList.add(Items(aux[0],aux[1].toInt()))
    }
    for(items in itemsList){
        println(items.status)
    }
}
