package com.example.clothify.presentation.utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun CustomTextField(
    value:String,
    onValueChange:(String)->Unit,
    label:String,
    singleLine:Boolean = true,
    leadingIcon:ImageVector?= null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier
){
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {Text(text = label)},
            singleLine = singleLine,
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            modifier = modifier
        )
}
