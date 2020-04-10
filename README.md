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



