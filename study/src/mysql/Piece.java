package mysql;



enum Major{
    cekong,zidonghua,dianqi,zhineng;
}
public class Piece {
    String name;
    Major major;

    public static void main(String[] args) {
        Major major = Major.cekong;
        switch (major){
            case cekong:
                System.out.println("yes "+ major);
                break;
            case dianqi:
                System.out.println("yes " + major);
                break;
            case zhineng:
                System.out.println("yes " + major);
                break;
            case zidonghua:
                System.out.println("yes " + major);
                break;
            default:
                break;
        }

        Major[] majors = Major.values();
        for (int i = 0; i < majors.length; i++) {
            System.out.print(majors[i] + " ");
        }
        System.out.println();
    }
}
