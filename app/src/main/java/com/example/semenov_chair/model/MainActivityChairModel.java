package com.example.semenov_chair.model;

public class MainActivityChairModel {
    private String material;
    private String color;
    private String height; // String, а не int
    private String price;  // String, а не float
    private boolean hasArmrests;

    private boolean shouldNavigateToSecondView;
    private boolean shouldShowError;

    public MainActivityChairModel() {
        shouldNavigateToSecondView = false;
        shouldShowError = false;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public boolean isHasArmrests() { return hasArmrests; }
    public void setHasArmrests(boolean hasArmrests) { this.hasArmrests = hasArmrests; }

    public boolean isShouldNavigateToSecondView() { return shouldNavigateToSecondView; }
    public void setShouldNavigateToSecondView(boolean shouldNavigate) { this.shouldNavigateToSecondView = shouldNavigate; }

    public boolean isShouldShowError() { return shouldShowError; }
    public void setShouldShowError(boolean shouldShowError) { this.shouldShowError = shouldShowError; }

    public Chair toChair() {
        int parsedHeight = 0;
        float parsedPrice = 0f;
        try {
            parsedHeight = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            parsedHeight = 0;
        }
        try {
            parsedPrice = Float.parseFloat(price);
        } catch (NumberFormatException e) {
            parsedPrice = 0f;
        }

        return new Chair(
                material,
                color,
                parsedHeight,
                parsedPrice,
                hasArmrests
        );
    }

    public static MainActivityChairModel fromChair(Chair chair) {
        MainActivityChairModel model = new MainActivityChairModel();
        model.setMaterial(chair.getMaterial());
        model.setColor(chair.getColor());
        model.setHeight(String.valueOf(chair.getHeight()));
        model.setPrice(String.valueOf(chair.getPrice()));
        model.setHasArmrests(chair.isHasArmrests());
        return model;
    }
}
