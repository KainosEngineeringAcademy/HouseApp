import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class HouseTest {
    public static void main(String[] args) {
        House myHouse = new House(9,"", 2.2, "", 3, 3);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ZoneId defaultZoneId = ZoneId.systemDefault();

        LocalDate localDate = LocalDate.parse("03/12/1940", format);
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        myHouse.setBuildDate(date);

        House yourHouse = new House(9,"", 2.2, "", 3, 3, HouseType.BUNGALOW);

        localDate = LocalDate.parse("12/03/2023", format);
        date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        yourHouse.setBuildDate(date);

        House someonesHouse = new House(10,"A", 20.2, "", 3, 3, HouseType.BUNGALOW);
        Date anotherDate = new Date(700000000000L);
        someonesHouse.setBuildDate(anotherDate);


        // Add to a list
        ArrayList<House> culdesac = new ArrayList<>();
        culdesac.add(myHouse);
        culdesac.add(yourHouse);
        culdesac.add(someonesHouse);

        getHousesBuiltWithin5Years(culdesac);
    }

    private static void getHousesBuiltWithin5Years(ArrayList<House> houses) {
        Date fiveYearsAgo = Date.from(Instant.now().minus(Duration.ofDays(5 * 365)));
        houses.stream()
                .filter(HouseTest::byBuildDate)
                .forEach(System.out::println);
    }

    private static boolean byBuildDate(House house) {
        Date buildDate = house.getBuildDate();
        LocalDate localDate = LocalDate.ofInstant(buildDate.toInstant(), ZoneId.systemDefault());
        LocalDate lastWeek = LocalDate.now().minusYears(5);
        return localDate.isAfter(lastWeek);
    }

    private static void getHousesBuiltWithin5YearsAlt(ArrayList<House> houses) {
        Date fiveYearsAgo = Date.from(Instant.now().minus(Duration.ofDays(5 * 365)));
        houses.stream()
                .filter(house -> house.getBuildDate().after(fiveYearsAgo))
                .forEach(System.out::println);
    }


}
