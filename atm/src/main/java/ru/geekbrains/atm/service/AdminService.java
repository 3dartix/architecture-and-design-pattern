package ru.geekbrains.atm.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private File destination; //путь на флешке для копирования файлов

    public List<String> getListLogs(){
        return new ArrayList<>();
    }

    public String getLogByName(String name){
        return "log_06_09_2020.txt";
    }

    public List<String> getAllFootageFromCamera(){
        return new ArrayList<>();
    }

    public String getFootageFromCameraByName(String name){
        return "log_06_09_2020.mov";
    }

    public void copyFile (String name) {
        File source = new File(name);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
