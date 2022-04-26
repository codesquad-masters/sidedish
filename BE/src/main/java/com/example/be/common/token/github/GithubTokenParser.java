package com.example.be.common.token.github;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GithubTokenParser {

    private static final String USER_INFORMATION_DELIMETER = ",";
    private static final String USER_INFORMATION_DETAIL_DELIMETER = ":";
    private static final int KEY = 0;

    public Map<String, String> getUserInformation(String userInformationString) {
        Map<String, String> userInformationMap = new HashMap<>();
        String[] userInformation = userInformationString.split(USER_INFORMATION_DELIMETER);
        for (String keyAndValue : userInformation) {
            String[] userInformationDetail = keyAndValue.split(USER_INFORMATION_DETAIL_DELIMETER);
            String key = userInformationDetail[KEY];
            String value = getValue(userInformationDetail);
            userInformationMap.put(key, value);
        }
        return userInformationMap;
    }

    private String getValue(String[] userInformationDetail) {
        return Arrays.stream(userInformationDetail, 1, userInformationDetail.length)
                .collect(Collectors.joining());
    }
}