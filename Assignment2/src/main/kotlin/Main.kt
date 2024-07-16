import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import kotlinx.coroutines.launch
import java.util.*

@Composable
@Preview
fun App() {
    var shipmentIdSearch by remember { mutableStateOf("")}
    val shipments = remember { mutableStateListOf<TrackerViewHelper>()}

    MaterialTheme {
        Column {
            Row {
                TextField(shipmentIdSearch, onValueChange = {
                    shipmentIdSearch = it
                })

                Button(onClick = {
                    TrackingSimulator.findShipment(shipmentIdSearch)?.let { TrackerViewHelper(it) }
                        ?.let { shipments.add(it) }
                    shipmentIdSearch = ""
                }){
                    Text("Search")
                }

                Button(onClick = {
                    println(shipments[0].shipmentStatus)
                }){
                    Text("Check")
                }
            }
            LazyColumn {
                items(shipments, key = {it.shipmentID}) {
                    Column (modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)){
                        Text("Tracking shipment: ${it.shipmentID}")
                        Text("Status: ${it.shipmentStatus}")
                        Text("Location: ${it.shipmentLocation}")
                        Text("Expected Delivery: ${Date(it.shipmentExpectedDelivery)}")
                    }
                }
            }
        }
    }
}

fun main() =  application {
    val coroutineScope = rememberCoroutineScope()
    Window(onCloseRequest = ::exitApplication) {
        App()
    }

    coroutineScope.launch {
        TrackingSimulator.runSimulation()
    }
}
