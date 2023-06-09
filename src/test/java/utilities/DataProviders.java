package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
    //DataProvider:- 1 login details
   //*******************

    @DataProvider(name="LoginData")
    public Object[] getData() throws IOException
    {
        String path="C:\\Users\\abhis\\IdeaProjects\\Abhi_DemoNopCommerce_HybridProject_Learning\\testData\\nopcommerce-Login data.xlsx";//taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array

    }

    //DataProvider 2 register

    //DataProvider 3

    //DataProvider 4





}
