# E-Visa Management Portal

A comprehensive JavaFX-based desktop application for managing electronic visa applications, citizen services, and security operations. This system provides a complete solution for government agencies to handle visa processing, citizen services, and security management in a unified platform.

## 🚀 Features

### Client Features
- **Visa Application Management**: Submit and track visa applications
- **Document Upload**: Upload required documents for visa processing
- **Application Status Tracking**: Real-time status updates for applications
- **Interview Scheduling**: Schedule and manage visa interviews
- **Citizen Services**: Access to various government services
- **Event Registration**: Register for government events and services
- **Assistance Requests**: Submit and track assistance cases
- **Passport Services**: Apply for passport renewal and replacement

### Security Manager Features
- **Security Operations**: Monitor and manage security incidents
- **Incident Reports**: Comprehensive incident reporting and tracking
- **Security Audits**: Generate and manage security audit reports
- **Threat Communications**: Internal threat communication system
- **Control Systems**: Monitor and control security systems
- **Real-time Monitoring**: Live monitoring of security systems

### System Features
- **Role-based Access Control**: Separate interfaces for clients and security managers
- **Data Management**: Comprehensive data storage and retrieval
- **Search and Filter**: Advanced search and filtering capabilities
- **Export Functionality**: Export reports and data in various formats
- **User-friendly Interface**: Modern, intuitive JavaFX interface

## 🛠️ Technology Stack

- **Java 21**: Core programming language
- **JavaFX 21**: User interface framework
- **Maven**: Build and dependency management
- **JUnit 5**: Unit testing framework

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 21** or later
- **Maven 3.6** or later
- **Git** (for cloning the repository)

## 🚀 Installation and Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd 2220898_final_project
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn javafx:run
```

Alternatively, you can run the application using:
```bash
mvn clean javafx:run
```

## 📁 Project Structure

```
2220898_final_project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/finalms3/
│   │   │       ├── models/           # Data models
│   │   │       ├── services/         # Business logic services
│   │   │       ├── utils/            # Utility classes
│   │   │       └── *.java            # Controller classes
│   │   └── resources/
│   │       └── com/example/finalms3/
│   │           └── *.fxml            # FXML layout files
│   └── test/                         # Test files
├── pom.xml                          # Maven configuration
└── README.md                        # This file
```

## 🎯 Usage Guide

### Starting the Application
1. Launch the application using the Maven command
2. The welcome screen will appear with two options:
   - **Client Access**: For visa applicants and citizens
   - **Security Manager**: For security personnel

### Client Dashboard
The client dashboard provides access to:
- **My Application**: Submit and manage visa applications
- **Citizen Services**: Access government services
- **Events**: Register for government events
- **Assistance**: Request assistance and support
- **Passport Services**: Apply for passport services

### Security Manager Dashboard
The security manager dashboard provides access to:
- **Security Operations**: Monitor and manage security incidents
- **Incident Reports**: View and manage incident reports
- **Security Audits**: Generate and review audit reports
- **Threat Communications**: Manage threat communications
- **Control Systems**: Monitor security control systems

## 🔧 Configuration

### Database Configuration
The application currently uses in-memory data storage with sample data. To configure a database:

1. Update the `DataService.java` file
2. Add database connection properties
3. Implement database-specific data access methods

### Application Properties
Key configuration options can be modified in:
- `pom.xml`: Build and dependency configuration
- `HelloApplication.java`: Application startup configuration

## 🧪 Testing

Run the test suite using:
```bash
mvn test
```

## 📊 Sample Data

The application includes sample data for demonstration:
- Sample visa applications
- Security incidents
- Government events
- Assistance cases

## 🔒 Security Features

- **Role-based Access**: Separate interfaces for different user types
- **Data Validation**: Comprehensive input validation
- **Secure Navigation**: Controlled access to different modules
- **Audit Trail**: Track all system activities

## 🚨 Troubleshooting

### Common Issues

1. **JavaFX not found**: Ensure JavaFX is properly included in the classpath
2. **Maven build fails**: Check Java version compatibility
3. **Application won't start**: Verify all dependencies are resolved

### Debug Mode
Run with debug information:
```bash
mvn javafx:run -Djavafx.debug=true
```

## 📈 Future Enhancements

- Database integration (MySQL, PostgreSQL)
- User authentication and authorization
- Email notifications
- Advanced reporting features
- Mobile application support
- API integration capabilities

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- **Student ID**: 2220898
- **Course**: Final Project
- **Institution**: [Your Institution]

## 🙏 Acknowledgments

- JavaFX community for the excellent UI framework
- Maven community for build tools
- Open source contributors for various libraries

## 📞 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation

---

**Note**: This is a demonstration application for educational purposes. For production use, additional security measures, database integration, and proper deployment procedures should be implemented.
