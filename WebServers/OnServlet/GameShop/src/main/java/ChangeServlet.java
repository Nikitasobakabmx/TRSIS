import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "ChangeServlet", urlPatterns = {"/change"})
public class ChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String story = request.getParameter("story");
        String name = request.getParameter("name");
        System.out.println(name);
        try(FileWriter writer = new FileWriter("/home/nikittossii/Documents/Coding/java/WebServers/OnServlet/GameShop/target/GameShop/simpleDB/" + name, false))
        {
            writer.write(story + "\n");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }  
        request.setAttribute("story", story);
        request.setAttribute("name", name);
        request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
    }
}
