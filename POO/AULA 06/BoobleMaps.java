public class BoobleMaps {
    public static void main(String[] args) {
        AirPlane av00 = new AirPlane();
        AirPlane av01 = new AirPlane(01);
        AirPlane av02 = new AirPlane(-89, 38);
        av00.setId(00);
        av00.setLatitude(-9.7014f);
        av00.setLongitude(-36.6868f);
        av00.setAltitude(400);

        System.out.println("Posicioamento da aeronave " + av00.getId());
        System.out.println("Posicioamento da aeronave " + av01.getId());
        av01.altitude = 100;
        av01.latitude = 6764553434.f;
        System.out.println(" Dados: " + av01.altitude);
        System.out.println("    Latitude:   " + av00.getLatitude()  + " graus");
        System.out.println("    Longitude:  " + av00.getLongitude() + " graus");
        System.out.println("    Altitude:   " + av00.getAltitude()  + " m");
    }
}
