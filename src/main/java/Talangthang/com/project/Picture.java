package Talangthang.com.project;

public class Picture {
    private String DestinationID;
    private String Img;

    public Picture() {
    }

    public Picture(String destinationID, String img) {
        DestinationID = destinationID;
        Img = img;
    }

    public String getDestinationID() {
        return DestinationID;
    }

    public void setDestinationID(String destinationID) {
        DestinationID = destinationID;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
