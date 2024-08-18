public class AirPlane {
    private int id;
    public float latitude;
    public float longitude;
    public float altitude;
    // proxima aula = private float altitude;

    public AirPlane(){} // cria um objeto vazio
        
    public AirPlane(int id) { // construtores
        setId(id);
        latitude = 0;
        longitude = 0;
        altitude = 0;
    }
    
    public AirPlane(float lat, float lon) { // construtores
        int id = Math.round(lat-lon);
        setId(id);
        latitude = lat;
        longitude = lon;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        if(latitude >= -90 && latitude <= 90){
           this.latitude = latitude; 
        }
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        if(longitude >= -180 && longitude <= 180){
            this.longitude = longitude;
        }
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        if(altitude >= 0){
          this.altitude = altitude;  
        }
    }


}