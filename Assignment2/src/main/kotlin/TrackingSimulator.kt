import java.io.File

class TrackingSimulator {
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

    private fun executeLine(line: String){
        val content = line.split(",")

        if (content[0] == "created") {
            addShipment(Shipment("created", content[1]))
        }
        else if (content[0] == "shipped") {
            val shipment = findShipment(id = content[1]) //This might not work <- if bug check here
            if (shipment != null) {
                shipment.status = "shipped"
            }
        }
    }
}