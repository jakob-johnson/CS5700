class CreatedShippingUpdate: ShippingUpdate {
    override val previousStatus: String = ""
    override val newStatus: String = ""
    override val timeStamp: Long = 0

    override fun update(
        updateType: String,
        shipmentId: String,
        updateTimeStamp: Long,
        otherInfo: String?
    ) {
        val shipment = Shipment("Created", shipmentId)
        TrackingSimulator.addShipment(shipment)
        shipment.addUpdate(this)
    }
}
