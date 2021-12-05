package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.ViewContractDatabase;
import it.unipd.dei.webapp.resource.Message;
import it.unipd.dei.webapp.resource.VerifyContract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//To Call http://localhost:8080/PropertyRental/view-contract?s_taxcode=?, ? value of parameter

public class ViewContractServlet extends AbstractDatabaseServlet {
    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // request parameters
        String s_taxcode = null;


        // model
        List<VerifyContract> e  = null;
        Message m = null;
        String[] select = null;
        String address = null;
        int badge = -1;

        try{
            // retrieves the request parameters
            s_taxcode = req.getParameter("s_taxcode");
            // select = req.getParameter("selected").split(",");
            // address = select[0];
            // badge = Integer.parseInt( select[1] );
            // creates a new object for accessing the database and stores the RoomRequest
            e = new ViewContractDatabase(getDataSource().getConnection(), s_taxcode).viewContract();

            m = new Message(String.format("Student with tax code %s successfully created.", s_taxcode));

        } catch (NumberFormatException ex) {
            m = new Message("Cannot create the account. Invalid input parameters",
                    "E100", ex.getMessage());
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                m = new Message(String.format("Request for appartment %s number %s Duplicate: Request %d already exists.", address, badge),
                        "E300", ex.getMessage());
            } else {
                m = new Message("Cannot create the account: unexpected error while accessing the database.",
                        "E200", ex.getMessage());
            }
        }

        req.setAttribute("viewContracts", e);
        req.setAttribute("message", m);

        // forwards the control to the create-employee-result JSP
        req.getRequestDispatcher("/jsp/view-contract.jsp").forward(req, res);
    }

}
