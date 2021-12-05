package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.InsertRoomRequestDatabase;
import it.unipd.dei.webapp.database.ViewContractDatabase;
import it.unipd.dei.webapp.resource.Message;
import it.unipd.dei.webapp.resource.RentRequest;
import it.unipd.dei.webapp.resource.RentRequest1;
import it.unipd.dei.webapp.resource.VerifyContract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
//@MultipartConfig(fileSizeThreshold=1024*1024*2, //2MB
  //      maxFileSize=1024*1024*10,
  //      maxRequestSize=1024*1024*10)
public final class CreateRoomRequestServlet extends AbstractDatabaseServlet {

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
        String selected = null;
        String s_taxcode = null;


        // model
        RentRequest1 e  = null;
        Message m = null;
        String[] select = null;
        String address = null;
        int badge = -1;

        try{
            // retrieves the request parameters
            s_taxcode = req.getParameter("s_taxcode");
            select = req.getParameter("selected").split(",");
            address= select[0];
            badge = Integer.parseInt(select[1]);
            e = new RentRequest1( s_taxcode, address, badge );

            // creates a new object for accessing the database and stores the RoomRequest
            new InsertRoomRequestDatabase(getDataSource().getConnection(), e).CreateRoomRequest();

            m = new Message(String.format("Student with tax code %s successfully created.", s_taxcode));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the account. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                m = new Message(String.format("Request for appartment %s number %s Duplicate: Request %s already exists.",address,badge),
                        "E300", ex.getMessage());
            } else {
                m = new Message("Cannot create the account: unexpected error while accessing the database.",
                        "E200", ex.getMessage());
            }
        }
        req.setAttribute("s_taxcode",s_taxcode);
        req.setAttribute("rentrequest", e);
        //req.setAttribute("message", m);

        // forwards the control to the create-employee-result JSP
        req.getRequestDispatcher("/jsp/create-room-result.jsp").forward(req, res);

    }
}

