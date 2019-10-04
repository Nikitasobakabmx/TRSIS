import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;


@WebServlet(name = "AutorizationServlet", urlPatterns = {"/login"})
public class AutorizationServlet extends HttpServlet {

    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(request.getParameter("email").isEmpty() || 
            request.getParameter("password").isEmpty())
        {
            String path = request.getContextPath() + "/autor";
            response.sendRedirect(path);
            return;
        }
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        try(FileReader reader = new FileReader("/home/nikittossii/Documents/Coding/java/WebServers/OnServlet/GameShop/target/GameShop/simpleDB/clients.txt"))
        {
            BufferedReader buff = new BufferedReader(reader);
            String line = buff.readLine();
            while(line != null)
            {
                ArrayList<String> cur = new ArrayList<String>();                
                if(line != "")
                    for (String result : line.split(" "))
                        cur.add(result);
                if(cur.get(0).equals(email))
                    if(cur.get(1).equals(pass))
                    {
                        String res = new String();
                        try(FileReader soReader = new FileReader("/home/nikittossii/Documents/Coding/java/WebServers/OnServlet/GameShop/target/GameShop/simpleDB/" + cur.get(2)))
                        {
                            BufferedReader soBuff = new BufferedReader(soReader);
                            String soLine = soBuff.readLine();
                            while(soLine != null)
                            {               
                                res += soLine;
                                soLine = soBuff.readLine();
                            }    
                        }
                        catch(IOException ex)
                        {
                            System.out.println(ex.getMessage());
                        }  
                        
                        if(!res.isEmpty())
                            request.setAttribute("story", res);
                        else
                            request.setAttribute("story", "cleanStory");
                        request.setAttribute("name", cur.get(2)); 
                        request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
                        return;
                    }
                line = buff.readLine(); 
            }
            String path = request.getContextPath() + "/autor";
            response.sendRedirect(path);
            return;
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }   
    }
    
}
