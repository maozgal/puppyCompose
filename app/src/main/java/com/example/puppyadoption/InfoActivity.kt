package com.example.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puppyadoption.ui.theme.PuppyAdoptionTheme

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.getParcelableExtra<Puppy>("puppy_object")
        setContent {
            PuppyAdoptionTheme {
                puppy?.let {
                    buildPage(puppy)
                }
            }
        }

    }
}

@Composable
fun buildPage(puppy: Puppy) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(puppy.photo),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop

        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Name: ${puppy.name}", color = Color.Gray,style = typography.h3,modifier = Modifier.padding(0.dp,10.dp,0.dp,10.dp))
            Text("Age: ${puppy.age}", color = Color.Black,style = typography.h5)
            Text("Breed: ${puppy.type}", color = Color.Black,style = typography.h5)
            Text("Weight: ${puppy.weight}", color = Color.Black,style = typography.h5)
            Text("Name: ${puppy.name}", color = Color.Black,style = typography.h5)
            Text("Address: ${puppy.address}", color = Color.Black,style = typography.h5)
        }
    }

}


@Preview
@Composable
fun DefaultPreview2() {
    var p = Puppy()
    p.type = "Boxer"
    p.name = "Boxy"
    p.age = "4 months"
    p.weight = "30kg"
    p.address = "3921  Rinehart Road, UNIOPOLIS"
    p.photo = R.drawable.a1

    PuppyAdoptionTheme {
        buildPage(p)
    }
}


