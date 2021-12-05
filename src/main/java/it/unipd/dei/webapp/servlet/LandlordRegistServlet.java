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

import it.unipd.dei.webapp.database.LandlordRegistdatabase;
import it.unipd.dei.webapp.resource.LandlordRegist;
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


public final class LandlordRegistServlet extends AbstractDatabaseServlet {
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
        String l_taxcode = null;
        String l_name = null;
        InputStream  scannedID = null;
        long Img_lenght = -1;
        String password = null;

        // model
        LandlordRegist e  = null;
        Message m = null;

        try{
            // retrieves the request parameters
            l_taxcode = req.getParameter("l_taxcode");
            l_name = req.getParameter("l_name");
            Part filePart = req.getPart("scannedID");
            Img_lenght = filePart.getSize();
            scannedID = filePart.getInputStream();
            password = req.getParameter("password");




            e = new LandlordRegist(l_taxcode, l_name, scannedID, Img_lenght, password);



            new LandlordRegistdatabase(getDataSource().getConnection(), e).newLandlord();


            m = new Message(String.format("Landlord with taxcode %s successfully created.", l_taxcode));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the apartment. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            m = new Message("Cannot create the account: unexpected error while accessing the database.",
                    "E200", ex.getMessage());
        }

        req.setAttribute("LandlordRegist", e);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/LandlordRegist-Result.jsp").forward(req, res);


    }

}

