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

import it.unipd.dei.webapp.database.NewApartmentdatabase;
import it.unipd.dei.webapp.database.ApartmentRelationdatabase;
import it.unipd.dei.webapp.resource.NewApartment;
import it.unipd.dei.webapp.resource.ApartmentRelation;
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


public final class NewApartmentServlet extends AbstractDatabaseServlet {
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

        String landlord = null;
        String app_address = null;
        String address = null;
        InputStream  ownership_proof = null;
        long Img_lenght = -1;
        int n_room = -1;
        int n_bath = -1;
        String s_kitchen = null;
        int p_code = -1;
        String energy_class = null;
        double totSquareMeter = 0.0;
        String extra_info = null ;

        // model
        NewApartment e  = null;
        ApartmentRelation s  = null;
        Message m = null;

        try{
            // retrieves the request parameters
            landlord = req.getParameter("landlord");
            app_address = req.getParameter("app_address");
            address = req.getParameter("app_address");
            Part filePart = req.getPart("ownership_proof");
            Img_lenght = filePart.getSize();
            ownership_proof = filePart.getInputStream();
            n_room = Integer.parseInt(req.getParameter("n_room"));
            n_bath = Integer.parseInt(req.getParameter("n_bath"));
            s_kitchen = req.getParameter("s_kitchen");
            p_code = Integer.parseInt(req.getParameter("p_code"));
            energy_class = req.getParameter("energy_class");
            totSquareMeter = Double.parseDouble(req.getParameter("totSquareMeter"));
            extra_info = req.getParameter("extra_info");



            e = new NewApartment(address, ownership_proof, Img_lenght, n_room, n_bath, s_kitchen, p_code,
                    energy_class, totSquareMeter,extra_info);

            s = new ApartmentRelation(landlord, app_address);


            new NewApartmentdatabase(getDataSource().getConnection(), e).NewApartment();

            new ApartmentRelationdatabase(getDataSource().getConnection(), s).ApartmentRelation();


            m = new Message(String.format("Apartment with address %s successfully created.", address));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the apartment. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
                m = new Message("Cannot create the account: unexpected error while accessing the database.",
                        "E200", ex.getMessage());
            }

        req.setAttribute("NewApartment", e);
        req.setAttribute("message", m);

        // forwards the control to the result JSP
        req.getRequestDispatcher("/jsp/Add-NewApatment-Result.jsp").forward(req, res);


    }

}

