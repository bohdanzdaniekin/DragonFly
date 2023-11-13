package com.mr.nemo.dragonfly.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun PasswordTextField(
    password: String,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.hint_password),
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
    )
) {

    var isPasswordVisible by remember { mutableStateOf(false) }
    val passwordIcon = if (isPasswordVisible) {
        Icons.Default.Visibility
    } else {
        Icons.Default.VisibilityOff
    }
    BaseTextField(
        value = password,
        onValueChange = onPasswordValueChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = DragonFlyTheme.typography.text1.regular,
        trailingIcon = {
            IconButton(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                Icon(
                    imageVector = passwordIcon,
                    contentDescription = placeholder,
                    tint = DragonFlyTheme.colors.neutral5
                )
            }
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation('*')
        },
        keyboardOptions = keyboardOptions.copy(
            keyboardType = KeyboardType.Password
        ),
        placeholder = placeholder,
        label = placeholder,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
private fun PasswordTextFieldPreview() {
    DragonFlyTheme {
        PasswordTextField(
            password = "some_password",
            onPasswordValueChange = {}
        )
    }
}
