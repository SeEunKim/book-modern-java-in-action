package ch2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ch2 {
    private FilterService service = new FilterService();

    public void main() {
        List<Apple> inventory = new ArrayList<>();
        List<Apple> greenApples = service.filterApplesByColor(inventory, Color.GREEN);
        List<Apple> redApples = service.filterApplesByColor(inventory, Color.RED);

        List<Apple> greenAples1 = service.filterApples(inventory, Color.GREEN, 0,true);
        List<Apple> greenAples2 = service.filterApples(inventory, null, 150, false);

        List<Apple> redAndHeavyApples = service.filterApples(inventory, new AppleRedAndHeavyPredicate());

        service.prettyPrintApple(inventory, new AppleFancyFormatter());

        // 다섯 번째 시도 : 익명 클래스 사용
        List<Apple> redApples1 = service.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        // 여섯 번째 시도 : 람다 표현식 사용
        List<Apple> redApples2 = service.filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        // 일곱 번째 시도 : 리스트 형식으로 추상화
        List<Apple> greenApples2 = service.filter(inventory, (Apple apple) -> Color.GREEN.equals(apple.getColor()));
        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = service.filter(numbers, (Integer i) -> i % 2 == 0);
    }
}
