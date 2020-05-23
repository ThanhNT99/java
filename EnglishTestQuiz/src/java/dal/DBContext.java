/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Answer;
import model.ClientTest;
import model.Question;
import model.Test;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Admin
 */
public class DBContext {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "EnglishWeb";
    public static final String INTEGRATED_SECURITY = "false";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";

    /**
     * Get connection to MSSQL Server
     *
     * @return Connection
     */
    public static Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME
                + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";"
                + "integratedSecurity=" + INTEGRATED_SECURITY + ";";



        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Where is your MSSQL JDBC Driver?");
            return null;
        }
        System.out.println("MSSQL JDBC Driver Registered!");

        Connection con = null;
        try {
            con = DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return con;
        }
        return con;
    }

    public ArrayList<Account> getAllAccount() {
        DBContext context = new DBContext();
        String sql = "SELECT        Account.*, Role.roleid, Feature.servletpath\n"
                + "FROM            Account INNER JOIN\n"
                + "                         Role_Account ON Account.username = Role_Account.username INNER JOIN\n"
                + "                         Role ON Role_Account.roleid = Role.roleid INNER JOIN\n"
                + "                         Role_Feature ON Role.roleid = Role_Feature.roleid INNER JOIN\n"
                + "                         Feature ON Role_Feature.servletpath = Feature.servletpath";

        ArrayList<Account> arr = new ArrayList<>();
        PreparedStatement statement;
        try {
            Connection connection = context.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int roleid = rs.getInt("roleid");
                String servletpath = rs.getString("servletpath");
                Account a = isExistedinArr(arr, username);
                if (a == null) {
                    arr.add(new Account(username, password, roleid, servletpath));
                } else {
                    a.setServletpath(servletpath);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Question> getQuestionsByFilter(int testid, int questionid, String question, String option1, String option2, String option3, String correct) {
        Connection connection = getConnection();
        ArrayList<Question> questions = new ArrayList<>();
        try {
            String sql = "select * from Question\n"
                    + "where 1=1";

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int countParams = 0;

            if (testid != -1) {
                sql += " AND testid = ? ";
                countParams++;
                Object[] values = {"INT", testid};
                parameters.put(countParams, values);
            }
            if (questionid != -1) {
                sql += " AND testid = ? ";
                countParams++;
                Object[] values = {"INT", questionid};
                parameters.put(countParams, values);
            }

            if (!question.equals("")) {
                sql += " AND question like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", question};
                parameters.put(countParams, values);
            }

            if (!option1.equals("")) {
                sql += " AND option1 like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", option1};
                parameters.put(countParams, values);
            }

            if (!option2.equals("")) {
                sql += " AND option2 like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", option2};
                parameters.put(countParams, values);
            }

            if (!option3.equals("")) {
                sql += " AND option3 like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", option3};
                parameters.put(countParams, values);
            }

            if (!correct.equals("")) {
                sql += " AND correct like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", correct};
                parameters.put(countParams, values);
            }

            PreparedStatement statement = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer key = entry.getKey();
                Object[] value = entry.getValue();
                switch (value[0].toString()) {
                    case "INT":
                        statement.setInt(key, (int) value[1]);
                        break;
                    case "STRING":
                        statement.setString(key, value[1].toString());
                        break;
//                    case "DATE": statement.setDate(key, (Date)value[1])
//                            ; break;
                }

            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestionID(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setCorrect(rs.getString("correct"));
                q.setTestID(rs.getInt("testid"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    public boolean deleteTest(int testid) {
        String query = "delete  from Question\n"
                + "where testid=?\n"
                + "delete from Test\n"
                + "where id = ?;";
        int isCheck = 0;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, testid);
            statement.setInt(2, testid);
            isCheck = statement.executeUpdate(); //trả về số lượng record bị ảnh hưởng
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return isCheck > 0;
    }

    public ArrayList<Test> getAllTestsByFilter(int testid, String name, String usercreated) {
        Connection connection = getConnection();
        ArrayList<Test> tests = new ArrayList<>();
        try {
            String sql = "select * from Test where 1=1";

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int countParams = 0;

            if (testid != -1) {
                sql += " AND id = ? ";
                countParams++;
                Object[] values = {"INT", testid};
                parameters.put(countParams, values);
            }

            if (!name.equals("")) {
                sql += " AND name like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", name};
                parameters.put(countParams, values);
            }

            if (!usercreated.equals("")) {
                sql += " AND usercreated like '%'+ ? + '%' ";
                countParams++;
                Object[] values = {"STRING", usercreated};
                parameters.put(countParams, values);
            }

            PreparedStatement statement = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer key = entry.getKey();
                Object[] value = entry.getValue();
                switch (value[0].toString()) {
                    case "INT":
                        statement.setInt(key, (int) value[1]);
                        break;
                    case "STRING":
                        statement.setString(key, value[1].toString());
                        break;
//                    case "DATE": statement.setDate(key, (Date)value[1])
//                            ; break;
                }

            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setTestID(rs.getInt("id"));
                test.setName(rs.getString("name"));
                test.setUsercreated(rs.getString("usercreated"));
                tests.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tests;
    }

    public boolean isExistedTestID(int testID) {
        ArrayList<Test> tests = getAllTestsByFilter(-1, "", "");
        for (Test test : tests) {
            if (test.getTestID() == testID) {
                return true;
            }
        }
        return false;
    }

    public boolean insertTest(int id, String name, String usercreated) {
        String sql = "insert into Test\n"
                + "values (?,?,?)\n";
        int isCheck = 0;
        Connection connection = getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, usercreated);
            isCheck = ps.executeUpdate(); //trả về số lượng record bị ảnh hưởng
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return isCheck > 0;
    }

    public Account isExistedinArr(ArrayList<Account> a, String username) {
        for (Account account : a) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        Connection connection = getConnection();
        String sql = "SELECT        Account.*, Role.roleid, Feature.servletpath\n"
                + "FROM            Account INNER JOIN\n"
                + "                         Role_Account ON Account.username = Role_Account.username INNER JOIN\n"
                + "                         Role ON Role_Account.roleid = Role.roleid INNER JOIN\n"
                + "                         Role_Feature ON Role.roleid = Role_Feature.roleid INNER JOIN\n"
                + "                         Feature ON Role_Feature.servletpath = Feature.servletpath\n"
                + "\n"
                + "where Account.username = ? and Account.password = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Account a = new Account(username, password);
                a.setRoleid(rs.getInt("roleid"));
                a.setServletpath(rs.getString("servletpath"));
                while (rs.next()) {
                    a.setServletpath(rs.getString("servletpath"));
                }
                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isExistedUsername(String username) {
        DBContext db = new DBContext();
        ArrayList<Account> arr = db.getAllAccount();
        for (Account account : arr) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean createAnAccount(String username, String password, int roleid) {
        String sql = "insert into Account\n"
                + "values (?,?)\n"
                + "insert into Role_Account\n"
                + "values (?, ?)";
        int isCheck = 0;
        Connection connection = getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setInt(4, roleid);
            isCheck = ps.executeUpdate(); //trả về số lượng record bị ảnh hưởng
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return isCheck > 0;
    }

    public boolean insertQuestion(int testid, int id, String question, String option1, String option2, String option3, String correct) {
        String sql = "insert into Question\n"
                + "values (?,?,?,?,?,?,?)\n";
        int isCheck = 0;
        Connection connection = getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, testid);
            ps.setInt(2, id);
            ps.setString(3, question);
            ps.setString(4, option1);
            ps.setString(5, option2);
            ps.setString(6, option3);
            ps.setString(7, correct);
            isCheck = ps.executeUpdate(); //trả về số lượng record bị ảnh hưởng
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return isCheck > 0;
    }

    public void ImportExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //apache poi
        if (!pathFile.equals("")) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(pathFile);
                HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(fis));
                Sheet sheet = wb.getSheetAt(0);
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String question = row.getCell(1).getStringCellValue();
                    String option1 = row.getCell(2).getStringCellValue();
                    String option2 = row.getCell(3).getStringCellValue();
                    String option3 = row.getCell(4).getStringCellValue();
                    String correct = row.getCell(5).getStringCellValue();
                    new DBContext().insertQuestion(testid, id, question, option1, option2, option3, correct);
                }
                request.setAttribute("msg", "Successfully");
                //   request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
            } catch (FileNotFoundException ex) {
                request.setAttribute("msg", ex.getMessage());
            } catch (IOException ex) {
                request.setAttribute("msg", ex.getMessage());
            }
        }
    }

    static String pathFile = "";
    static int testid = -1;

    public static void UploadSingleFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check that we have a file upload request (enctype="multipart/form-data")
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        DBContext db = new DBContext();
        if (!isMultipart) {
            request.setAttribute("msg", "not have (enctype= \"multipart/form-data\")");
        } else {
            final String address = "D:\\";
            final int maxmemorysize = 3 * 1024 * 1024; //3MB
            final int maxrequestsize = 50 * 1024 * 1024; //50MB
            // Create a factory for disk-based file items (tạo bộ nhớ tạm lưu file upload)
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //set nơi chứa vùng nhớ tạm
            factory.setRepository(new java.io.File(System.getProperty("java.io.tmpdir")));
            //Sets the directory used to temporarily store files that are larger than the configured size threshold.
            //set size vùng nhớ tạm mà có thể chứa kích thước file lớn hơn size vùng nhớ
            factory.setSizeThreshold(maxmemorysize);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(maxrequestsize);

// Parse the request
            try {

                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                Iterator<FileItem> iter = items.iterator();
                String name = null, testID = null, usercreated = null;
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (!item.isFormField()) {
                        String fileName = (new File(item.getName())).getName();
                        pathFile = address + File.separator + fileName;
                        File uploadedFile = new File(pathFile);
                        try {
//                            boolean isExistedFile = uploadedFile.exists();
//                            if (!isExistedFile) {
                            item.write(uploadedFile);
                            request.setAttribute("msg", "Upload file successfully");
                            request.setAttribute("pathFile", pathFile);
//                            } else {
//                                request.setAttribute("msg", "File is existed. Please check again!");
//                            }

                        } catch (Exception ex) {
                            request.setAttribute("msg", ex.getMessage());
                            request.getRequestDispatcher("/view/entity/admin/UploadFile.jsp").forward(request, response);
                        }
                    } else {
                        if (item.getFieldName().equals("testid")) {
                            testID = item.getString();
                        }
                        if (item.getFieldName().equals("name")) {
                            name = item.getString();
                        }
                        if (item.getFieldName().equals("usercreated")) {
                            usercreated = item.getString();
                        }

                        if (db.isExistedTestID(Integer.parseInt(testID))) {
                            request.setAttribute("msg", "Test ID is existed. Please check again");
                            request.getRequestDispatcher("/view/entity/admin/UploadFile.jsp").forward(request, response);
                        } else if (testID != null && name != null && usercreated != null) {
                            testid = Integer.parseInt(testID);
                            db.insertTest(Integer.parseInt(testID), name, usercreated);
                            db.ImportExcel(request, response);
                        }
                        request.setAttribute("msg", "Upload file failed");
                    }
                }
            } catch (FileUploadException ex) {
                request.setAttribute("msg", ex.getMessage());
                request.getRequestDispatcher("/view/entity/admin/UploadFile.jsp").forward(request, response);
            }

        }
        ArrayList<Test> tests = db.getAllTestsByFilter(-1, "", "");
        request.setAttribute("tests", tests);
        request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
    }

