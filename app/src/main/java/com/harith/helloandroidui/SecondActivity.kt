package com.harith.helloandroidui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harith.helloandroidui.ui.theme.HelloAndroidUiTheme

@OptIn(ExperimentalMaterial3Api::class)   // ✅ Fix for warning
class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloAndroidUiTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("First Activity") },
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                ) { innerPadding ->

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        var name by remember { mutableStateOf("") }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            Text(
                                text = "Welcome to Second Activity!",
                                style = MaterialTheme.typography.headlineMedium
                            )

                            TextField(
                                value = name,
                                onValueChange = { name = it },
                                label = { Text("Enter your name") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Button(
                                onClick = {
                                    val message = if (name.isBlank()) {
                                        "Hello! Please enter your name."
                                    } else {
                                        "Hello, $name!"
                                    }
                                    Toast.makeText(
                                        this@SecondActivity,
                                        message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Show Greeting")
                            }
                        }
                    }
                }
            }
        }
    }
}
