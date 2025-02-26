package com.example.clothify.presentation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clothify.R
import com.example.clothify.presentation.utils.CustomTextField


@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
        )

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Spacer(Modifier.padding(8.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Spacer(Modifier.padding(4.dp))
        Text(
            text = "Forget Password?",
            modifier = Modifier.align(
                Alignment.End
            )
        )
        Spacer(Modifier.padding(16.dp))
        Button(
            onClick = {
                if (email.isNotEmpty() and password.isNotEmpty()) {
                    Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context,"Please fill all details",Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 16.dp), // it will send above composable to up if and if used spacer it will send this composable down
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.teal_700)),
            border = BorderStroke(1.dp, color = colorResource(R.color.teal_700))
        ) {
                    Text("Login")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Already have an account?"
            )
            TextButton(
                onClick = {
                    // navigate to Signup screen
                }
            ) {
                Text(
                    text = "Signup"
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Or",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f)
            )
        }
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.google_ic),
                contentDescription = "Signup with google"
            )
            Spacer(Modifier.size(8.dp))
            Text(
                text = "Login with Google"
            )
        }

    }

}