//    public ArrayList<Test> getClientTestsList(String username, int testid) {
//        Connection connection = getConnection();
//        ArrayList<Test> arr = new ArrayList<>();
//        try {
//            String sql = "SELECT        Test.id as testid, Test.name, Question.id , Question.question, Question.option1, Question.option2, Question.option3, Question.correct\n"
//                    + "FROM            Client_Tests_List INNER JOIN\n"
//                    + "                         Question ON Client_Tests_List.testid = Question.testid INNER JOIN\n"
//                    + "                         Test ON Client_Tests_List.testid = Test.id AND Question.testid = Test.id \n where 1=1";
//
//            HashMap<Integer, Object[]> parameters = new HashMap<>();
//            int countParams = 0;
//
//            if (testid != -1) {
//                sql += " AND Test.id = ? ";
//                countParams++;
//                Object[] values = {"INT", testid};
//                parameters.put(countParams, values);
//            }
//
//            if (!username.equals("")) {
//                sql += " AND Client_Tests_List.username like  ?  ";
//                countParams++;
//                Object[] values = {"STRING", username};
//                parameters.put(countParams, values);
//            }
//
//            PreparedStatement statement = connection.prepareStatement(sql);
//            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
//                Integer key = entry.getKey();
//                Object[] value = entry.getValue();
//                switch (value[0].toString()) {
//                    case "INT":
//                        statement.setInt(key, (int) value[1]);
//                        break;
//                    case "STRING":
//                        statement.setString(key, value[1].toString());
//                        break;
//                }
//
//            }
//
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                Test t = new Test();
//                t.setName(rs.getString("name"));
//                t.setTestID(rs.getInt("testid"));
//                do {
//                    Question q = new Question();
//                    q.setTestID(rs.getInt("testid"));
//                    q.setQuestionID(rs.getInt("id"));
//                    q.setQuestion(rs.getString("question"));
//                    q.setOption1(rs.getString("option1"));
//                    q.setOption2(rs.getString("option2"));
//                    q.setOption3(rs.getString("option3"));
//                    q.setCorrect(rs.getString("correct"));
//                    t.setArrQues(q);
//                } while (rs.next());
//                arr.add(t);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return arr;
//    }

    public ArrayList<Test> getAllTestListofClient(String username) {
        Connection connection = getConnection();
        ArrayList<Test> arr = new ArrayList<>();
        try {
            String sql = "SELECT        Test.id, Test.name\n"
                    + "FROM            Client_Tests_List INNER JOIN\n"
                    + "                         Test ON Client_Tests_List.testid = Test.id where Client_Tests_List.username=?";

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Test t = new Test();
                t.setName(rs.getString("name"));
                t.setTestID(rs.getInt("id"));
                arr.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<Answer> getAnswerList(int testid) {
        Connection connection = getConnection();
        ArrayList<Answer> arr = new ArrayList<>();
        try {
            String sql = "select id, correct from Question\n"
                    + "where testid=?";

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, testid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Answer t = new Answer();
                t.setId(rs.getInt("id"));
                t.setAnswer(rs.getString("correct"));
                arr.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean insertClientTest(String username, int testid) {
        String sql = "insert into Client_Tests_List\n"
                + "values (?,?)";
        int isCheck = 0;
        Connection connection = getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, testid);
            isCheck = ps.executeUpdate(); //trả về số lượng record bị ảnh hưởng
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("isCheck = " + isCheck);
        return isCheck > 0;
    }

    public static void main(String[] args) {
        DBContext db = new DBContext();
        ArrayList<Account> a = db.getAllAccount();
    }

    
}
