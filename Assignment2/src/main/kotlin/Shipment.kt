class Shipment(
    var status: String,
    val id: String,
) {
    var currentLocation: String = ""
    val notes = mutableListOf<String>()
    val updateHistory = mutableListOf<ShippingUpdate>()
    var expectedDelivery: Long = 0

    fun addNotes(note: String){
        notes.add(note)
    }

    fun addUpdate(update: ShippingUpdate){
        updateHistory.add(update)
    }


}