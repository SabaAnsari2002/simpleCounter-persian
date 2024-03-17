package ir.shariaty.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ir.shariaty.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var number by remember {
                        mutableStateOf(0);
                    }
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        TextResult(s = "$number")
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            MyButton( "+", {number++})
                            MyButton( "-", {number--})

                        }
                    }
                }
            }
        }
    }



    //    class PersianNumbers {
//        companion object {
//            fun toPersian(number: Int): String {
//                val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")
//                return number.toString().map { persianNumbers[it.toString().toInt()] }.joinToString("")
//            }
//        }
//    }
class PersianNumbers {
    companion object {
        fun toPersian(number: Int): String {
            val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")
            val isNegative = number < 0
            val absNumber = if (isNegative) -number else number
            val result = absNumber.toString().map { persianNumbers[it.toString().toInt()] }.joinToString("")
            return if (isNegative) "−$result" else result
        }
    }
}
//    @Composable
//    private fun TextResult(s: String){
//        Text(text = PersianNumbers.toPersian(s.toInt()),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
@Composable
private fun TextResult(s: String){
    Text(text = PersianNumbers.toPersian(s.toInt()),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}
    @Composable
    private fun MyButton(text: String,function:()->Unit){
        Button(onClick = function) {
            Text(text = text)
        }
    }
//    @Composable
//    private fun TextResult(s: String){
//        Text(text = s,
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold
//
//        )
//    }

}
