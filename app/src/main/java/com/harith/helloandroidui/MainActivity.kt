package com.harith.helloandroidui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.harith.helloandroidui.ui.theme.HelloAndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Status bar appearance
        window.statusBarColor = Color.White.hashCode()
        WindowCompat.getInsetsController(window, window.decorView)
            ?.isAppearanceLightStatusBars = true

        setContent {
            HelloAndroidUITheme {
                AppShell()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppShell() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),

        topBar = {
            TopAppBar(
                title = { Text("HelloAndroid") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1AA2AB),  // <-- AppBar background color (change here like CSS)
                    titleContentColor = Color.White       // <-- AppBar text color
                )
            )
        }
    ) { innerPadding ->
        MainScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),                 // <-- Change page padding here
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)               // <-- Change logo size here
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Welcome to Android Development!",
            style = MaterialTheme.typography.titleLarge,   // <-- Larger font size
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // -------- BUTTON STYLING HERE (CSS-like) --------
        Button(
            onClick = {
                Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1AA2AB),   // <-- Button background
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(1.dp),   // <-- Button border radius (1dp ≈ 1px)
            modifier = Modifier
                .height(48.dp)                  // <-- Button height
                .width(160.dp)                  // <-- Button width
        ) {
            Text("Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    HelloAndroidUITheme {
        AppShell()
    }
}
