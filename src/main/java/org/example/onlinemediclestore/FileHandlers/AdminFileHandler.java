package org.example.onlinemediclestore.FileHandlers;

import org.example.onlinemediclestore.Classes.Admin;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.Interfaces.IAdminFileHandler;

import java.util.List;

public class AdminFileHandler implements IAdminFileHandler
{

    private final String FILEPATH = Config.ADMINS.getPath();

    @Override
    public void saveAdmin(Admin admin) {


    }

    @Override
    public List<Admin> getAllAdmins() {
        return null;
    }
}
