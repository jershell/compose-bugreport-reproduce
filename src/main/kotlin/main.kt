import androidx.compose.desktop.Window
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import kotlin.math.max

private const val content = """
    "When I was a little kid, I was really scared of the dark. But then I came to understand, dark just means the absence of photons in the visible wavelength 400 to 700 nanometers. Then I thought, well it's really silly to be afraid of a lack of photons. Then I wasn't afraid of the dark anymore after that."
"""

fun main() = Window {
    var sliderPosition by remember { mutableStateOf(12) }

    MaterialTheme {
        Column(Modifier.padding(16.dp)) {
            Text("lineHeight ${sliderPosition.sp}")

            Row {
                Slider(value = sliderPosition.toFloat(), onValueChange = { sliderPosition = it.toInt() }, valueRange= 0f..140f)
            }

            Spacer(Modifier.height(16.dp))
            Column(
                Modifier
                    .border(1.dp, Color.Black)
                    .padding(16.dp)
                    .width(200.dp)
                    .scrollable(rememberScrollState(), Orientation.Vertical)
            ) {
                Text(content, style = TextStyle(lineHeight = sliderPosition.sp, fontSize = 12.sp))
                Spacer(Modifier.height(8.dp))
                Text("— Elon Musk", Modifier.fillMaxWidth(), style = TextStyle(textAlign = TextAlign.End))
            }
        }
    }
}
