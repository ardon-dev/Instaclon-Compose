package com.example.instagramcompose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(Modifier)
}

@Composable
fun LoginScreen(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier
            .clickable { activity.finish() }
    )
}

@Composable
fun Body(modifier: Modifier) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
    ) {
        ImageLogo()
        Spacer(Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(Modifier.size(4.dp))
        Password(password) { password = it }
        Spacer(Modifier.size(8.dp))
        ForgotPasswordButton(Modifier.align(Alignment.End))
    }

}

@Composable
fun ImageLogo() {
    Image(
        painter = painterResource(
            id = R.drawable.insta
        ),
        contentDescription = "Logo"
    )
}

@Composable
fun Email(
    email: String,
    onValueChanged: (String) -> Unit,
) {
    TextField(
        value = email,
        onValueChange = {
            onValueChanged(it)
        }
    )
}

@Composable
fun Password(
    password: String,
    onValueChanged: (String) -> Unit,
) {
    TextField(
        value = password,
        onValueChange = {
            onValueChanged(it)
        }
    )
}

@Composable
fun ForgotPasswordButton(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}