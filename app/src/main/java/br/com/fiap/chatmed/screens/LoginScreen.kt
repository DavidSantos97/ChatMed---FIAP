package br.com.fiap.chatmed.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmed.R
import br.com.fiap.chatmed.ui.theme.ChatMEDTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {

    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }
    val senhaVisibility = remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier =
    Modifier
        .fillMaxWidth()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.BottomStart),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = "Seta Voltar",
                            tint = Color.Black
                        )

                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Login",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 20.dp)
                .size(width = 200.dp, height = 100.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_preto),
                    contentDescription = "Logo ChatMED"
                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    placeholder = {
                        Box(modifier = Modifier.fillMaxWidth()
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "Icone email",
                                tint = Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                text = "E-mail",
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 40.dp)
                            )

                        }

                    },
                    textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF17DB2E),
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(size = 8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    value = senhaState.value,
                    onValueChange = { senhaState.value = it },
                    placeholder = {
                        Box(modifier = Modifier.fillMaxWidth()
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.senha),
                                contentDescription = "Icone senha",
                                tint = Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                text = "Senha",
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 40.dp)
                            )

                        }


                    },
                    textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF17DB2E),
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(size = 8.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    trailingIcon = {
                        IconButton(onClick = { senhaVisibility.value = !senhaVisibility.value })
                        {
                            val icon = if (senhaVisibility.value) {
                                painterResource(id = R.drawable.olho_fecha)
                            } else {
                                painterResource(id = R.drawable.olho_abre)
                            }
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = icon,
                                tint = Color.Gray,
                                contentDescription = if (senhaVisibility.value) "Esconder Senha" else "Visualizar Senha"
                            )
                        }
                    },
                    visualTransformation = if (senhaVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Esqueceu a senha?",
                    color = Color(0xFF17DB2E),
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable(onClick = {})
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Button(
                    modifier = Modifier
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF17DB2E)
                    )
                ) {
                    Text(
                        text = "Enviar",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Não tem uma conta ? ",
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(text = "Cadastre-se",
                    color = Color(0xFF17DB2E),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable (onClick = { /* Handle forgot password click */ })
                )
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Divider(modifier = Modifier.weight(1f), color = Color(0x92B1B1B1))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "ou",
                    color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Divider(modifier = Modifier.weight(1f), color = Color(0x92B1B1B1))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0x92B1B1B1))

                ) {
                    Image(painter = painterResource(
                        id = R.drawable.google),
                        contentDescription = "G da Google",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(4.dp, end = 10.dp),

                    )
                    Text(
                        text = "Entre com Google",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 300.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0x92B1B1B1))

                ) {
                    Image(painter = painterResource(
                        id = R.drawable.outlook),
                        contentDescription = "Simbolo do Outlook",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(2.dp, end = 10.dp),

                        )
                    Text(
                        text = "Entre com Outlook",
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun loginScreenPreview() {
    ChatMEDTheme {
        LoginScreen()
    }
}