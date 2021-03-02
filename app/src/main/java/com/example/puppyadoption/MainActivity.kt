package com.example.puppyadoption

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.puppyadoption.ui.theme.PuppyAdoptionTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val puppiesList = Puppy.buildList()

            PuppyAdoptionTheme {
                buildRecycler(puppiesList,baseContext)
            }
        }

    }
}

@Composable
fun buildRecycler(puppies: ArrayList<Puppy>,context: Context) {

    LazyColumn {
        itemsIndexed(puppies) { index, puppy ->
            Row (
                modifier = Modifier.fillMaxWidth().background(Color.White).clickable {
                    val intent = Intent(context,InfoActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intent.putExtra("puppy_object",puppy)
                    context.startActivity(intent)
                }
            ){

                Image(
                    painter = painterResource(puppy.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop

                )

                Column(
                    modifier = Modifier.padding(16.dp)) {
                    Text("Name: ${puppy.name}",color = Color.Gray)
                    Text("Address: ${puppy.address}")
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    val puppiesList = Puppy.buildList()

    PuppyAdoptionTheme {
        buildRecycler(puppiesList,LocalContext.current)
    }
}