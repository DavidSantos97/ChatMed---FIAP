package br.com.fiap.chatmed.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmed.R
import br.com.fiap.chatmed.ui.theme.ChatMEDTheme

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen() {

    var telefoneState = remember {
        mutableStateOf("")
    }
    var docState = remember {
        mutableStateOf("")
    }
    var nomeState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }
    var chekedState = remember {
        mutableStateOf(false)
    }
    val senhaVisibility = remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,

        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ){
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
                        text = "Cadastro",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                }

            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 60.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    value = nomeState.value,
                    onValueChange = { nomeState.value = it},
                    placeholder = {
                        Box(modifier = Modifier.fillMaxWidth(),
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = "Icone Pessoa",
                                tint = Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                text = "Nome completo",
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
                    maxLines = 1
                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    value = docState.value,
                    onValueChange = {docState.value = it.take(11)},
                    placeholder = {
                        Box(modifier = Modifier.fillMaxWidth()
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.doc),
                                contentDescription = "Icone documento",
                                tint = Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                text = "CPF",
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1
                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    value = telefoneState.value,
                    onValueChange = { telefoneState.value = it },
                    placeholder = {
                        Box(modifier = Modifier.fillMaxWidth()
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.telefone),
                                contentDescription = "Icone telefone",
                                tint = Color.Gray,
                                modifier = Modifier.size(25.dp)
                            )
                            Text(
                                text = "Telefone",
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    maxLines = 1

                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 15.dp, end = 15.dp)
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
                        .padding(top = 30.dp, start = 15.dp, end = 15.dp)
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
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Checkbox(
                    checked = chekedState.value,
                    onCheckedChange = {chekedState.value = it},
                    modifier = Modifier.padding(horizontal = 8.dp),
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color(0xFF17DB2E),
                        checkedColor = Color.White,
                        uncheckedColor = Color.Gray
                    )
                )
                Column {
                   val text = buildAnnotatedString {
                        append("I agree to the healtcare ")
                        withStyle(style = SpanStyle(color = Color(0xFF17DB2E))) {
                            addStringAnnotation(
                                tag = "LINK",
                                annotation = "https://www.google.com.br",
                                start = length,
                                end = length + 16
                            )
                            append("Terms of Service ")
                        }
                        append("and ")
                        withStyle(style = SpanStyle(color = Color(0xFF17DB2E))) {
                            addStringAnnotation(
                                tag = "URL",
                                annotation = "https://www.google.com.br",
                                start = length,
                                end = length + 21
                            )
                            append("Privacy Policy ")
                        }
                        append(".")
                    }
                    ClickableText(text = text,
                        onClick = {offset ->
                            val annotations = text.getStringAnnotations(
                                tag = "URL",
                                start = offset,
                                end = offset
                            )
                            if (annotations.isNotEmpty()) {
                                val url = annotations.first().item
                                // Abrir a URL
                            }
                        },
                        modifier = Modifier.padding(start = 8.dp)

                    )
                }


            }
            Spacer(modifier = Modifier.padding(10.dp))
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
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Já possui cadastro ?  ",
                    fontSize = 15.sp
                )
                Text(text = "Entre",
                    color = Color(0xFF17DB2E),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable (onClick = { /* Handle forgot password click */ })
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun cadastroScreenPreview() {
    ChatMEDTheme {
        CadastroScreen()
    }
}