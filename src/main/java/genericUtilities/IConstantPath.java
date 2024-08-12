package genericUtilities;
/**
 * This interface contains external file paths and JDBC URL
 */
public interface IConstantPath {
String JDBC_URL="jdbc:mysql://localhost:3306/advsel";
String PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/data.properties";
String EXCIL_PATH=System.getProperty("user.dir")
            +"/src/test/resources/VTigerCRMTestData.xlsx";
}
