import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {

        File phoneNumberFile = new File("src\\doc\\PhoneNumbers.txt");
        final ArrayList<String> allPhoneNumbers = getPhoneNumbersFromFile(phoneNumberFile);

        String[] mtnNumbers = { "0703", "0706", "0803", "0806", "0810", "0813", "0814", "0816", "0903", "0906", "0913",
                "0916", "07025", "07026", "0704" };
        String[] airtelNumbers = { "0701", "0708", "0802", "0808", "0812", "0901", "0902", "0904", "0907", "0912" };
        String[] globalComNumbers = { "0705", "0805", "0807", "0811", "0815", "0905", "0915" };
        String[] nineMobileNumebrs = { "0809", "0817", "0818", "0909", "0908" };
        String[] mTelNumbers = { "0804" };

        String[] phoneNumbersAsStringList = allPhoneNumbers.toArray(String[]::new);

        List<String> matchedMtnNumbers = numberFinder(phoneNumbersAsStringList, mtnNumbers);
        List<String> matchedAirtelNumbers = numberFinder(phoneNumbersAsStringList, airtelNumbers);
        List<String> matchedGlobalComNumbers = numberFinder(phoneNumbersAsStringList, globalComNumbers);
        List<String> matchedNineMobileNumbers = numberFinder(phoneNumbersAsStringList, nineMobileNumebrs);
        List<String> matchedMTelMobileNumbers = numberFinder(phoneNumbersAsStringList, mTelNumbers);


        int mtnNumberSize = matchedMtnNumbers.size();
        int airtelNumberSize = matchedAirtelNumbers.size();
        int globalComNumberSize = matchedGlobalComNumbers.size();
        int nineMobileNumberSize = matchedNineMobileNumbers.size();
        int mTelNumberSize = matchedMTelMobileNumbers.size();

        int totalNumberSize = mtnNumberSize + airtelNumberSize + globalComNumberSize + nineMobileNumberSize + mTelNumberSize;


        System.out.println("Mtn Number Size is: " + mtnNumberSize);
        System.out.println("Airtel Number Size is: " + airtelNumberSize);
        System.out.println("Global Com Number Size is: " + globalComNumberSize);
        System.out.println("Nine Mobile Number Size is: " + nineMobileNumberSize);
        System.out.println("MTel Number Size is: " + mTelNumberSize);
        System.out.println("Total Number Size is: " + totalNumberSize);


    }

    private static List<String> numberFinder(String[] numberString, String[] matchNumbers) {
        Stream<String> numberStream = Arrays.stream(numberString);
        List<String> allMatches = numberStream
                .filter(number -> {
                    return Stream.of(matchNumbers).anyMatch(number::startsWith);
                })
                .collect(Collectors.toList());
        return allMatches;
    }

    private static ArrayList<String> getPhoneNumbersFromFile(File file) throws IOException {
        ArrayList<String> allNumbers = new ArrayList<>();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
            String currentNumber;
            while ((currentNumber = bufferReader.readLine()) != null) {
                allNumbers.add(currentNumber);

            }
        }

        return allNumbers;
    }

}
