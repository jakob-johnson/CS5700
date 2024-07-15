import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TrackerViewHelper(
    private val shipment: Shipment
) {
    val shipmentID by mutableStateOf(shipment.id)
    val shipmentNotes by mutableStateOf(shipment.notes)
    val shipmentUpdateHistory by mutableStateOf(shipment.updateHistory)
    val shipmentExpectedDelivery by mutableStateOf(shipment.expectedDelivery)
    val shipmentStatus by mutableStateOf(shipment.status)

}