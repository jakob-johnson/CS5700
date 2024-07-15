class Shipment(
    var status: String,
    val id: String,
) {
    var currentLocation: String = ""
    val notes = mutableListOf<String>()
    val updateHistory = mutableListOf<ShippingUpdate>()
    var expectedDelivery: Long = 0

    private val subscribers = mutableListOf<(Int) -> Unit>()

    fun subscribe(observer: (Int) -> Unit){
       subscribers.add(observer)
    }

    fun unsubscribe(observer: (Int) -> Unit){
        subscribers.remove(observer)
    }

    fun addNotes(note: String){
        notes.add(note)
    }

    fun addUpdate(update: ShippingUpdate){
        updateHistory.add(update)
    }


}