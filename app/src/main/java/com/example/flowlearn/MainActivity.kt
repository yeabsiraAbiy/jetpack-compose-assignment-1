package com.example.flowlearn

import com.example.flowlearn.data.Course
import com.example.flowlearn.ui.theme.FlowLearnTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.flowlearn.ui.screens.CourseListScreen
import com.example.flowlearn.ui.screens.LandingScreen




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowLearnTheme {
                var currentScreen by remember { mutableStateOf(Screen.Landing) }

                val courses = remember {
                    listOf(
                        Course(
                            title = "Introduction to Computer Science",
                            code = "CS101",
                            creditHours = 3,
                            description = "An introductory course covering basic concepts of computer science, programming fundamentals, and problem-solving techniques.",
                            prerequisites = listOf()
                        ),
                        Course(
                            title = "Data Structures and Algorithms",
                            code = "CS201",
                            creditHours = 4,
                            description = "Study of fundamental data structures, algorithms, and their practical applications in programming.",
                            prerequisites = listOf("CS101", "MATH101")
                        ),
                        Course(
                            title = "Operating Systems",
                            code = "CS301",
                            creditHours = 5,
                            description = "Study of operating system concepts, process management, memory management, file systems, and system security.",
                            prerequisites = listOf("CS201", "CS202", "MATH101")
                        ),
                        Course(
                            title = "Mobile Application Development",
                            code = "CS401",
                            creditHours = 5,
                            description = "Comprehensive study of mobile app development, including UI design, data storage, and integration with backend services.",
                            prerequisites = listOf("CS201", "CS301")
                        ),
                        Course(
                            title = "Programming Languages",
                            code = "CS302",
                            creditHours = 3,
                            description = "Study of programming language concepts, syntax analysis, semantics, and different programming paradigms.",
                            prerequisites = listOf("CS201")
                        ),
                        Course(
                            title = "Database Management Systems",
                            code = "CS303",
                            creditHours = 3,
                            description = "Introduction to database concepts, design principles, and SQL programming.",
                            prerequisites = listOf("CS201")
                        )
                    )
                }

                when (currentScreen) {
                    Screen.Landing -> LandingScreen(
                        onContinueClick = { currentScreen = Screen.CourseList }
                    )
                    Screen.CourseList -> CourseListScreen(courses = courses)
                }
            }
        }
    }
}

enum class Screen {
    Landing,
    CourseList
}

