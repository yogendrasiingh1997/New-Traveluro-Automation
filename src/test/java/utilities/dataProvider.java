package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProvider {

    //DataProvider 1

    @DataProvider (name = "LoginData")
    public String [][] getData () throws IOException
    {
        String path="C://Users//ADMIN//Downloads//testdata.xlsx";  //taking xl from test data
        ExcelUtility xlUtlity= new ExcelUtility(path);

        int totalrows= xlUtlity.getRowCount("Sheet1");
        int totalcols= xlUtlity.getCellCount("Sheet1", 1);

        String[][] logindata = new String[totalrows] [totalcols];

        for (int i=1;i<totalrows;i++)
        {
            for(int j=0; j<totalcols;j++)
            {
                logindata[i-1][j]=xlUtlity.getCellData("Sheet1", i, j);
            }
        }
        return logindata;
    }

}
