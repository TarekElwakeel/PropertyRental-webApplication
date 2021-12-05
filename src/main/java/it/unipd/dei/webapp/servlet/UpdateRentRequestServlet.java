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

import it.unipd.dei.webapp.database.UpdateRentRequestdatabase;
import it.unipd.dei.webapp.resource.Message;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public final class UpdateRentRequestServlet extends AbstractDatabaseServlet {
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
        String status = null;
        int request_nr = -1;

        // model
        Message m = null;

        try {
            // retrieves the request parameters
            status = req.getParameter("status");
            request_nr = Integer.parseInt(req.getParameter("request_nr"));


            new UpdateRentRequestdatabase(getDataSource().getConnection(), status, request_nr).UpdateRentRequest();

            m = new Message(String.format("Request number %s successfully updated", request_nr));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot Update the request. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message("Cannot create the account: unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        }


        // stores the list and the message as a request attribute
        req.setAttribute("request_nr", request_nr);
        req.setAttribute("status", status);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/Update-RentRequest-Result.jsp").forward(req, res);


    }

}

