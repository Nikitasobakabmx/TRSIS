import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "RegistrationServlet", urlPatterns = {"/welcome_boat"})
public class RegistrationServlet extends HttpServlet {

    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if( request.getParameter("name").isEmpty() ||
            request.getParameter("email").isEmpty() ||
            request.getParameter("password").isEmpty() ||
            request.getParameter("confirm_password").isEmpty())
        {
            String path = request.getContextPath() + "/reg";
            response.sendRedirect(path);
            return;
        }
        if(!request.getParameter("password").equals(request.getParameter("confirm_password")))
        {
            String path = request.getContextPath() + "/reg";
            response.sendRedirect(path);
            return;
        }
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String tmp = request.getParameter("surname");
        try(FileWriter reader = new FileWriter("/home/nikittossii/Documents/Coding/java/WebServers/OnServlet/GameShop/target/GameShop/simpleDB/clients.txt", true))
        {
            reader.write(email + " " + pass + " " + name + "\n");
            reader.flush();
            File story = new File("/home/nikittossii/Documents/Coding/java/WebServers/OnServlet/GameShop/target/GameShop/simpleDB/" + name);
            story.createNewFile();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        request.setAttribute("name", name);
        request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
        return;
    }
}
