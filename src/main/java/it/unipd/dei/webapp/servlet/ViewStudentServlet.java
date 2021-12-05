package it.unipd.dei.webapp.servlet;


import it.unipd.dei.webapp.database.ViewStudentDatabase;
import it.unipd.dei.webapp.resource.Message;
import it.unipd.dei.webapp.resource.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/image")
@MultipartConfig(maxFileSize = 16177215)
public class ViewStudentServlet extends AbstractDatabaseServlet{

    private static final Logger logger= LogManager.getLogger(ViewStudentServlet.class);

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // request parameter
        String s_taxcode = null;

        // model
        List<Student> el = null;
        Message m = null;

        try {

            // retrieves the request parameter
            s_taxcode = req.getParameter("s_taxcode");

            // creates a new object for accessing the database and searching the employees
            el = new ViewStudentDatabase(getDataSource().getConnection(), s_taxcode)
                    .ViewStudentServlet();
            logger.trace(el);

            m = new Message("thanks to find least updated info about your property");

        } catch (NumberFormatException ex) {
            m = new Message(" Invalid input parameters please check your scode",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message(" unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        } //catch ( ServletException  ex) {
        //m = new Message( " unexpected error while accessing the database.",
        //            "E300", ex.getMessage());
        //}

        // set the MIME media type of the response
        res.setContentType("text/html; charset=utf-8");

        // get a stream to write the response
        PrintWriter out = res.getWriter();

        // write the HTML page
        out.printf("<!DOCTYPE html>%n");

        out.printf("<html lang=\"en\">%n");
        out.printf("<head>%n");
        out.printf("<meta charset=\"utf-8\">%n");
        out.printf("<title>Search Student</title>%n");
        out.printf("</head>%n");

        out.printf("<body>%n");
        out.printf("<h1>Search Student</h1>%n");
        out.printf("<hr/>%n");

        if(m.isError()) {
            out.printf("<ul>%n");
            out.printf("<li>error code: %s</li>%n", m.getErrorCode());
            out.printf("<li>message: %s</li>%n", m.getMessage());
            out.printf("<li>details: %s</li>%n", m.getErrorDetails());
            out.printf("</ul>%n");
        } else {
            out.printf("<p>%s</p>%n", m.getMessage());

            out.printf("<table>%n");
            out.printf("<tr>%n");
            // (String s_taxcode, String s_name, int age, String country,  Enum<Languages> foreign_lang, String status)
            out.printf("<td>s_taxcode</td><td>s_name</td><td>age</td><td>country</td><td>foreign_lang</td><td>status</td><td>ScannedID</td>%n");
            out.printf("</tr>%n");
            for(Student e: el) {


                BufferedInputStream bin=null;
                BufferedOutputStream bout=null;
                res.setContentType("image/jpeg");
                ServletOutputStream streamout;
                //response.setContentType(getServletContext().getMimeType(imageName));
                res.setContentLength((int)e.getScan_lenght());
                streamout = res.getOutputStream();

                InputStream in = e.gets_scannedID();

                bin = new BufferedInputStream(in);
                bout = new BufferedOutputStream(streamout);
                int ch=0;
                while((ch=bin.read())!=-1)
                {
                    bout.write(ch);
                }

                out.printf("<tr>%n");
                out.printf("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><img src=\"/images/test\" width=\"200\" height=\"200\"></td>%n",
                        e.gets_taxcode(), e.gets_name(), e.gets_age(), e.gets_country(), e.gets_foreign_lang(), e.getStatus());
                out.printf("</tr>%n");
            }
            out.printf("</table>%n");
        }

        out.printf("</body>%n");

        out.printf("</html>%n");

        // flush the output stream buffer
        out.flush();

        // close the output stream
        out.close();

    }

}

