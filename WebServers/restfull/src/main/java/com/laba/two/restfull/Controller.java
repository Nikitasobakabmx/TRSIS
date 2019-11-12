package com.laba.two.restfull;

import com.laba.two.restfull.DataBaseExecutor.DataBaseExecutor;
import com.laba.two.restfull.DataBaseExecutor.Iterator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Controller {

    @RequestMapping("/")
    public ArrayList<Iterator> __init__(){
        DataBaseExecutor exec = new DataBaseExecutor();
        return exec.select_all_games();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public boolean delete(@RequestParam(value = "id")String id){
        try{
            System.out.println(id);
            DataBaseExecutor exec = new DataBaseExecutor();
            exec.delete_game(id);

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public boolean append(@RequestParam(value = "name", defaultValue = "name")String name,
                          @RequestParam(value = "studio_name", defaultValue = "studio_name")String studio_name,
                          @RequestParam(value = "cost", defaultValue = "cost")String cost,
                          @RequestParam(value = "photo", defaultValue = "photo")String photo,
                          @RequestParam(value = "description", defaultValue = "description")String description){
        if (photo.equals("photo"))
            photo = null;
        if (description.equals("description"))
            description = null;
        try{
            DataBaseExecutor exec = new DataBaseExecutor();
            exec.append(name, studio_name, cost, photo, description);
        }
        catch (SQLException ex){
            return false;
        }
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public boolean change(@RequestParam(value = "id", defaultValue = "-1")String id,
                          @RequestParam(value = "name", defaultValue = "name")String name,
                          @RequestParam(value = "studio_name", defaultValue = "studio_name")String studio_name,
                          @RequestParam(value = "cost", defaultValue = "cost")String cost,
                          @RequestParam(value = "photo", defaultValue = "photo")String photo,
                          @RequestParam(value = "description", defaultValue = "description")String description){
        if (id.equals("-1"))
            return false;
        if (photo.equals("photo"))
            photo = null;
        if (description.equals("description"))
            description = null;
        try{
            DataBaseExecutor exec = new DataBaseExecutor();
            exec.change(id, name, studio_name, cost, photo, description);
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
