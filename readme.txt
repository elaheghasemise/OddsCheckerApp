This application uses Java 1.8 and maven and log4j.

- In order to build the application run the following maven command:
  mvn clean package

- Inorder to run the app, navigate to the jar file directory and run the following command:
   java -jar OddsCheckerApp.jar eventId

- If eventId missed as parameter while running jar file, then message 'Please enter single valid MATCH eventId!'
  will printed in console and program exit.

- If invalid eventId entered, then message 'No odds available for event: eventId' will printed in the console