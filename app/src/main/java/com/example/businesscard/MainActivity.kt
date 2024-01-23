package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView()
                }
            }
        }
    }
}

object BusinessCardTheme {
    val BackgroundGreen = Color(0xFFd2e8d4)
    val FontGreen = Color(0xFF016d3b)

//    val SizeFontSmall = 8.sp
    val SizeFontMedium = 16.sp
    val SizeFontLarge = 32.sp

    val PaddingSmall = 8.dp
    val PaddingMedium = 16.dp
    val PaddingBig = 32.dp
}

@Composable
fun SocialIcon(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .height(30.dp)
            .padding(end = BusinessCardTheme.PaddingMedium)
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = BusinessCardTheme.FontGreen)
    }
}

@Composable
fun SocialText(txt: String){
    Row(
        modifier = Modifier.height(30.dp)
    ){
        Text(text = txt)
    }
}

@Composable
fun ProfileContainer(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row{
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier.size(200.dp)
            )
        }
        Row{
            Text(text = stringResource(id = R.string.full_name),
                Modifier.padding(vertical = BusinessCardTheme.PaddingSmall),
                fontSize = BusinessCardTheme.SizeFontLarge,
            )
        }
        Row{
            Text(text = stringResource(id = R.string.job_title),
            fontSize = BusinessCardTheme.SizeFontMedium,
                fontWeight = FontWeight.Medium,
                color = BusinessCardTheme.FontGreen
            )
        }
    }
}

@Composable
fun SocialContainer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = BusinessCardTheme.PaddingBig),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            SocialIcon(Icons.Default.Call, "Mobile Icon")
            SocialIcon(Icons.Default.Share, "Share Icon")
            SocialIcon(Icons.Default.Email, "Email Icon")
        }

        Column {
            SocialText(stringResource(id = R.string.mobile))
            SocialText(stringResource(id = R.string.share))
            SocialText(stringResource(id = R.string.email))
        }
    }
}

@Composable
fun MainView(){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(BusinessCardTheme.BackgroundGreen)
    ){
            ProfileContainer(
                modifier = Modifier
                    .align(Alignment.Center)
            )

            SocialContainer(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = BusinessCardTheme.PaddingBig)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainView()
    }
}