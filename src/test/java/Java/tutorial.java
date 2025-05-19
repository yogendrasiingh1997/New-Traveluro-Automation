package Java;

public class tutorial
{
    public static void main (String args[])
    {
//        int i=0;
//        while(i<=10)
//        {
//            if(i%2==0)
//            {
//                System.out.println("even number: " + i);
//            }
//            else
//            {
//                System.out.println("odd number: " + i);
//            }
//            i++;
//        }

        //Reverse number

//        int i=1234;
//        int rev=0;
//
//        while (i!=0)
//        {
//            rev=rev*10+ i%10;
//            i=i/10;
//        }
//        System.out.println(rev);

        // palindrome or not

        int i=12112;
        int org=i;
        int rev=0;

//        while (i!=0)
//        {
//            rev=rev*10+ i%10;
//            i=i/10;
//        }
//
//        if(org==rev)
//        {
//            System.out.println("number is palindrome");
//        }
//        else
//        {
//            System.out.println("number is not palindrome");
//        }

        //count number digits in number

//       int count=0;
//       while(i>0)
//       {
//           i=i/10;
//           count++;
//       }
//        System.out.println("total count digit is: "+ count);



       //count even odd number in digit
//        int num1=123456987;
//        int evenCount=0;
//        int oddCount=0;
//        while(num1>0)
//        {
//            int rem=num1%10;
//            if(rem%2==0)
//            {
//                evenCount++;
//            }
//            else {
//                oddCount++;
//            }
//
//            num1=num1/10;
//        }
//        System.out.println("even count:" + evenCount);
//        System.out.println("odd count:" + oddCount);


        //sum of all digit

        int num2=123;
        int total=0;
        while(num2>0)
        {
            total=total+num2%10;
            num2=num2/10;  //eleminate last digit
        }
        System.out.println("total sum: " + total);








    }
}
