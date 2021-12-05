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
 * Author: Tarek Elwakeel under supervision of professor Nicola Ferro (ferro@dei.unipd.it)
 * Version: 1.0
 * Since: 1.0
 */
package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.StudnetRegistdatabase;
import it.unipd.dei.webapp.resource.StudnetRegist;
import it.unipd.dei.webapp.resource.Message;



import java.io.IOException;
import java.sql.SQLException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@MultipartConfig(fileSizeThreshold=1024*1024*2, //2MB
        maxFileSize=1024*1024*10,
        maxRequestSize=1024*1024*10)


public final class StudnetRegistServlet extends AbstractDatabaseServlet {
    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // request parameters
        String s_taxcode = null;
        String s_name = null;
        int age = -1;
        String country = null;
        String foreign_lang = null ;
        String password = null;
        InputStream  scannedID = null;
        long Img_lenght = -1;

        // model
        StudnetRegist e  = null;
        Message m = null;

        try{
            // retrieves the request parameters
            s_taxcode = req.getParameter("s_taxcode");
            s_name = req.getParameter("s_name");
            age = Integer.parseInt(req.getParameter("age"));
            country = req.getParameter("country");
            foreign_lang = req.getParameter("foreign_lang");
            password = req.getParameter("password");
            Part filePart = req.getPart("scannedID");
            Img_lenght = filePart.getSize();
            scannedID = filePart.getInputStream();



            e = new StudnetRegist(s_taxcode, s_name, age, country, foreign_lang, password, scannedID, Img_lenght );



            new StudnetRegistdatabase(getDataSource().getConnection(), e).NewStudnet();


            m = new Message(String.format("Student with taxcode %s successfully created.", s_taxcode));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the account. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message("Cannot create the account: unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        }

        req.setAttribute("StudnetRegist", e);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/StudnetRegist-Result.jsp").forward(req, res);


    }

}

