package it.unipd.dei.webapp.rest;

import it.unipd.dei.webapp.database.AdminLoggingdatabase;
import it.unipd.dei.webapp.database.LandlordLoggingandinfodatabase;
import it.unipd.dei.webapp.database.Studentinfologgingdatabase;
import it.unipd.dei.webapp.resource.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Manages the REST API for the {@link Studnetinfo} resource.
 *
 **/

public class LoginRestResource extends RestResource{


    /**
    * Creates a new REST resource for managing {@code Studnetinfo} resources.
    *
    * @param req the HTTP request.
    * @param res the HTTP response.
    * @param con the connection to the database.
    */

    public LoginRestResource(final HttpServletRequest req, final HttpServletResponse res, Connection con){
        super(req, res, con);
    }
    /**
     * Reads an employee from the database.
     *
     * @throws IOException
     *             if any error occurs in the client/server communication.
     */
    public void loginStudent() throws IOException {

        List<Studnetinfo> e  = null;
        Message m = null;
        String[] temp = null;

        try{
            //  login/student/{taxcode}&{password}
            // parse the URI path to extract the badge
            String path = req.getRequestURI();
            path = path.substring(path.lastIndexOf("student")+8);

            temp = path.split("&");

//            String[] access = temp[1].split("&");
            //String[] access =token[2].split("&");

            /*
            final String n_bath_str = path.substring(2);
            if(n_bath_str != ""){
                n_bath = Integer.parseInt(n_bath_str);
            }
            */
            // creates a new object for accessing the database and reads the employee
            if(temp[0] != null && temp[1] != null ) {
                e = new Studentinfologgingdatabase(con, temp[0], temp[1]).GetStudnetinfo();
                // e = new SearchRoomDatabase(con,capacity_person, 0 ).searchRoom();
                if(e != null) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    new ResourceList<Studnetinfo>(e).toJSON(res.getOutputStream());
                } else {
                    m = new Message(String.format("taxcode & pass %s not found.", path ), "E5A3", null);
                    res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    m.toJSON(res.getOutputStream());
                }
            } else {
                m = new Message(String.format("{taxcode} & {password} : %s null.", path ), "E5A3", null);
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                m.toJSON(res.getOutputStream());
            }
        }catch (SQLException throwables){
            m = new Message("Database Error: unexpected error.", "E5A1", throwables.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            m.toJSON(res.getOutputStream());
            throwables.printStackTrace();
        }catch (Throwable t) {
            m = new Message("Cannot read taxcode & password: Syntax not respected login/student/{taxcode}&{password}.",
                    "E5A1", t.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            m.toJSON(res.getOutputStream());
        }

    }

    public void loginLandlord() throws IOException {

        List<Landlordinfo> e  = null;
        Message m = null;
        String[] temp = null;

        try{
            //  login/landlord/{taxcode}&{password}
            // parse the URI path to extract the badge
            String path = req.getRequestURI();
            path = path.substring(path.lastIndexOf("login/landlord")+15);

            temp = path.split("&");

            e = new LandlordLoggingandinfodatabase(con, temp[0], temp[1]).GetLandlordinfo();
            // e = new SearchRoomDatabase(con,capacity_person, 0 ).searchRoom();
            if(e != null) {
                res.setStatus(HttpServletResponse.SC_OK);
                new ResourceList<Landlordinfo>(e).toJSON(res.getOutputStream());
            } else {
                m = new Message(String.format("taxcode & pass %s not found.", path ), "E5A3", null);
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                m.toJSON(res.getOutputStream());
            }
//            } else {
//                m = new Message(String.format("taxcode or pass %s null.", temp[1] ), "E5A3", null);
//                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                m.toJSON(res.getOutputStream());
//            }
        } catch (Throwable t) {
            m = new Message("Cannot read taxcode & password: unexpected error11.", "E5A1", t.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            m.toJSON(res.getOutputStream());
        }

    }

    public void loginAdmin() throws IOException {

        List<Admininfo> e  = null;
        Message m = null;
        String[] temp = null;

        try{
            //  login/admin/{taxcode}&{password}
            // parse the URI path to extract the badge
            String path = req.getRequestURI();

            path = path.substring(path.lastIndexOf("login/admin")+12);

            temp = path.split("&");

            e = new AdminLoggingdatabase(con, temp[0], temp[1]).GetAdmin();
            // e = new SearchRoomDatabase(con,capacity_person, 0 ).searchRoom();
            if(e != null) {
                res.setStatus(HttpServletResponse.SC_OK);
                new ResourceList<Admininfo>(e).toJSON(res.getOutputStream());
            } else {
                m = new Message(String.format("taxcode & pass %s not found.", path ), "E5A3", null);
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                m.toJSON(res.getOutputStream());
            }
//            } else {
//                m = new Message(String.format("taxcode or pass %s null.", temp[1] ), "E5A3", null);
//                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                m.toJSON(res.getOutputStream());
//            }
        } catch (Throwable t) {
            m = new Message("Cannot read taxcode & password: unexpected error.", "E5A1", t.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            m.toJSON(res.getOutputStream());
        }

    }

}
