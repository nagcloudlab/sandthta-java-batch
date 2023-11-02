public class ValueTypesEx {
    public static void main(String[] args) {
        // 1. numeric
        /*
            byte ( 8 )
            short ( 16 )
            int ( 32 )
            long ( 64 )
            float ( 32 )
            double ( 64 )
        */
        byte byteVariable=12;
        short shortVariable=1212;
        int intVariable=12121212;
        long longVariable=1212121212121212L;
        double doubleVariable=12.12;
        float floatVariable=12.12F;

//        int v=10; // decimal
//        int v=010; // octal // 1 * 8^1 + 0 * 8^0 = 8
//        int v=0x10; // hex // 1 * 16^1 + 0 * 16^0 = 16
//        int v=0b10; // binary // 1 * 2^1 + 0 * 2^0 = 2
//        System.out.println(v);
//        long balance= 100_000_00L;
//        System.out.println(balance);


        //2. character
        char characterVariable1='a';
        char characterVariable2=97;
        char characterVariable3=0x61;
        char characterVariable4='\u0061';

        System.out.println(characterVariable1);
        System.out.println(characterVariable2);
        System.out.println(characterVariable3);
        System.out.println(characterVariable4);


        // 3. boolean
        boolean booleanVariable1=true;
        boolean booleanVariable2=false;

        System.out.println(booleanVariable1);
        System.out.println(booleanVariable2);


        int n=0x12; // 1 * 16^1 + 2 * 16^0 = 16 + 2 = 18
        System.out.println(n);
        System.out.println(Integer.toHexString(n));

    }
}
