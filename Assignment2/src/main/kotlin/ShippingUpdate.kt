interface ShippingUpdate{
    val previousStatus: String
    val newStatus: String
    val timeStamp: Long

    fun update(shipment: Shipment, updateType: String, shipmentId: String, updateTimeStamp: Long, otherInfo: String?)

}
