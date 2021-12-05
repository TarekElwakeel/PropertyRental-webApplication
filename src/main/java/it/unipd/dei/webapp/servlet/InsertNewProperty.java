package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.InsertNewPropertyDatabase;
import it.unipd.dei.webapp.resource.Appartament;
import it.unipd.dei.webapp.resource.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.SQLException;

/**
         * Creates a new Property into the database.
         *
         * @author Francesco Marcon (francesco.marcon.2@studenti.unipd.it)
        * @version 1.00
        * @since 1.00
        */
@MultipartConfig(fileSizeThreshold=1024*1024*2, //2MB
        maxFileSize=1024*1024*10,
        maxRequestSize=1024*1024*10)
public class InsertNewProperty extends AbstractDatabaseServlet {

        private static final Logger logger= LogManager.getLogger(InsertNewProperty.class);
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

            logger.trace("Servlet");
            // request parameters
            String address = null;
            String landlord = null;
            String room = null;
            int common_bathroom = -1;
            String extra_info = null;
            String other = null;
            int capacity_person = -1;
            int adminUserName = -1;
            InputStream ownership_proof = null;
            long ownership_lenght = -1;

            // model
            Appartament e  = null;
            Message m = null;

            try{
                // retrieves the request parameters
                address = req.getParameter("address");
                landlord = req.getParameter("landlord");
                room = req.getParameter("rooms");
                common_bathroom = Integer.parseInt(req.getParameter("common_bathroom"));
                extra_info = req.getParameter("extra_info");
                other = req.getParameter("other");
                capacity_person = Integer.parseInt(req.getParameter("capacity_persons"));
                adminUserName = Integer.parseInt(req.getParameter("adminusername"));
                Part filePart = req.getPart("ownership_proof");
                if(  filePart ==null) {
                    e=new Appartament(address, room, common_bathroom, extra_info);
                }else{
                    ownership_lenght = filePart.getSize();
                    ownership_proof = filePart.getInputStream();

                    if (other != null || capacity_person != -1) {
                        e=new Appartament(address, landlord, room, common_bathroom, extra_info, ownership_proof, ownership_lenght, other, capacity_person, adminUserName);
                    } else {
                        e=new Appartament(address, room, common_bathroom, extra_info, ownership_proof, ownership_lenght);
                    }
                }

                //e = new Appartament(s_taxcode, s_name, age, country, Languages.valueOf(foreign_lang));//, scannedID);

                // creates a new object for accessing the database and stores the employee
                new InsertNewPropertyDatabase(getDataSource().getConnection(), e).CreateStudent();

                m = new Message(String.format("Appartament ID creates %s successfully created.", landlord));

            } catch (NumberFormatException ex) {
                //logger.error(ex);
                //String err =String.format("%s , %s , %s , %s , %s , %s , %s , %s",address, landlord, room, common_bathroom, extra_info, other, capacity_person, adminUserName);
                m = new Message("Invalid input parameters\nInput: ",//+err,
                        "E100", ex.getMessage());
            } catch (SQLException ex) {
                if (ex.getSQLState().equals("23505")) {
                    m = new Message(String.format("Cannot create the property: codeID %s already exists. Duplicate", address),
                            "E300", ex.getMessage());
                }
                else {
                    String err =String.format("%s , %s , %s , %s , %s , %s , %s , %s",address, landlord, room, common_bathroom, extra_info, other, capacity_person, adminUserName);
                    m = new Message("SQLException: unexpected error while accessing the database."+err,
                            "E200", ex.getMessage());
                }
            }/*catch (ServletException ex){
                m=new Message("ServletException",//+err,
                        "E100", ex.getMessage());
            }catch (IOException ex){
                m=new Message("IOException",//+err,
                        "E100", ex.getMessage());
            }*/


            // set the MIME media type of the response
            res.setContentType("text/html; charset=utf-8");

            // get a stream to write the response
            PrintWriter out = res.getWriter();

            // write the HTML page
            out.printf("<!DOCTYPE html>%n");

            out.printf("<html lang=\"en\">%n");
            out.printf("<head>%n");
            out.printf("<meta charset=\"utf-8\">%n");
            out.printf("<title>Create Property</title>%n");
            out.printf("</head>%n");

            out.printf("<body>%n");
            out.printf("<h1>Create Property</h1>%n");
            out.printf("<hr/>%n");

            if(m.isError()) {
                out.printf("<ul>%n");
                out.printf("<li>error code: %s</li>%n", m.getErrorCode());
                out.printf("<li>message: %s</li>%n", m.getMessage());
                out.printf("<li>details: %s</li>%n", m.getErrorDetails());
                out.printf("</ul>%n");
            } else {
                //Appartment(address, ownership_proof, rooms, common_bathroom, extra_info
                // Room(app_address ,capacity_persons,Other)
                // Insert_App(landlord, app_address)
                // Verify (appartmentID, adminusername)

                out.printf("<p>%s</p>%n", m.getMessage());
                out.printf("<ul>%n");
                out.printf("<li>address: %s</li>%n", e.getAddress());
                out.printf("<li>landlord: %s</li>%n", e.getLandlord());
                out.printf("<li>room: %s</li>%n", e.getRoom());
                out.printf("<li>common_bathroom: %s</li>%n", e.getCommon_bathroom());
                out.printf("<li>extra_info: %s</li>%n", e.getExtra_info());
                out.printf("<li>capacity_persons: %s</li>%n", e.getCapacity_person());
                out.printf("<li>Other: %s</li>%n", e.getOther());
                out.printf("<li>adminusername: %s</li>%n", e.getAdminUserName());
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
