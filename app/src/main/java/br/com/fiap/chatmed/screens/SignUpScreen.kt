package br.com.fiap.chatmed.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmed.R
import br.com.fiap.chatmed.ui.theme.ChatMEDTheme

@Composable
fun LoginScreen(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Column (
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_preto),
                    contentDescription = "Logo ChatMED"
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Helthcare",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1B44AC),
                    fontWeight = FontWeight.Bold

                )

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 1.dp),
                    text = "Vamos lá!",
                    fontSize = 29.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

                )

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(top = 1.dp),
                    text = "Faça o login e cuide da sua saúde com a gente.",
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold

                )

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(width = 200.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF17DB2E)
                    )
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                }

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(width = 200.dp, height = 48.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFF17DB2E))

                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0xFF17DB2E),
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