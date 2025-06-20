upadate 6/20/2025</br>

userCotroller.class</br>

This update focuses on extending backend functionality for user management. The frontend (Vue) part has not been updated yet.

The following new methods have been added:

1.User Registration:</br>
regist(HttpServletRequest req, HttpServletResponse resp)
Allows new users to register an account.

2.Check for Duplicate login_id:</br>
checkUserName(HttpServletRequest req, HttpServletResponse resp)
Checks whether a given login_id is already in use.

3.Token Expiration Validation:</br>
checkLogin(HttpServletRequest req, HttpServletResponse resp)
Verifies if the token is still valid.

4.User Soft Deletion:</br>
userDelete(HttpServletRequest req, HttpServletResponse resp)
Soft deletes a user based on the provided user_id.

• The Vue.js frontend has not yet been updated to reflect these changes.</br>
• The current focus is on backend development to ensure all core functionality is complete.

Learning Vue is ongoing, so backend development is being prioritized for now. 

------------------------
This is the backend of a Java Web bulletin board application. The project is built on Tomcat 11.0.6, and Maven is used for dependency management. </br>

The project doesn’t use the Spring framework at this stage. Once the core features are complete.I plan to refactor the project using Spring, time permitting.

*This project is under progressive development. Features and code will be updated incrementally.*

 Technical Notes</br>
	•	This project is not a standalone application — the database files are not included. However, you can refer to the entity classes in the project and attempt to reconstruct the MySQL database schema.</br>
	•	External libraries and plugins used are listed in pom.xml.</br>
	•	The JDBC connection pool is powered by Druid.</br>
	•	The project uses the JBLJavaToWeb plugin（IDEA） to convert Java modules into Web modules.</br>
	•	API testing is done using Postman.</br>
	•	Utility classes and some core code are adapted from the 2023 JavaWeb course by  尚硅谷(a programming education provider in China). Some modifications were made to fit the current versions of dependencies and specific project needs.

 The corresponding Java frontend can be found here: https://github.com/maxPaiin/bulletin_frontend
