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
