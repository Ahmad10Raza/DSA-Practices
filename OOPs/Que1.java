package OOPs;
import java.util.*;

/// Question 1 : Print the sum, difference and product of two complex numbers by creating a
// class named 'Complex' with separate methods for each operation whose real and imaginary
// parts are entered by the user.

 class complex{
    int real;
    int img;
    
    // creating constructor
    public  complex(int r,int i){
        int real=r;
        int img=i;
    }

    //creating addition class
    public static complex add(complex a,complex b){
        return new complex((a.real+b.real),(a.img+b.img));
    }
    public static complex sub(complex a,complex b){
        return new complex((a.real-b.real),(a.img-b.img));
    }
    public static complex mul(complex a,complex b){
       return new complex(((a.real*b.real)-(a.img*b.img)),((a.real*b.img)+(a.img*b.real)));
    }
    
   //printing function
   public void printcomplex(){
    if(real==0 && img!=0){
        System.out.println(img+"i");
    }
    else if(img==0 && real!=0){
        System.out.println(real);
    }
    else{
        System.out.println(real+"+"+img+"i");
    }
   }
 
// creating class of solution of problem
 
    public  static void  main(String[] args) {
        complex c=new complex(6,9);
        complex d=new complex(3, 9);
        complex e= complex.add(c, d);
        complex f= complex.sub(c, d);
        complex g= complex.mul(c, d);
        e.printcomplex();
        f.printcomplex();
        g.printcomplex();
    }
}
    
