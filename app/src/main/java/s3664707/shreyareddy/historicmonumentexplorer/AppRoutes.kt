package s3664707.shreyareddy.historicmonumentexplorer

sealed class AppRoutes(val route: String) {
    object Splash : AppRoutes("splash_route")
    object Login : AppRoutes("login_route")
    object ForgotPassword : AppRoutes("forgot_route")
    object Register : AppRoutes("register_route")

}