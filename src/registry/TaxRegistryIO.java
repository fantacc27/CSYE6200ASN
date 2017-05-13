package edu.neu.csye6200.registry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Xiao
 */
public class TaxRegistryIO {

    /*public void save(ArrayList ArrayList, String Filename) throws IOException {
        String base = "src/";
        try {
            FileWriter writer = new FileWriter(base + "/" + Filename + ".txt");
            

            for(int i=0;i<ArrayList.size();i++) {
                writer.write(ArrayList.get(i).toString());
            }

            writer.close(); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    private static Logger log
            = Logger.getLogger(TaxRegistryIO.class.getName());

    public TaxRegistryIO() {
        log.info("Constructing a TaxRegistryIO instance");

    }

    /*public void save(ArrayList<Vehicle> ArrayList, String FileName){
        String base = "src/Assign2/";
        try{
            FileOutputStream fos = new FileOutputStream(base + FileName + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ArrayList);
            oos.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }*/
    public static void save(ArrayList<Vehicle> ArrayList, String FileName) {//file 为写入的文件
        log.info("Constructing a TaxRegistryIO save method");
        try {
            //PrintWriter writer = new PrintWriter("src/Assign2/" + FileName + ".txt");
            FileOutputStream fos = new FileOutputStream("src/Assign2/" + FileName + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < ArrayList.size(); i++) {
                Vehicle v = ArrayList.get(i);
                //writer.write(v.toString());
                //writer.print("\r\n");
                oos.writeObject(v);
            }
            oos.writeObject(null);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.severe("File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("IOException!");
        }

    }

    public ArrayList<Vehicle> load(String FileName) {
        String base = "src/Assign2/";
        Vehicle veh = null;
        ArrayList<Vehicle> v = new ArrayList<Vehicle>();
        try {
            FileInputStream fis = new FileInputStream(base + FileName + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while ((veh = (Vehicle) ois.readObject()) != null) { //如果为null就读取到文件结尾了。
                Vehicle vv = (Vehicle) veh;
                v.add(vv);
            }
            ois.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaxRegistryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;

    }

    /*public void load(String FileName) {
        String base = "src/Assign2/";
        log.info("Constructing a TaxRegistryIO load method");
        try {

            File filename = new File(base + FileName + ".txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";

            try {
                line = br.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
                log.severe("IOException!");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            log.severe("File Not Found!");
        }
    }*/
    public void FileHandler() {
        log.setLevel(Level.ALL);

        String logPath = "C:\\Users\\Xiao\\Desktop\\NERV\\CSYE6200\\Java\\TaxRegistryIOLog.txt";
        try {
            File logDirFile = new File(logPath);
            if (!logDirFile.exists()) // If this log folder doesn't exist, create it
            {
                logDirFile.mkdirs();
            }

            Handler handler2 = new FileHandler(logPath, 8000, 8000);
            Logger.getLogger(TaxRegistryIO.class.getName()).addHandler(handler2);

        } catch (SecurityException e) {
            e.printStackTrace();
            log.severe("Security denied!");
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("IOException!");
        }
    }
}

/*public static void main(String[] args) {
        TaxRegistryIO trio = new TaxRegistryIO();
        VehicleTaxation vt = new VehicleTaxation();
        vt.VehicleList();
        vt.AddElement();
        ArrayList al = vt.GetList();
        String fn = "VehicleInformation";
        trio.save(al, fn);
        trio.load(fn);
    }*/
