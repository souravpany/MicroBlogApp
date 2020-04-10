# MicroBlogApp
</br>
The Micro blogging app will have to show the 3 types of objects Users, Posts and comments.
</br>
The app will be a read only App that will read the data from the publicly available Rest API and render
the page.
</br>
The App will have 3 sections “Users section”
</br>

● Users Section
</br>
Which will list all the users in the system
</br>
● User Profile Section 
</br>
Which will list the user details and posts by that particular user
</br>
● Post Detail Section
</br>
Which will list the post details and their comments

When the app is opened the Users section should be shown to the user.
</br>
# Users Section 
It should list all the users in the system. There should be scrollable list in the activity,
where each element in the list should be 1 username. On clicking the user name the app should
transition to the User Profile Section
</br>
# User Profile Section
The section will list all the fields of the User Object and the list of posts by the user.
On clicking a Post element, the app should transition to the Post Detail Section
</br>
# Post Detail Section
It will list the Post title, Post Body and all the Post Comments

Rest Resources and their fields to be displayed
</br>

# User
● Id
</br>
● Name
</br>
● Email
</br>

# Post
● Id
</br>
● UserId
</br>
● TItle
</br>
● Body
</br>

# Comments
● Id
</br>
● PostId
</br>
● Name
</br>
● Email
</br>
● Body

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Dagger 2](https://dagger.dev/) - Dependency Injection Framework
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

# Package Structure
    
    com.android.microblogapp    # Root Package
    .
    ├── data                # For data handling.
    │   ├── remote          # Remote Data Handlers     
    |   │   ├── api         # Retrofit API for remote end point.
            ├── response    # API Response. 
        └── model           # POJO classes  
    │   └── repository      # Single source of data.
    |
    ├── model               # Model classes
    |
    ├── di                  # Dependency Injection             
    │   ├── builder         # Activity Builder
    │   ├── component       # DI Components       
    │   └── module          # DI Modules
    |
    ├── ui                  # Activity/View layer
    │   ├── base            # Base View
    │   ├── userssection    # User Section Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   ├── viewmodel   # ViewHolder for RecyclerView   
    │   └── usersprofile    # User Profile Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   ├── viewmodel   # ViewHolder for RecyclerView
        └── postdetails    # Post Details Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   ├── viewmodel   # ViewHolder for RecyclerView
    |
    └── utils               # Utility Classes / Common classes / Rx / display

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)



