# MicroBlogApp
The Micro blogging app will have to show the
3 types of objects Users, Posts and comments.

#The app will be a read only App that will read the data from the publicly available Rest API and render
the page.

#The App will have 3 sections “Users section”
● Users Section. Which will list all the users in the system
● User Profile Section. Which will list the user details and posts by that particular user
● Post Detail Section. Which will list the post details and their comments

When the app is opened the Users section should be shown to the user.

#Users Section
Users section should list all the users in the system. There should be scrollable list in the activity,
where each element in the list should be 1 username. On clicking the user name the app should
transition to the User Profile Section

#User Profile Section
The User profile section will list all the fields of the User Object and the list of posts by the user.
On clicking a Post element, the app should transition to the Post Detail Section

#Post Detail Section
The Post Detail section will list the Post title, Post Body and all the Post Comments


#Rest Resources and their fields to be displayed

#User
● Id
● Name
● Email


#Post
● Id
● UserId
● TItle
● Body

#Comments
● Id
● PostId
● Name
● Email
● Body



