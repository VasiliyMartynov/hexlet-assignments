package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

// BEGIN
public class App {
    private static final  List<String> FREE_EMAILS_DOMAINS = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");
    public static long getCountOfFreeEmails(List<String> emails) {
        long count = emails.stream()
                .filter(email -> StringUtils.isNotBlank(email))
                .filter(email -> isFreeDomain(FREE_EMAILS_DOMAINS, email))
                .collect(Collectors.counting());
        return count;
    }
    private static Boolean isFreeDomain(List<String> domainList, String email) {
        String[] domainOfEmail = email.split("@");
        Boolean isContains = domainList.stream()
                .anyMatch(item -> item.equals(domainOfEmail[1]));

        return  isContains;
    }

}
// END
