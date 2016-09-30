package ao.shang.cai.builder;

/**
 * Created by 蔡尚澳 on 2016/8/10.
 */
public class Client {

    public static void main(String[] args) {
        AirshipDirector director = new CsaAirshipDirector(new CsaAirshipBuilder());
        Airship airship = director.directAirship();

        System.out.println(airship.getEngine().getName());
        airship.launch();
    }
}
