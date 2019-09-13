public class Main {
    public static void main(String[] args) {
        try {
            Matrix m = new Matrix();
            m.generate();
            m.find();
            m.print();
        }
        catch(NumberFormatException e){
            System.out.println("Input exception!!!");
        }
    }
}
