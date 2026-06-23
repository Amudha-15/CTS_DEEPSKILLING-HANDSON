interface Image { void display(); }

class RealImage implements Image {
    private final String url;
    RealImage(String url){ this.url = url; loadFromRemote(); }
    private void loadFromRemote(){ System.out.println("Loading image from " + url); }
    public void display(){ System.out.println("Displaying " + url); }
}

class ProxyImage implements Image {
    private final String url; private RealImage real;
    ProxyImage(String url){ this.url = url; }
    public void display(){ if (real == null) real = new RealImage(url); real.display(); }
}

public class ProxyImageDemo {
    public static void main(String[] args){
        Image img = new ProxyImage("http://example.com/picture.jpg");
        System.out.println("First call:"); img.display();
        System.out.println("Second call:"); img.display();
    }
}
