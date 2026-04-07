# Spring Contacts API

## Functional specificities

This application allows a logged-in user to add, delete, update, or search for a contact, whether categorized or not (professional, personal, etc.). An unauthenticated user can have access to the site's homepage, but it will only display a sample set of fictitious contacts.

A contact is defined by : 

- last name
- first name
- email address
- phone number
- address

A category is defined by its name.

## Use cases
### UML diagram
<img width="700" height="460" alt="image" src="https://github.com/user-attachments/assets/e93888cf-a700-47cc-8ea3-e68e49d570ba" />

### Display index page (unauthenticated user)
| Element  | Description |
| ------------- | ------------- |
| Actors  | Unauthentified user  |
| Pre-condition  | None  |
| Main scenario  | The API displays the index page with a list of fake contacts  |
| Secondary scenario  | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The index page is displayed.  |
### Display index page (authenticated user)
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | None  |
| Main scenario  | The API displays the index page with the list of the user's contacts  |
| Secondary scenario  | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The index page is displayed.  |
### Add a contact
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | User must be authenticated  |
| Main scenario  | The user clics on he Add contact option in the menu  |
|   | The API displays a form for the user to fill  |
|   | The user fills the form and clicks on Submit  |
|   | The API returns to the contacts list and displays a success message  |
| Secondary scenario  | The form was not correctly filled : the API stays on the form and displays a message indicating where are the problems.  |
|   | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The contact has been added and the API displays the contacts list  |
### Display a contact
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | User must be authenticated  |
| Main scenario  | The user clicks on a contact in the contacts list  |
|   | The API displays a page with the contact's informations  |
| Secondary scenario  | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The contact is displayed in the API  |
### Edit a contact
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | User must be authenticated  |
| Main scenario  | The user clics on he Edit contact option in the same line as the contact to be edited  |
|   | The API displays a form with the contact's informations for the user to edit  |
|   | The user modify the form and clicks on Submit  |
|   | The API returns to the contacts list and displays a success message  |
| Secondary scenario  | The form was not correctly filled : the API stays on the form and displays a message indicating where are the problems.  |
|   | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The contact has been edited and the API displays the contacts list  |
### Delete a contact
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | User must be authenticated  |
| Main scenario  | The user clicks on the Delete contact option in the same line as the contact to be deleted  |
|   | The API displays a form with the contact's informations for the user to edit  |
|   | The user modify the form and clicks on Submit  |
|   | The API deletes the contact, displays a success message and displays the contacts list  |
| Secondary scenario  | An error occurred in the API : an error message is displayed.  |
| Post-condition  | The contact has been deleted and the API displays the contacts list  |
### Search a contact
| Element  | Description |
| ------------- | ------------- |
| Actors  | Authenticated user  |
| Pre-condition  | User must be authenticated  |
| Main scenario  | The user enters a keyword in the search form  |
|   | The API displays a list of contacts matching the keyword  |
| Secondary scenario  | An error occurred in the API : an error message is displayed.  |
|   | No contact found : the API displays this message.  |
| Post-condition  | A list of matching contacts is displayed by the API  |

## Class diagram
<img width="810" height="190" alt="image" src="https://github.com/user-attachments/assets/c891e3b0-07fa-4d7b-a311-368a94df6a71" />

## Mock-up
<img width="1015" height="698" alt="image" src="https://github.com/user-attachments/assets/226a82ea-2fa5-45cd-87a4-be1da3346420" />
