<h1>Section B: Projects</h1>

**The chosen project is a Java project-management back-end application built as part of the Hyperiondev Software Engineering Bootcamp**. 

Users can:

* Create projects
* Edit projects or people
* View projects or people
* Finalize projects and generate invoices.

To store project information, as well as the information of the persons associated with a project, it makes use of a MySQL database:

* Internally, it uses two `LinkedHashMap`s to avoid constant/unnecessary database access.
* One map contains an image of the database when the app is opened.
* Another map serves as operational map while the user makes changes or views information. 
* At closing, the two maps are compared and any changes are written back to database.<br /><br />

Bear in mind that this project was written as part of learning Java and SQL, so in retrospect more care should have been put into the design, for instance proper use of interfaces to achieve greater decoupling between classes/methods.<br /><br />


### Please follow [this link](https://github.com/J-E-Foster/Java-Project-Manager) to view the project.
