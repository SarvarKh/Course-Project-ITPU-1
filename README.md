# Course project of Sarvar Khalimov

## Progress report

| Tasks                  | Start Date | End Date  |
|------------------------|------------|-----------|
| Gathering requirements | 22-May-23  | 24-May-23 |
| Entity Design          | 25-May-23  | 29-May-23 |
| Data Access Layer      | 1-June-23  | 2-June-23 |
| Service Layer          | 3-June-23  | 4-June-23 |
| Controller Layer       | 5-June-23  | 6-June-23 |

## Screenshot from the interactive console

<div style="display: flex; flex-wrap: wrap">
<div align="center">
  <img src="image/01_console.png?raw=true" width="90%" height="auto"/>
  <img src="image/02_console.png?raw=true" width="90%" height="auto"/>
</div>
</div>


## Getting Started
To get started with this project, follow these steps:

- Clone the repository to your local machine.
- Install in pom.xml file.
- Run the application using your IDEA's run button on Main class.
- Console window will be opened.
- you can play around with this interactive console to retrieve all inventories or by their parameters;

## Features
This project includes the following features:

- Parsing inventories (Bedclothing and Dish .csv files)
- Mapping parsed Strings from .csv files to the corresponding DTO entities
- Retrieve all inventories
- Retrieve all inventories by color and inventory type
- Retrieve all inventories by price (min, max) and inventory type

## Testing
- Dish and Bedclothing mapRow methods - unit tested
- Inventory DAO methods - unit tested

## Technologies Used
This project was built using the following technologies:

- Java 17.0.2
- Maven
- com.opencsv 5.7.1

## Authors

👤 **Sarvar Khalimov**

- GitHub: [SarvarKh](https://github.com/SarvarKh)
- Twitter: [KhalimovSarvar](https://twitter.com/KhalimovSarvar)
- LinkedIn: [Sarvar-Khalimov](https://www.linkedin.com/in/sarvar-khalimov/)


## Contributing
If you would like to contribute to this project, please follow these steps:

- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes and commit them.
- Push your changes to your fork.
- Submit a pull request.

## Show your support
Give a ⭐️ if you like this project!

## License
This project is [MIT](./MIT.md) licensed.
