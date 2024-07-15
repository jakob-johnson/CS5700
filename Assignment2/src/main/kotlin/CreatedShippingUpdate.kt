class CreatedShippingUpdate: ShippingUpdate {
    override val previousStatus: String = ""
    override val newStatus: String = ""
    override val timeStamp: Long = 0

    override fun update(
        shipment: Shipment?,
        updateType: String,
        shipmentId: String,
        updateTimeStamp: Long,
        otherInfo: String?
    ) {
        val newShipment = Shipment("Created", shipmentId)
        TrackingSimulator.addShipment(newShipment)
    }
}
