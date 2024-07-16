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

        CreatedShippingUpdate().update("Created", "1001", 1999283774)
        CreatedShippingUpdate().update("Created", "1002", 1999283774)
        CreatedShippingUpdate().update("Created", "1003", 1999283774)

        shipments.forEach{
            println(it)
        }

        findShipment("1001")?.updateHistory?.forEach{
            println(it)
        }

        ShippedShippingUpdate().update("Shipping", "1001", 1999283999)
        ShippedShippingUpdate().update("Shipping", "1002", 1999283999)


    }
}