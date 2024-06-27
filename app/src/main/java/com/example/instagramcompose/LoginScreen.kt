package com.example.instagramcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true
)
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
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier) {
    //val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier
            .clickable {
                //activity.finish()
            }
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

    var isLoginEnabled by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(Modifier.size(4.dp))
        Password(password) { password = it }
        Spacer(Modifier.size(8.dp))
        ForgotPasswordButton(Modifier.align(Alignment.End))
        Spacer(Modifier.size(16.dp))
        LoginButton(isLoginEnabled)
        Spacer(Modifier.size(16.dp))
        LoginDivider()
        Spacer(Modifier.size(23.dp))
        SocialLoginButton()
    }

}

@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .fillMaxWidth()
                .height(1.dp)
        )
        Spacer(Modifier.size(24.dp))
        SignUpButton()
        Spacer(Modifier.size(24.dp))
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(
            id = R.drawable.insta
        ),
        contentDescription = "Logo",
        modifier = modifier
    )
}

@Composable
fun Email(
    email: String,
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
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
        modifier = Modifier.fillMaxWidth(),
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

@Composable
fun LoginButton(isLoginEnabled: Boolean) {
    Button(
        onClick = {

        },
        enabled = isLoginEnabled,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier
                .padding(horizontal = 24.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun SocialLoginButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fb),
            contentDescription = "Login with facebook",
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = "Continue as Josué",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun SignUpButton() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign up.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}
