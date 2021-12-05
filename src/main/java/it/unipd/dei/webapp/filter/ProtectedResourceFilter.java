/*
 * Copyright 2020 University of Padua, Italy
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

package it.unipd.dei.webapp.filter;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Base64;

/**
 * Checks for successful authentication to allow for accessing protected resources.
 *
 * @author Nicola Ferro
 * @version 1.00
 * @since 1.00
 */
public class ProtectedResourceFilter implements Filter {

    /**
     * The Base64 Decoder
     */
    private static final Base64.Decoder DECODER = Base64.getDecoder();

    /**
     * The name of the user attribute in the session
     */
    private static final String USER_ATTRIBUTE = "user";

    /**
     * The configuration for the filter
     */
    private FilterConfig config = null;

    /**
     * The connection pool to the database.
     */
    private DataSource ds;


    @Override
    public void init(final FilterConfig config) throws ServletException {

        if (config == null) {
            throw new ServletException("Filter configuration cannot be null.");
        }
        this.config = config;

        /*
        Here we could pass configuration parameters to the filter, if needed.
         */

        // the JNDI lookup context
        InitialContext cxt;

        try {
            cxt = new InitialContext();
            ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/employee-ferro");
        } catch (NamingException e) {
            ds = null;

            throw new ServletException(
                    String.format("Impossible to access the connection pool to the database: %s", e.getMessage()));
        }
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain chain) throws IOException, ServletException {


        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
            throw new ServletException("Only HTTP requests/responses are allowed.");
        }

        // Safe to downcast at this point.
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        final HttpSession session = req.getSession(false);

        // if we do not have a session, try to authenticate the user
        if (session == null) {

            if (!authenticateUser(req, res)) {
                return;
            }
        } else {

            final String user = (String) session.getAttribute(USER_ATTRIBUTE);

            // there might exist a session but without any user in it
            if (user == null || user.isEmpty()) {
                // invalidate the session
                session.invalidate();

                // try to authenticate the user
                if (!authenticateUser(req, res)) {
                    return;
                }

            }
        }

        // the user is properly authenticated and in session, continue the processing
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
        ds = null;
    }

    private boolean authenticateUser(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // get the authorization information
        final String auth = req.getHeader("Authorization");

        // if there is no authorization information, send the authentication challenge again
        if (auth == null || auth.isEmpty()) {
            sendAuthenticationChallenge(res);

            return false;
        }

        // if it is not HTTP Basic authentication, send the authentication challenge again
        if (!auth.toUpperCase().startsWith("BASIC ")) {
            sendAuthenticationChallenge(res);

            return false;
        }

        // perform Base64 decoding
        final String pair = new String(DECODER.decode(auth.substring(6)));

        // userDetails[0] is the username; userDetails[1] is the password
        final String[] userDetails = pair.split(":", 2);

        // if the user is successfully authenticated, create a Session and store the user there
        if (checkUserCredentials(userDetails[0], userDetails[1])) {
            // create a  new session
            HttpSession session = req.getSession(true);

            session.setAttribute(USER_ATTRIBUTE, userDetails[0]);

            return true;
        }

        // as a fallback, always send the authentication challenge again
        sendAuthenticationChallenge(res);

        return true;
    }


    private void sendAuthenticationChallenge(HttpServletResponse res) throws IOException {

        res.setHeader("WWW-Authenticate", "Basic realm=Employee");

        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }


    private boolean checkUserCredentials(String username, String password) {


        return true;
    }

}
