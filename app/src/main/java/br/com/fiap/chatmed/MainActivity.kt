package br.com.fiap.chatmed
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.chatmed.screens.CadastroScreen
import br.com.fiap.chatmed.screens.LoginScreen
import br.com.fiap.chatmed.screens.SignUpScreen
import br.com.fiap.chatmed.ui.theme.ChatMEDTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatMEDTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
                {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "SignUp"
                    )
                    {
                        composable(route = "SignUp"){
                            SignUpScreen(navController)
                        }
                        composable(route = "Login"){
                            LoginScreen(navController)
                        }
                        composable(route = "Cadastro"){
                            CadastroScreen(navController)
                        }

                    }
                }
            }
        }
    }
}

