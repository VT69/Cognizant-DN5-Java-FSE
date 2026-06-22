interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image loaded successfully!");
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        
        realImage.display();
    }
}

class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("high_res_photo_1.jpg");
        Image image2 = new ProxyImage("high_res_photo_2.jpg");

        System.out.println("--- First call to display image1 ---");
        
        image1.display();

        System.out.println("\n--- Second call to display image1 ---");
        
        image1.display();

        System.out.println("\n--- First call to display image2 ---");
        
        image2.display();
    }
}