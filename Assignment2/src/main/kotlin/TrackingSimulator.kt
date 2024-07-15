import java.io.File

object TrackingSimulator {
    private val shipments = mutableListOf<Shipment>()

    fun findShipment(id: String): Shipment? {
        val shipment: Shipment? = shipments.find { it.id == id }
        return shipment
    }

    fun addShipment(shipment: Shipment){
        shipments.add(shipment)
    }

    fun runSimulation(){
        File("src/main/resources/test.txt").forEachLine { println(it) }
    }
}