package br.com.fiap.chatmed
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.chatmed.screens.CadastroScreen
import br.com.fiap.chatmed.screens.LoginScreen
import br.com.fiap.chatmed.screens.SignUpScreen
import br.com.fiap.chatmed.screens.CadastroScreenViewModel
import br.com.fiap.chatmed.ui.theme.ChatMEDTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatMEDTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
                {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "SignUp",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(500)
                            ) + fadeOut(animationSpec = tween(500))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                tween(500)
                            )+ fadeIn(animationSpec = tween(500))
                        }
                    )
                    {
                        composable(route = "SignUp"){
                            SignUpScreen(navController)
                        }
                        composable(route = "Login"){
                            LoginScreen(navController)
                        }
                        composable(route = "Cadastro"){
                            CadastroScreen(CadastroScreenViewModel(),navController)
                        }

                    }
                }
            }
        }
    }
}

