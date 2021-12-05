/*
 * Copyright 2018 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.CreateStudentdatabase;
import it.unipd.dei.webapp.resource.Languages;
import it.unipd.dei.webapp.resource.Student;
import it.unipd.dei.webapp.resource.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Creates a new Student into the database.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, //2MB
        maxFileSize=1024*1024*10,
        maxRequestSize=1024*1024*10)
public final class CreateStudentServlet extends AbstractDatabaseServlet {

    /**
     * Creates a new Student into the database.
     *
     * @param req
     *            the HTTP request from the client.
     * @param res
     *            the HTTP response from the server.
     *
     * @throws ServletException
     *             if any error occurs while executing the servlet.
     * @throws IOException
     *             if any error occurs in the client/server communication.
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // request parameters
        String s_taxcode = null;
        String s_name = null;
        int age = -1;
        String country = null;
        String foreign_lang = null;
        String path = null;
        InputStream scannedID = null;
        long scan_lenght = -1;

        // model
        Student e  = null;
        Message m = null;

        try{
            // retrieves the request parameters
            s_taxcode = req.getParameter("s_taxcode");
            s_name = req.getParameter("s_name");
            age = Integer.parseInt(req.getParameter("age"));
            country = req.getParameter("country");
            foreign_lang = req.getParameter("foreign_lang");
            path = req.getParameter("scannedID");
            Part image = req.getPart("scannedID");
            scan_lenght=image.getSize();
            //scannedID = Integer.parseInt(path);
            if ( scan_lenght >=200 ) {
                scannedID=image.getInputStream();
                // creates a new Student from the request parameters
                e=new Student( s_taxcode, s_name, age, country, Languages.valueOf(foreign_lang), scannedID, scan_lenght );
            }else{
                e=new Student( s_taxcode, s_name, age, country, Languages.valueOf(foreign_lang), null );
            }
            // creates a new object for accessing the database and stores the employee
            new CreateStudentdatabase(getDataSource().getConnection(), e).CreateStudent();

            m = new Message(String.format("Student with tax code %s successfully created.", s_taxcode));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the account. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                m = new Message(String.format("Cannot create the account: tax code %s already exists.", s_taxcode),
                        "E300", ex.getMessage());
            } else {
                m = new Message("Cannot create the account: unexpected error while accessing the database."+e.getScan_lenght(),
                        "E200", ex.getMessage());
            }
        }



        // set the MIME media type of the response
        res.setContentType("text/html; charset=utf-8");

        // get a stream to write the response
        PrintWriter out = res.getWriter();

        // write the HTML page
        out.printf("<!DOCTYPE html>%n");

        out.printf("<html lang=\"en\">%n");
        out.printf("<head>%n");
        out.printf("<meta charset=\"utf-8\">%n");
        out.printf("<title>Create Student</title>%n");
        out.printf("</head>%n");

        out.printf("<body>%n");
        out.printf("<h1>Create Student</h1>%n");
        out.printf("<hr/>%n");

        if(m.isError()) {
            out.printf("<ul>%n");
            out.printf("<li>error code: %s</li>%n", m.getErrorCode());
            out.printf("<li>message: %s</li>%n", m.getMessage());
            out.printf("<li>details: %s</li>%n", m.getErrorDetails());
            out.printf("</ul>%n");
        } else {
            out.printf("<p>%s</p>%n", m.getMessage());
            out.printf("<ul>%n");
            out.printf("<li>taxcode: %s</li>%n", e.gets_taxcode());
            out.printf("<li>surname: %s</li>%n", e.gets_name());
            out.printf("<li>age: %s</li>%n", e.gets_age());
            out.printf("<li>country: %s</li>%n", e.gets_country());
            out.printf("<li>foreign_lang: %s</li>%n", e.gets_foreign_lang());
            out.printf("<li>scannedID: %s</li>%n", e.gets_scannedID());
            out.printf("</ul>%n");
        }

        out.printf("</body>%n");

        out.printf("</html>%n");

        // flush the output stream buffer
        out.flush();

        // close the output stream
        out.close();

    }

}

