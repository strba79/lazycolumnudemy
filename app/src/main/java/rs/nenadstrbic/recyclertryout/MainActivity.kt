package rs.nenadstrbic.recyclertryout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnDemo2 {
                Log.i("toastCheck",it)
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }

        }
    }

    @Composable
    fun LazyColumnDemo2(selectedItem: (String) -> (Unit)) {
        LazyColumn {
            items(100) {
                Text(
                    "User Name $it",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { selectedItem("$it Selected") }
                )
                Divider(color = Color.Black, thickness = 5.dp)
            }
        }
    }
}