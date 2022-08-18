<!-- LOGO -->
<br />
<h1>
<p align="center">
  <img src="https://i.imgur.com/SN9eLGd.png" alt="Logo" width="360" height="120">
  <br>
</h1>


# <p align="center">Personal Anime Watchlist Directory - By Charles Cairney </p>

This repo is for the creation of a personal hobby web application for QA. Here I have choosen to build a personal anime watchlist directory that allows users to actively read, create, update and delete entries into their personal watchlist to keep track of their proggress on shows they are currently watching/intend to watch.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system including maven packaging and how the frontend will be loaded once the JAR has been executed.

### Required Prerequisites:
What things you need to install the software and how to install them:<br>
<ul>
	<li>You will need the the Java SE Development kit which can be found here  <br>https://www.oracle.com/java/technologies/downloads/ </li> <br>
	<li>You will also need a version of MySQL Community including MySQL Workbench  <br>https://dev.mysql.com/downloads/windows/installer/8.0.html </li> <br>
</ul>

### Extra Prerequisites (if you would like to alter the program):<br>
<ul>
	<li>You wil need a version of gitbash for terminal access <br>https://git-scm.com/downloads </li><br>
	<li>You will need spring boot IDE for API alterations <br>https://spring.io/tools </li><br>
	<li>You will need VS code for any CSS, HTML or Javascript changes <br>https://code.visualstudio.com/download </li><br>
	<li>You will need to have Apache Maven for testing  <br>https://maven.apache.org/download.cgi </li><br>
 	<li>- With Maven you will need two dependencies: </li><br>
         	<ul>
			<li> JUnit = https://mvnrepository.com/artifact/junit/junit </li><br>
        		<li> Mockito = https://mvnrepository.com/artifact/org.mockito/mockito-core </li><br>
		</ul>
</ul>

## Installing

Here is how to acquire and get the program running: <br>
```
STEP01:
Clone the Repo into a safe location on your personal computer.
```
```
STEP02:
In the Root Folder HobbyWebApplication-Project
 - Open CMD or GitBash
 - Type "java -jar JuneEnableSpring-0.0.1-SNAPSHOT.jar"
 - Now the application will be running in the background and if you wish to stop the application from running. Go back to the CMD or gitbash terminal, make sure the window is active and then click CTRL-C.
```
```
STEP03:
Now the application is running in the background
 - Open Chrome Browser
 - Type "localhost8080" in URL
 - Enjoy!
```
## Example of Build

Step01: Starting up the Jar<br>
<p align="center">
  <img src="https://i.imgur.com/wwGG9aL.png" alt="Jar Running">
  <br>


Step02: Moving to the localhost8080 in the URL<br>
<p align="center">
  <img src="https://i.imgur.com/vz5K9OT.png" alt="Moved to localhost8080">
  <br>


Step03: Landing Page<br>
<p align="center">
  <img src="https://i.imgur.com/2MCkJw8.png" alt="Landing Page">
  <br>
  
Step04: Now enter the anime details in the forum and click "Create Anime"<br>
<p align="center">
  <img src="https://i.imgur.com/eafkoMi.png" alt="Entry Details">
  <img src="https://i.imgur.com/gygUd8R.png" alt="populated">
  <br>


## Testing - How to run them
Coverage: 87%

Once all Prerequisites have been complete you gain access to the testing feature through the src/test/java.<br>
- Select folder with right click.
- Select "Coverage As"
- Select "JUnit test"
This will run all the tests and generate a coverage table indicating how much of the code has been covered in the testing and what percentage passed/failed/errored.

### Unit Tests: 

Unit testing is a testing method where you test smaller isolated pieces of code that can be used logically by setting up condition to use before testing.<br>
An example of where unit testing was used in our project was for the testing the anime controller method of create, here the unit testing was applied by using Mockito to "mock" the actions of the methods dependences. Shown below the create method relied on Anime service therefore Mocktio mocked what to do when the method called the service.create.<br>

```
@Test
	void createTest() throws Exception {
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		//Create an Object to check result
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.create(entry)).thenReturn(result);
		
		mvc.perform(post("/Anime/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
  
```
```
@Test
	void updateTest() throws Exception {
		//Create an Object to check result
		Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.update(1L, result)).thenReturn(result);
		
		mvc.perform(put("/Anime/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(resultAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
```
```
@Test
	public void testGetAll() {
		
		//Create objects of Anime
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
			
		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
```



### Integration Tests: 
Integration testing is where you test multiple combined components of a application to see if they logically work together and produce the correct outcome.<br>
Here we used Integration testing also for our controller and service classes.<br>

```
@Test
	public void createTest() throws Exception {
		//Create an Object for posting
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		//Create an Object to check result
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/Anime/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
```
```
@Test
	public void readAllTest() throws Exception {
		
		//Create a list to cehck the output of readAll
		List<Anime> result = new ArrayList<>();
		//Add the single entry to the list
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
		
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
```
```
@Test
	public void updateTest() throws Exception {
		//Create an Object for posting
				Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
				String resultAsJSON = mapper.writeValueAsString(result);
				
				mvc.perform(put("/Anime/update/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(resultAsJSON))
					.andExpect(content().json(resultAsJSON));
	}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](https://github.com/) for versioning.

## Authors

* **Charles Cairney** - *Final Product* - [CharlesCairney](https://github.com/CSCairney)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* *Trainer* - [AnoushLowton](https://github.com/ALowtonQA)
* *Trainer* - [JordanBenBelaid](https://github.com/jordanbenbelaid)
* *Trainer* - [Edward Reynolds](https://github.com/Edrz-96)
* *Trainer* - [Piers Barber](https://github.com/PCMBarber)
* *Testing Developer* - [JUnit](https://junit.org/junit5/docs/current/user-guide/#running-tests)
