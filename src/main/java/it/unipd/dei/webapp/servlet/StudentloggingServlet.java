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

import it.unipd.dei.webapp.database.Studentinfologgingdatabase;
import it.unipd.dei.webapp.resource.Studnetinfo;
import it.unipd.dei.webapp.resource.Message;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public final class StudentloggingServlet extends AbstractDatabaseServlet {
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
        String password = null;

        // model
        List<Studnetinfo> el = null;
        Message m = null;

        try {

            // retrieves the request parameter
            s_taxcode = req.getParameter("s_taxcode");
            password = req.getParameter("s_password");

            if (password != null){

                // creates a new object for accessing the database and searching
                el = new Studentinfologgingdatabase(getDataSource().getConnection(), s_taxcode, password)
                        .GetStudnetinfo();

                m = new Message("thank you for logging.");

            }else {

                m = new Message("username or password is not correct. please try again");

            }

        } catch (NumberFormatException ex) {
            m = new Message(" Invalid input parameters please check your taxcode",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message(" unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        }

        // stores the list and the message as a request attribute
        req.setAttribute("StudnetinfoList", el);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/StudentLogging-Result.jsp").forward(req, res);


    };
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // request parameter
        String s_taxcode = null;
        String password = null;

        // model
        List<Studnetinfo> el = null;
        Message m = null;

        try {

            // retrieves the request parameter
            s_taxcode = req.getParameter("s_taxcode");
            password = req.getParameter("s_password");

            if (password != null){

                // creates a new object for accessing the database and searching
                el = new Studentinfologgingdatabase(getDataSource().getConnection(), s_taxcode, password)
                        .GetStudnetinfo();

                m = new Message("thank you for logging.");

            }else {

                m = new Message("username or password is not correct. please try again");

            }

        } catch (NumberFormatException ex) {
            m = new Message(" Invalid input parameters please check your taxcode",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message(" unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        }

        // stores the list and the message as a request attribute
        req.setAttribute("StudnetinfoList", el);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/StudentLogging-Result.jsp").forward(req, res);


    };

}

