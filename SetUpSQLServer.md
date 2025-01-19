## How to connect SQLServer
### 1. Set up `SQL Server 20xx Configuration Manager`
? If you can not find this app? Type in Search: `SQLServerManager16.msc` (It's the same)
![image](https://github.com/user-attachments/assets/dc564d6c-cbce-4b4f-9be3-37e496d9f138)
![image](https://github.com/user-attachments/assets/3c9a31f8-236d-4330-a463-3efce99b07cf)
![image](https://github.com/user-attachments/assets/8ca494c4-4e77-4bd5-a49f-953b80a6f786)
![image](https://github.com/user-attachments/assets/d6be4f9d-25c0-4c72-85b7-ec8cf24d0c3f)
![image](https://github.com/user-attachments/assets/2b49df66-c26f-49f1-9a71-b9448a1cf8e1)
2. Set up `SQL Server Management Studio 2X`
![image](https://github.com/user-attachments/assets/7d02e45d-f170-4116-b837-7edadbd569f0)
![image](https://github.com/user-attachments/assets/bcd7153e-0314-4226-8f72-f974550ce1cc)
![image](https://github.com/user-attachments/assets/8fb9ccfb-4118-4734-bb09-4d74c15ec334)
![image](https://github.com/user-attachments/assets/4c42ae64-fe28-4905-b754-49ee839d343e)
![image](https://github.com/user-attachments/assets/f29377f8-6caa-4974-a0a5-e6b5967f92c3)
![image](https://github.com/user-attachments/assets/e1a4d063-4c57-4361-aa32-d8361218871d)
![image](https://github.com/user-attachments/assets/d5541228-0f59-4117-be5f-ae9e2e598717)
![image](https://github.com/user-attachments/assets/acfa3a91-0b4c-4836-8379-4531a502d0c3)
![image](https://github.com/user-attachments/assets/aa5db84b-4d83-4145-b394-e74a7f5a8f86)
![image](https://github.com/user-attachments/assets/5616c5c8-35ca-4bab-b8ba-fcecd247f968)
![image](https://github.com/user-attachments/assets/2416538f-5dd3-4b98-a1f6-97af4351db0e)
3. Connect in `Java`
```
import java.sql.*;
import java.util.*;
public class SQLUtils {

    private final static String url = "jdbc:sqlserver://MINHDEV\\SQLEXPRESS:1433;databaseName=DB_PRJ301;encrypt=true;trustServerCertificate=true;zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final static String user = "user";
    private final static String password = "1234";
    private final static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
```















