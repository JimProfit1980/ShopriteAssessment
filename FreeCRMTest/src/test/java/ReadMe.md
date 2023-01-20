ReadMe file to assist you in running the tests in the Framework
You need an IDE to run the software:
 	Eclipse Download
	Java downloaded and setup java and system variables, see the link below go and follow the steps:
		•https://www.java.com/en/download/help/path.html
	Downloaded Maven and setup java and system variables, follow the link and steps:
		•https://www.tutorialspoint.com/maven/maven_environment_setup.htm
		Here is also a YouTube video that assists in this process:
		•https://www.youtube.com/watch?v=km3tLti4TCM
		
	Remember to double check that Java and Maven is installed:
		In the cmd line type to check if Java is installed and environment variables setup:	
		•java –version
			You will get the version of java and some more information
		•mvn –version
			You will get the maven version and some more information
		
	Get the repository from GitHub
		Here is the repo link:
			
			Open Gitbash and make sure you are in the directory where you want to pull the repo use the command:
				git clone https://github.com/JimProfit1980/ShopriteAssessment.git
				Once done open up your IDE to view the POM Framework
				All tests and Page Object pages inherit from the TestBase class and the configuration is in the properties.config file
				
				2 Tests are created
				1 Front End 
				1 Rest Assured API


	There are numerous ways of running the Framework:
		1.Open your IDE and go to the tests:
			a.ShopriteTests/src/test/java/com/crm/qa/testcases
			b.	Right click the testNg.xml file and the tests will run
			c.  Right click on the test cases package and run as Testng
			c.	Go to where you are running your project the mvn command in the command line make sure you are in the project and the directory where the pom.xml file
i.	It will fail otherwise
ii.	Type any 2 maven commands
1.	mvn compile to compile and run the tests
2.	mvn test to run the tests
iii.	 will see all the progress of the command in the command line
 
Open the you Eclipse IDE and go to the test-output folder and right click on the index.html file and go to properties so its shows the path of the file. Click on the path as shown below and go to the actual file:

 
Right click and select the browser you are going to use, I chose Google Chrome:

 Go to the TestNg report and view.
 
 Go to this path to view the "To run the Framework there is some installations that needs to be done first.pdf" file that has pictures to help you in this setup process

 

