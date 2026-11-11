package s3664707.shreyareddy.historicmonumentexplorer

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import s3664707.shreyareddy.historicmonumentexplorer.ui.theme.HistoricMonumentTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current

            HistoricMonumentTheme () {
                MyAppNavGraph()
            }
        }
    }
}


@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(3000)


            navController.navigate(AppRoutes.Login.route) {
                popUpTo(AppRoutes.Splash.route) {
                    inclusive = true
                }
            }



    }

    SplashScreenDesign()
}

@Composable
fun SplashScreenDesign() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Historic Monument\nExplorer",
                color = colorResource(id = R.color.p1),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 4.dp)

            )


            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(16.dp),

                )
            {
                Image(
                    modifier = Modifier.size(200.dp, 200.dp),
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = "App Icon",
                )


            }
            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = "By",
                color = colorResource(id = R.color.p3),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Shreya Reddy",
                color = colorResource(id = R.color.p3),
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )


        }
    }

}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenDesign()
}


@Composable
fun MyAppNavGraph() {
    val navController = rememberNavController()

    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Splash.route
    ) {
        composable(AppRoutes.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(AppRoutes.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(AppRoutes.Register.route) {
            SignUpScreen(navController = navController)
        }



    }

}