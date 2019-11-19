package myPackage.BLL;

import myPackage.DAL.connectDataBase;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class businessProcess {
    private static Connection connection;
    private static CallableStatement cS;

    public static boolean saveDrug(String drugName, int drugSerial, int providerSerial,
                                   float retailerPrice, float drugCost, String validDate) {


        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call SAVE_DRUG(?,?,?,?,?,?)");
            cS.setString(1, drugName);//drugName
            cS.setInt(2, drugSerial);//drugSerial
            cS.setInt(3, providerSerial);//providerSerial
            cS.setFloat(4, retailerPrice);//retailerPrice
            DateFormat df = new SimpleDateFormat("yyyy MM dd");
            cS.setDate(5, new Date(df.parse(validDate).getTime()));//validDate
            cS.setFloat(6, drugCost);//drugCost
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean purchaseDrug(String drugName, int drugSerial, int providerSerial,
                                       int drugQuantity) {
        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call PURCHASE_DRUG(?,?,?,?)");
            cS.setString(1, drugName);//drugName
            cS.setInt(2, drugSerial);//drugSerial
            cS.setInt(3, providerSerial);//providerSerial
            cS.setInt(4, drugQuantity);//drugQuantity
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean removeFromRepository(int drugSerial,String deal) {
        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call REMOVE_FROM_REPOSITORY(?,?)");
            cS.setInt(1, drugSerial);//drugSerial
            cS.setString(2,deal);//dispose
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean providerInfo(int providerSerial, String providerName, String providerTel) {
        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call PROVIDER_INFO(?,?,?)");
            cS.setInt(1, providerSerial);
            cS.setString(2, providerName);
            cS.setString(3, providerTel);
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean saleDrug(int drugSerial, String drugName, int saleQuantity, float salePrice, String customerName) {
        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call SALE_DRUG(?,?,?,?,?)");
            cS.setInt(1, drugSerial);
            cS.setString(2, drugName);
            cS.setInt(3, saleQuantity);
            cS.setFloat(4, salePrice);
            cS.setString(5, customerName);
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean addUser(String userID, String password, String jurisdiction) {
        try {
            connection = connectDataBase.getLink();
            cS = connection.prepareCall("call ADD_USER(?,?,?)");
            cS.setString(1, userID);
            cS.setString(2, password);
            cS.setString(3, jurisdiction);
            cS.execute();
            connection.close();
            cS.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
