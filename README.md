# Airlinesapp
- it simple app that starts with a splash screen to then open to the main view displaying
airlines list. Provide the option to filter this list by airline name, airline id or country
using a search view.
when you select an airline entry will redirect to airline details page.
that show airline details such as name, country, slogan, logo and
clickable website link
and you can add a new airline to the existing list by clicking on FloatingActionButton 
then it shows BottomSheet to enter the airline data

 <img src="https://firebasestorage.googleapis.com/v0/b/yumm-f3ed2.appspot.com/o/WhatsApp%20Image%202021-06-17%20at%207.04.41%20PM%20(3).jpeg?alt=media&token=21a1ace2-30ce-4926-ac27-af2e087d7cc1" alt="Home Screen"/>
 
 <img src="https://firebasestorage.googleapis.com/v0/b/yumm-f3ed2.appspot.com/o/WhatsApp%20Image%202021-06-17%20at%207.04.41%20PM%20(2).jpeg?alt=media&token=8cc420df-2f1f-49c2-8c99-c2e4f06c02f7" alt="Button sheet"/>
 
## Tests
- Unit tests
   
## Other useful features
- Support availability to data in offline mode using room.
- Using MVVM architecture with Repository design pattern.
- Using Retrofit with RX java.

# Getting started
### Script 
1. Download this repository extract and open the folder
2. Run `newproject.sh` script to create a copy with the name you want 
    * Example: `./newproject.sh -p com.example.project -t Project` 
3. On `app/build.gradle`, update the dependencies Android Studio suggests
4. On `theme.xml` & `colors.xml` set your application primary and secondary colors 


And you're ready to start working on your new app.

### Manual
1. Download this repository extract and open the template folder on Android Studio
2. Rename the app package `io.bloco.template`
3. Check if the manifest package was renamed along with the package
4. On `app/build.gradle`, change the applicationId to the new app package
5. On `app/build.gradle`, update the dependencies Android Studio suggests
6. On `string.xml`, set your application name
7. On `theme.xml` & `colors.xml` set your application primary and secondary colors 

And you're ready to start working on your new app.

# Notes
- I am using  Rest APIs from InstantWebtools website.
[nstantWebtools website link](https://www.instantwebtools.net/fake-rest-api#read-airlines)

