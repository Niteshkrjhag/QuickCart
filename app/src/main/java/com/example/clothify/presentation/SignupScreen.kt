package com.example.clothify.presentation

import android.widget.Toast
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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


@Preview(showSystemUi = true)
@Composable
fun SignUpScreen() {
    val context = LocalContext.current

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "SignUp",
            fontSize = 24.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.Start)
        )
        CustomTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = "First Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        CustomTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = "Last Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
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
        CustomTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = "Phone Number",
            leadingIcon = Icons.Default.Phone,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
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
        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Button(
            onClick = {
                if (firstName.isNotEmpty() and lastName.isNotEmpty() and phoneNumber.isNotEmpty() and email.isNotEmpty() and password.isNotEmpty() and confirmPassword.isNotEmpty()) {
                    if (password == confirmPassword) {
                        Toast.makeText(context, "SignUp Successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Password and confirm Password don't match",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(context, "Please fill all details", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.teal_700))
        ) {
            Text(
                text = "Signup"
            )
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
                    // navigate to login screen
                }
            ) {
                Text(
                    text = "Login"
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
                text = "Signup with Google"
            )
        }


    }
}