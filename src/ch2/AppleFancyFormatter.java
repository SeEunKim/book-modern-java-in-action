package ch2;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple a) {
        String c = a.getWeight() > 150 ? "heavy" : "light";
        return "A " + c + " " + a.getWeight() + " apple";
    }
}
